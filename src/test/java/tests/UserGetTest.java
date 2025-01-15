package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lib.ApiCoreRequests;
import lib.Assertions;
import lib.BaseTestCase;
import lib.DataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static lib.Assertions.assertResponseCodeEquals;

@Epic("CRUD cases")
@Feature("Read user data")
public class UserGetTest extends BaseTestCase {
    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @Test // получение данных пользователя, когда мы НЕ авторизованы
    public void testGetUserDataNotAuth() {
        Response responseUserData = RestAssured
                .get(this.getApiURL() + "user/2")
                // логика: если запрос данных из-под авторизованного пользователя, в ответе должны быть ВСЕ поля
                // если запрос для чужого пользователя, мы должны видеть только username
                .andReturn();

        //System.out.println(responseUserData.asString()); // ответ {"username":"Vitaliy"}
        String[] expectedFields = {"password", "firstName", "lastName", "email"};
        Assertions.assertJsonHasNotFields(responseUserData, expectedFields);
    }

    @Test
    public void testGetUserDetailsAuthAsSameUser () {
        // чтобы авторизоваться под пользователем с id = 2, мы должны сделать запрос с существующими данными vinkotov@example.com и паролем = '1234'
        // затем, в последующий запрос подставлять полученные cookie и header
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response responseGetAuth = RestAssured
                .given()
                .body(authData)
                .post(this.getApiURL() + "user/login")
                .andReturn();

        //вынимаем из запроса Header и cookie:
        String header = this.getHeader(responseGetAuth, "x-csrf-token");
        String cookie = this.getCookie(responseGetAuth, "auth_sid");

        // подставляем куки в заголовок запроса:
        Response responseUserData = RestAssured
                .given()
                .header("x-csrf-token", header)
                .cookie("auth_sid", cookie)
                .get(this.getApiURL() + "user/2")
                .andReturn();


        //применим новый метод assertJsonHasFields вместо старых assertions
        String[] expectedFields = {"username", "firstName", "lastName", "email"};
        Assertions.assertJsonHasFields(responseUserData, expectedFields);
    }

    // Exercise 16
    @Description("This test checks that response contains username only when perform login under existing user")
    @DisplayName("Test negative gets user data with another auth user")
    @Test
    public void testGetUserDetailsAuthAsAnotherUser () {
        // create new user with random email and default data from getRegistrationData method
        Map<String, String> userData;
        userData = DataGenerator.getRegistrationData();
        JsonPath response = apiCoreRequests
                .makePostRequest(this.getApiURL() + "user/", userData)
                .jsonPath();

        int idNewUser = response.getInt("id");
        // System.out.println("id: " + idNewUser);

        userData.put("email", "vinkotov@example.com");
        userData.put("password", "1234");
        Response responseGetAuth = apiCoreRequests
                .makePostRequest(this.getApiURL() + "user/login", userData)
                .andReturn();

        String header = this.getHeader(responseGetAuth, "x-csrf-token");
        String cookie = this.getCookie(responseGetAuth, "auth_sid");


        // передаем данные существующего пользователя в заголовок запроса и id другого пользователя:
        Response responseUserData = apiCoreRequests
                .makeGetRequest(this.getApiURL() + "user/" + idNewUser, header, cookie)
                .andReturn();

        assertResponseCodeEquals(responseUserData, 200);
        Assertions.assertJsonHasField(responseUserData, "username");
        String[] unexpectedFields = {"password", "firstName", "lastName", "email"};
        Assertions.assertJsonHasNotFields(responseUserData, unexpectedFields);
    }
}
