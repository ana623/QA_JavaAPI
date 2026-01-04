package archive;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueTest {

    @Test
    //1. Правильный URL
    public void  checkResponseStatusForCorrectUrl(){
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/map")
                .andReturn();
        //assertTrue возвращает boolean значение, сравнивая выражения слева и справа от ==
        assertTrue(response.statusCode() ==200, "Unexpected status code");
    }


    @Test
    //2. Неравильный URL
    public void  checkResponseStatusForIncorrectUrl(){
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/map2")
                .andReturn();
        //assertTrue возвращает boolean значение, сравнивая выражения слева и справа от ==
        assertTrue(response.statusCode() ==200, "Unexpected status code");
    }
}