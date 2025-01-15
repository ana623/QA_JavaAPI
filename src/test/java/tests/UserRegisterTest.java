package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.ApiCoreRequests;
import lib.Assertions;
import lib.BaseTestCase;
import lib.DataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static lib.Assertions.assertJsonHasField;
import static lib.Assertions.assertResponseCodeEquals;

@Epic("CRUD cases")
@Feature("Create user")
public class UserRegisterTest extends BaseTestCase {
    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @Test
    // negative test
    public void testCreateUserWithExistingEmail () {
        String email = "vinkotov@example.com";
        // заменим то, как мы генерим данные пользователя, на новый метод из DataGenerator
        Map<String,String> userData = new HashMap<>();
        userData.put("email", email);
        userData = DataGenerator.getRegistrationData(userData); //new! работает новый метод getRegistrationData.
        // так как передается хэшмап, то параметры password, username, firstName, lastName будут дефолтными, кроме email
        // строки ниже больше не неужны:
        // userData.put("password", "123");
        // userData.put("username", "learnqa");
        // userData.put("firstName", "learnqa");
        // userData.put("lastName", "learnqa");

        // отправляем эти данные в запрос CreateUser

        Response responseCreateAuth = RestAssured
                .given()
                .body(userData)
                .post(this.getApiURL() + "user/")
                .andReturn();
        // System.out.println(responseCreateAuth.asString());
        // System.out.println(responseCreateAuth.statusCode());

        //run test : error 400 Users with email 'vinkotov@example.com' already exists . Это ок, т.к. email такой уже действительно существует
        //зафиксируем это. Добавим в класс Assertions еще 2 метода, в котором будем проверять, что ответ сервера равен ожэидаемому

        // добавили 2 метода . Теперь используем их:
        assertResponseCodeEquals(responseCreateAuth, 400);
        Assertions.assertResponseTextEquals(responseCreateAuth, "Users with email '" + email + "' already exists");
    }

    @Test
    // positive test, но email будем получать из новой функции DataGenerator и проверять, что код ответа будет = 200
    public void testCreateUserSuccessfully () {
        // тут тоже применим мновый метод из DataGenerator
        // но, так как нам отсюда уже ничего не нужно, просто пишем
        Map<String,String> userData = DataGenerator.getRegistrationData();

        Response responseCreateAuth = RestAssured
                .given()
                .body(userData)
                .post(this.getApiURL() + "user/")
                .andReturn();

        assertResponseCodeEquals(responseCreateAuth, 200);
        //System.out.println(responseCreateAuth.asString()); // в ответ на запрос: приходит json {"id":"114082"} с id только что созданного user
        // проверим, что в json есть поле "id" - добавим новый метод в Asserstions - assertJsonHasKey:
        assertJsonHasField(responseCreateAuth, "id");
    }

    // Exercise 15.1
    @Test
    @Description("This test checks response status code and error message at attempt to create user with wrong email")
    @DisplayName("Test negative create user with wrong email")
    public void testCreateUserWithWrongEmail () {
        String wrongEmail = "vinkotov_example.com";
        Map<String, String> userData = new HashMap<>();
        userData.put("email", wrongEmail);
        userData = DataGenerator.getRegistrationData(userData);
        Response response = apiCoreRequests // вместо RestAssured
                .makePostRequest(this.getApiURL() + "user/", userData);

        assertResponseCodeEquals(response, 400);
        Assertions.assertResponseTextEquals(response, "Invalid email format");
    }


    // Exercise 15.2 - ParametrizedTest
    @Description("This test checks response status code and error message at attempt to create user without 1 mandatory field")
    @DisplayName("Test negative create user without 1 mandatory field")
    @ParameterizedTest
    @ValueSource(strings = {"email", "password","username", "firstName", "lastName"})
    public void testCreateUserWithoutOneField (String missingParam) {
        Map<String, String> userData = new HashMap<>();
        userData = DataGenerator.getRegistrationData(userData);
        userData.remove(missingParam);
        Response response = apiCoreRequests // вместо RestAssured
                .makePostRequest(this.getApiURL() + "user/", userData);

        assertResponseCodeEquals(response, 400);
        Assertions.assertResponseTextEquals(response, "The following required params are missed: " + missingParam);
    }

    // Exercise 15.3
    @Test
    @Description("This test checks response status code and error message at attempt to create user with name = 1 symbol")
    @DisplayName("Test negative create user with short name")
    public void testCreateUserWithShortName () {
        String WrongUsername = "a";
        Map<String, String> userData = new HashMap<>();
        userData.put("username", WrongUsername);
        userData = DataGenerator.getRegistrationData(userData);
        Response response = apiCoreRequests // вместо RestAssured
                .makePostRequest(this.getApiURL() + "user/", userData);

        assertResponseCodeEquals(response, 400);
        Assertions.assertResponseTextEquals(response, "The value of 'username' field is too short");
    }

    // Exercise 15.4
    @Test
    @Description("This test checks response status code and error message at attempt to create user with name > 250 symbols")
    @DisplayName("Test negative create user with long name")
    public void testCreateUserWithLongName () {
        String WrongUsername = "a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890a234567890123456";
        Map<String, String> userData = new HashMap<>();
        userData.put("username", WrongUsername);
        userData = DataGenerator.getRegistrationData(userData);
        Response response = apiCoreRequests // вместо RestAssured
                .makePostRequest(this.getApiURL() + "user/", userData);

        assertResponseCodeEquals(response, 400);
        Assertions.assertResponseTextEquals(response, "The value of 'username' field is too long");
    }
}
