import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestGetResponse {
    @Test
    public void  testGetResponse(){
        Response resp;
        resp = RestAssured.get("https://playground.learnqa.ru/api/get_text").andReturn();
        String body = resp.getBody().asString();
        System.out.println(body);
    }
}
