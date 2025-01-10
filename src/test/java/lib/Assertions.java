package lib;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assertions {
    // вход: объект с ответом сервера, чтобы вытянуть из него текст, имя, по которому нужно будет искать значение в Json и ожидаемле значение
    // выход: ассерт, где эта функция сравнивает expected value и value полученное из Json. Если неправильное, выдается ошибка
    public static void assertJsonByName (Response Response, String name, int expectedValue) {
        Response.then().assertThat().body("$", hasKey(name));

        int value = Response.jsonPath().getInt(name);
        assertEquals(expectedValue, value, "JSON value is not equal to expected value");
    }
}
