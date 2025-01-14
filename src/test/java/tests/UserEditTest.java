package tests;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lib.ApiCoreRequests;
import lib.BaseTestCase;
import lib.DataGenerator;
import lib.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserEditTest extends BaseTestCase {
    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @Test
    // создаем пользователя, потом редактируем, потом проверяем, что мы успешно его отредактировали c помощью метода получения данных о пользователе
    // для редактирования и получения данных нам требуется авторизоваться этим пользователем
    // итого, будет комплексный тест из 4х запросов:
    // 1. создание пользователя, 2. авторизация, 3. редактирование, 4. получение данных

    // подготовим данные для создания пользователя, в том числе емейл (будем использовать генератор getRandomEmail из DataGenerator)
    // создадим еще 2 метода в DataGenerator - getRegistrationData и
    public void testEditJustCreatedTest() {
        // GENERATE USER
        Map<String, String> userData = DataGenerator.getRegistrationData();

        JsonPath responseCreateAuth = RestAssured
                .given()
                .body(userData)
                .post("https://playground.learnqa.ru/api/user/")
                .jsonPath();

        String userId = responseCreateAuth.getString("id");

        //LOGIN
        Map<String,String> authData = new HashMap<>();
        authData.put("email", userData.get("email"));
        authData.put("password", userData.get("password"));

        Response responseGetAuth = RestAssured
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/user/login")
                .andReturn();

        //EDIT (PUT)
        // в запрос будем передавать токен, авторизационную куки и поле, которое будем менять - firstName, с новым значением changedName
        String newName = "Changed Name";
        Map<String, String> editData= new HashMap<>();
        editData.put("firstName", newName);

        Response responseEditUser = RestAssured
                .given()
                .header("x-csrf-token", this.getHeader(responseGetAuth, "x-csrf-token"))
                .cookie("auth_sid", this.getCookie(responseGetAuth, "auth_sid"))
                .body(editData)
                .put("https://playground.learnqa.ru/api/user/" + userId)
                .andReturn();

        System.out.println("responseEditUser = " + responseEditUser.asString());
        // возвращается при запросе под авторизованным пользователем responseEditUser = {"success":"!"}
        // под Неавторизованным пользоватлем возвращается: {"error": "Auth token not supplied"}

        //GET
        // делаем авторизованный get запрос на получение данных, а затем убеждаемся, что в ответе firstName = новому имени
        Response responseUserData = RestAssured
                .given()
                .header("x-csrf-token", this.getHeader(responseGetAuth, "x-csrf-token"))
                .cookie("auth_sid", this.getCookie(responseGetAuth, "auth_sid"))
                .get("https://playground.learnqa.ru/api/user/" + userId)
                .andReturn();

        // System.out.println(responseUserData.asString()); // результат: firstName changed -  {"id":"114301","username":"learnqa","email":"learnqa20250113003740@example.com","firstName":"Changed Name","lastName":"learnqa"}
        //теперь заменим print на assert, откроме класс Assertions
        // метод assertJasonByName не очень подойдет, так как в нем expected value Типа Int, а нам надо убедиться, что СТРОКА firstName = ожидаемой СТРОКЕ
        // то есть надо создать новый метод, с таким же именем, но с другим набором параметров (см. Assertions)

        Assertions.assertJsonByName(responseUserData, "firstName", newName);
    }


    // Exercise 17.1
    @Description("This test attempts to modify user without authorisation")
    @DisplayName("Test negative modify user w/o auth")
    @Test
    public void testEditUserNotAuth() {
        String newName = "Changed Name";
        Map<String, String> editData = new HashMap<>();
        editData.put("firstName", newName);

        Response responsePutData = apiCoreRequests
                .makePutRequest("https://playground.learnqa.ru/api/user/2", editData)
                .andReturn();
        // под Неавторизованным пользоватлем возвращается: {"error": "Auth token not supplied"}
        Assertions.assertJsonByName(responsePutData, "error", "Auth token not supplied");
    }

    // Exercise 17.2
    @Description("This test attempts to modify user with authorisation under existing user")
    @DisplayName("Test negative modify user data with another auth user")
    @Test
    public void testEditUserAuthAsAnotherUser() {
        String newName = "Changed Name";
        Map<String, String> editData = new HashMap<>();
        editData.put("firstName", newName);

        Response responsePutData = apiCoreRequests
                .makePutRequest("https://playground.learnqa.ru/api/user/2", editData)
                .andReturn();
        // под Неавторизованным пользоватлем возвращается: {"error": "Auth token not supplied"}
        Assertions.assertJsonByName(responsePutData, "error", "Auth token not supplied");
    }

    // Exercise 17.3
    @Description("This test attempts to modify user email -> wrong email with authorisation under same user")
    @DisplayName("Test negative modify user email with same auth user")
    @Test
    public void testEditEmail() {
        // GENERATE USER
        Map<String, String> userData = DataGenerator.getRegistrationData();
        Response responseGetAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user", userData)
                .andReturn();

        String email = userData.get("email");
        String password = userData.get("password");
        int userId = getIntFromJason(responseGetAuth, "id");

        //LOGIN as existing user
        userData = new HashMap<>(); // очистили HashMap
        userData.put("email", email);
        userData.put("password", password);

        responseGetAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/login", userData)
                .andReturn();

        String header = this.getHeader(responseGetAuth, "x-csrf-token");
        String cookie = this.getCookie(responseGetAuth, "auth_sid");

        // EDIT (PUT)
        // change email to not valid email without @
        String emailWrong = "user.example.com";
        Map<String, String> editData = new HashMap<>();
        editData.put("email", emailWrong);

        Response responsePutData = apiCoreRequests
                .makePutRequest("https://playground.learnqa.ru/api/user/" + userId, editData, header, cookie)
                .andReturn();

        // System.out.println("responsePutData = " + responsePutData.asString()); - вернулось responsePutData = {"error":"Invalid email format"}
        Assertions.assertJsonByName(responsePutData, "error", "Invalid email format");
    }

    // Exercise 17.4
    @Description("This test attempts to modify user firstName -> 1 symbol firstName with authorisation under same user")
    @DisplayName("Test negative modify user firstName with same auth user")
    @Test
    public void testEditFirstName() {
        // GENERATE USER
        Map<String, String> userData = DataGenerator.getRegistrationData();
        Response responseGetAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user", userData)
                .andReturn();

        String email = userData.get("email");
        String password = userData.get("password");
        int userId = getIntFromJason(responseGetAuth, "id");

        //LOGIN as existing user
        userData = new HashMap<>(); // очистили HashMap
        userData.put("email", email);
        userData.put("password", password);

        responseGetAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/login", userData)
                .andReturn();

        String header = this.getHeader(responseGetAuth, "x-csrf-token");
        String cookie = this.getCookie(responseGetAuth, "auth_sid");

        // EDIT (PUT)
        // change firstName to 1 symbol name
        String firstNameShort = "X";
        Map<String, String> editData = new HashMap<>();
        editData.put("firstName", firstNameShort);

        Response responsePutData = apiCoreRequests
                .makePutRequest("https://playground.learnqa.ru/api/user/" + userId, editData, header, cookie)
                .andReturn();

        //System.out.println("responsePutData = " + responsePutData.asString()); //  вернулось responsePutData = {"error":"The value for field `firstName` is too short"}
        Assertions.assertJsonByName(responsePutData, "error", "The value for field `firstName` is too short");
    }

}
