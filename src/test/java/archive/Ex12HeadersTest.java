package archive;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex12HeadersTest {

    @Test
    public void testCookie() {
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers headers = response.getHeaders();

        // 1. Проверяем, что пришел статус код 200
        assertEquals(200, response.statusCode(), "Unexpected status code");
        // 2. Проверяем, что во всем списке headers содержится header "x-secret-homework-header"
        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"), "Response doesn't have 'x-secret-homework-header' header");
        // 3. Проверяем value
        assertEquals("Some secret value", headers.get("x-secret-homework-header").getValue(), "Header value is not valid");
    }
}