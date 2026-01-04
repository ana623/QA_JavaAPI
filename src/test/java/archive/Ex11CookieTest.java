package archive;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex11CookieTest {

    @Test
    public void testCookie() {
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String, String> cookies = response.getCookies();
        // Headers headers = responseGetAuth.getHeaders();

        // 1. Проверяем, что пришел статус код 200
        assertEquals(200, response.statusCode(), "Unexpected status code");
        // 2. Проверяем, что во всем списке cookies содержится cookie HomeWork
        assertTrue(cookies.containsKey("HomeWork"), "Response doesn't have HomeWork cookie");
        // 3. Проверяем value
        assertEquals("hw_value", cookies.get("HomeWork"), "Cookie value is not valid");
    }
}