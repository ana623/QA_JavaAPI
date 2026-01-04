package archive;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqualsTest {

    @Test
    //1. Верный URL, ожидаем 200, вернется 200
    public void  testFor200(){
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/map")
                .andReturn();
        //assertEquals сравнивает Expected (первый параметр) с Actual (из респонса, второй параметр)
        assertEquals(200, response.statusCode(),"Unexpected status code");
    }
    @Test
    //2. Неверный URL, ожидаем 404, вернется 404
    public void  testFor404(){
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/map2")
                .andReturn();
        //assertEquals сравнивает Expected (первый параметр) с Actual (из респонса, второй параметр)
        assertEquals(404, response.statusCode(),"Unexpected status code");
    }
}