package archive;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

public class JsonParsTest {

    @Test
    public void testReturnAnswer() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "John");
        JsonPath response = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.get("answer");
        if (answer == null) {
            System.out.println("The key 'answer' is absent");
        } else {
            System.out.println(answer);
        }

    }

    @Test
    public void testReturnResponseType() {
        Response response = RestAssured
                .given()
                .queryParam("param1", "value1")
                .queryParam("param2", "value2")
                .get("https://playground.learnqa.ru/api/check_type")
                .andReturn();
        response.print();
    }

    @Test
    public void testReturnPostParams1() {
        Response response = RestAssured
                .given()
                .body("param1=value1&param2=value2")
                .post("https://playground.learnqa.ru/api/check_type")
                .andReturn();
        response.print();
    }

    @Test
    public void testReturnPostParams2() {
    Map<String,Object> body = new HashMap<>();
    body.put("param1","value1");
    body.put("param2","value2");

        Response response = RestAssured
                .given()
                .body(body)
                .post("https://playground.learnqa.ru/api/check_type")
                .andReturn();
        response.print();
    }

    @Test
    public void testReturnStatusCode200() {
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/check_type")
                .andReturn();
        int statusCode=response.getStatusCode();
        System.out.println(statusCode);
    }

    @Test
    public void testReturnStatusCode303() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();
        int statusCode=response.getStatusCode();
        System.out.println(statusCode);
    }

    @Test
    public void testReturnRequestAndResponseHeaders() {
        Map<String,String> headers = new HashMap<>();
        headers.put("MyHeader1","MyValue1");
        headers.put("MyHeader2","MyValue2");
        Response response = RestAssured
                .given()
                .headers(headers)
                .when()
                .get("https://playground.learnqa.ru/api/show_all_headers")
                .andReturn();
        response.prettyPrint();

        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);
    }

    @Test
    public void testReturnResponseRedirectLocation() {
        Map<String,String> headers = new HashMap<>();
        headers.put("MyHeader1","MyValue1");
        headers.put("MyHeader2","MyValue2");
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();
        response.print();

        String headerLocation = response.getHeader("Location");
        System.out.println(headerLocation);
    }
}
