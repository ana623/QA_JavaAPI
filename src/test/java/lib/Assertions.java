package lib;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assertions {
    // вход: объект с ответом сервера, чтобы вытянуть из него текст, имя, по которому нужно будет искать значение в Json и ожидаемое значение
    // выход: ассерт, где эта функция сравнивает expected value и value полученное из Json. Если неправильное, выдается ошибка
    public static void assertJsonByName (Response Response, String name, int expectedValue) {
        Response.then().assertThat().body("$", hasKey(name)); // $ - root element

        int value = Response.jsonPath().getInt(name);
        assertEquals(expectedValue, value, "JSON value is not equal to expected value");
    }
    //такой же метод, как предыдущий, только проверяет String значение вместо int:
    public static void assertJsonByName (Response Response, String name,  String expectedValue) {
        Response.then().assertThat().body("$", hasKey(name)); // $ - root element

        String value = Response.jsonPath().getString(name);
        assertEquals(expectedValue, value, "JSON value is not equal to expected value");
    }

    public static void assertResponseTextEquals (Response Response, String expectedAnswer) {
        assertEquals(
                expectedAnswer,
                Response.asString(),
                "Response text is not as expected"
                );
    }
    public static void assertResponseCodeEquals (Response Response, int expectedStatusCode) {
        assertEquals(
                expectedStatusCode,
                Response.statusCode(),
                "Response code is not as expected"
        );
    }
    /*
    //метод проверяет, что приходит поле с определенным именем
    public static void assertJsonHasKey(Response Response, String expectedFieldName) {
        Response.then().assertThat().body("$", hasKey(expectedFieldName));
    }
    // метод проверяет, что в ответе нет каких-то имен полей
    public static void assertJsonHasNotKey (Response Response, String unexpectedFieldName) {
        Response.then().assertThat().body("$", not(hasKey(unexpectedFieldName)));
    }
    */

    // заменили Key на Field в названии методов, для совместимости с новым методом assertJsonHasFields - см. ниже
    public static void assertJsonHasField(Response Response, String expectedFieldName) {
        Response.then().assertThat().body("$", hasKey(expectedFieldName));
    }
    public static void assertJsonHasNotField (Response Response, String unexpectedFieldName) {
        Response.then().assertThat().body("$", not(hasKey(unexpectedFieldName)));
    }

    // улучшение: новая функция, которая будет проверять сразу НЕСКОЛЬКО полей
    public static void assertJsonHasFields(Response Response, String[] expectedFieldNames) {
        for (String expectedFieldName: expectedFieldNames) {
            Assertions.assertJsonHasField(Response, expectedFieldName);
        }
    }

    // проверка, что ответ НЕ содержит набор полей
    public static void assertJsonHasNotFields(Response Response, String[] unexpectedFieldNames) {
        for (String unexpectedFieldName: unexpectedFieldNames) {
            Assertions.assertJsonHasNotField(Response, unexpectedFieldName);
        }
    }
}
