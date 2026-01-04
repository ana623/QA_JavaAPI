package archive;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class Ex8LongJobTest {

    @Test
    public void getResponse() throws InterruptedException {
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        String responseToken = response.get("token");
        int responseSeconds = response.get("seconds");
        System.out.println("token: " + responseToken);
        System.out.println("seconds: " + responseSeconds);

        getResponseAndCheckResults(responseToken); // вызов вспомогательного метода проверки

        Thread.sleep(responseSeconds * 1000);

        getResponseAndCheckResults(responseToken);
    }

    private void getResponseAndCheckResults(String responseToken) {
        JsonPath response = RestAssured
                .given()
                .queryParam("token", responseToken)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        String responseStatus = response.get("status");
        String responseResult = response.get("result");
        String responseError = response.get("error");

        if(responseError !=null) {
            System.out.println("error: " + responseError);
        } else if(responseStatus.equals("Job is ready") && responseResult != null) {
            System.out.println("status: " + responseStatus);
            System.out.println("result: " + responseResult);
        } else if(responseStatus.equals("Job is NOT ready") && responseResult == null) {
            System.out.println("status: " + responseStatus);
        } else System.out.println("invalid response parameters");
    }
}
