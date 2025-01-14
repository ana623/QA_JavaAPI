package tests;

import io.restassured.response.Response;
import lib.BaseTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lib.Assertions;
import lib.ApiCoreRequests;

import java.util.HashMap;
import java.util.Map;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;

@Epic("Authorisation cases")
@Feature("Authorisation")
public class UserAuthTest extends BaseTestCase {

    String cookie;
    String header;
    int userIdOnAuth;
    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @BeforeEach
    public void loginUser () {
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");
        //новая запись c использованием apiCoreRequests:
        Response responseGetAuth = apiCoreRequests // вместо RestAssured
                .makePostRequest("https://playground.learnqa.ru/api/user/login", authData);
        /* старое:
        Response responseGetAuth = RestAssured
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/user/login")
                .andReturn();
        */
        this.cookie = this.getCookie(responseGetAuth,"auth_sid");
        this.header = this.getHeader(responseGetAuth,"x-csrf-token");
        this.userIdOnAuth = this.getIntFromJason(responseGetAuth,"user_id");

    }

    @Test
    @Description("This test successfully authorize user by email and password")
    @DisplayName("Test positive auth user")
    public void testAuthUser () {
        Response responseCheckAuth = apiCoreRequests
                .makeGetRequest(
                        "https://playground.learnqa.ru/api/user/auth",
                        this.header,
                        this.cookie
                );
        Assertions.assertJsonByName(responseCheckAuth, "user_id", this.userIdOnAuth);

    }

    @Description("This test checks authorization status without sending auth cookie or token")
    @DisplayName("Test negative auth user")
    @ParameterizedTest
    @ValueSource(strings = {"cookie","headers"})
    public void testNegativeAuthUser (String condition) {

        if (condition.equals("cookie")){
            Response responseForCheck = apiCoreRequests.makeGetRequestWithCookie(
                    "https://playground.learnqa.ru/api/user/auth",
                    this.cookie
            );
            Assertions.assertJsonByName(responseForCheck, "user_id", 0);
        } else if (condition.equals("headers")){
            Response responseForCheck = apiCoreRequests.makeGetRequestWithToken(
                    "https://playground.learnqa.ru/api/user/auth",
                    this.header
            );
            Assertions.assertJsonByName(responseForCheck, "user_id", 0);
        } else {
            throw new IllegalArgumentException("Condition value is not known: " + condition);
        }

        /* Старый код:
        if (condition.equals("cookie")) {
            spec.cookie("auth_sid", this.cookie); // если в качестве параметра пришло cookie, то будем передавать только cookie
        } else if (condition.equals("headers")) {
            spec.header("x-csrf-token", this.header); // если пришло значение header, то передаем только header
        } else {
            throw new IllegalArgumentException("Condition value is known: " + condition);
        }

        Response responseForCheck = spec.get().andReturn();
        // используем наш кастомный ассерт:
        Assertions.assertJsonByName(responseForCheck, "user_id", 0);
        */
    }
}