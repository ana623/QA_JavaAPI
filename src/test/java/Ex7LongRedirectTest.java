import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class Ex7LongRedirectTest {
    @Test
    public void testGetResponse() {
        String url = "https://playground.learnqa.ru/api/long_redirect";
        int statusCode = 0;
        int counter = 0;
        while (statusCode != 200) {
            Response resp;
            resp = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(url)
                    .andReturn();
            statusCode = resp.getStatusCode();
            if (statusCode >= 300 && statusCode <=399 ) {
                url = resp.getHeader("Location");
                // System.out.println(resp.getHeader("Location"));
                counter = counter+1;
            }
        }
        System.out.println("Number of redirects = " + counter);
    }
}
