package archive;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestGetResponse {
    @Test
    public void testGetResponse() {
        Response resp;
        resp = RestAssured.get("https://playground.learnqa.ru/api/get_text").andReturn();
        String body = resp.getBody().asString();
        System.out.println(body);
        System.out.println(resp.getHeader("Content-type"));
    }
}
/*
    @Test
    public void  testGetResponse2(){
        System.out.println("Empty test");
    }

    public void notATest() {
        int x = 1000+2000;
        System.out.println("blablabla " + x);
    }
}
*/