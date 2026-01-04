package archive;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Ex6RedirectTest {
    @Test
    public void testGetResponse() {
        Response resp;
        resp = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();
        System.out.println(resp.getHeader("Location"));
    }
}
