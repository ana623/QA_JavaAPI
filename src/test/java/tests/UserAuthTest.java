package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lib.BaseTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lib.Assertions;

import java.util.HashMap;
import java.util.Map;

public class UserAuthTest extends BaseTestCase {

    String cookie;
    String header;
    int userIdOnAuth;

    @BeforeEach
    public void loginUser () {
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response responseGetAuth = RestAssured // также сюда переносим 1й запрос на логин нашего пользователя
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/user/login")
                .andReturn();

        this.cookie = this.getCookie(responseGetAuth,"auth_sid");
        this.header = this.getHeader(responseGetAuth,"x-csrf-token");
        this.userIdOnAuth = this.getIntFromJason(responseGetAuth,"user_id");

    }

    @Test
    public void testAuthUser () {

        // воспользуемся методом из Assertions.assertJsonByName
        Response /*JsonPath*/ responseCheckAuth = RestAssured
                .given()
                // здесь будем использовать вместо переменной которая была внутри класса, переменную из другого класса, описанную выше
                .header("x-csrf-token", this.header)
                .cookie("auth_sid", this.cookie)
                .get("https://playground.learnqa.ru/api/user/auth")
                .andReturn(); /*jsonPath();*/

        /* теперь удаляем все эти старые assertions ниже
        int userIdOnCheck = responseCheckAuth.getInt("user_id");
        assertTrue(userIdOnCheck>0, "Unexpected user_id" + userIdOnCheck);

        assertEquals(
                userIdOnAuth,
                userIdOnCheck,
                "user id from auth request is not equal to user id from check request");

         и вместо них пишем следующее:
         */
        Assertions.assertJsonByName(responseCheckAuth, "user_id", this.userIdOnAuth);

    }

    @ParameterizedTest
    @ValueSource(strings = {"cookie","headers"})
    public void testNegativeAuthUser (String condition) {
    // тоже самое: воспользуемся методом из Assertions.assertJsonByName
        RequestSpecification spec = RestAssured.given();
        spec.baseUri("https://playground.learnqa.ru/api/user/auth");

        if (condition.equals("cookie")) {
            spec.cookie("auth_sid", this.cookie); // если в качестве параметра нам пришло cookie, то мы будем передавать только cookie
        } else if (condition.equals("headers")) {
            spec.header("x-csrf-token", this.header); // если пришло значение header, то передаем только header
        } else {
            throw new IllegalArgumentException("Condition value is known: " + condition); // на всякий случай исключение, если мы передали что-то не то в condition
        }

        Response /*JsonPath*/ responseForCheck = spec.get().andReturn(); /*jsonPath();*/
        /* далее вместо этого ассерта
        assertEquals(0, responseForCheck.getInt("user_id"), "user_id should be 0 for unauthorized request");
        используем наш кастомный:
         */
        Assertions.assertJsonByName(responseForCheck, "user_id", 0);

        /* ! У всех вызовов изменили ТИП возвращаемого значения!
        Теперь не работаем с Json напрямую в коде тестов, вся работа происходит с ним во вспомогательных методах.
        Поэтому нам надо получать объект Response и передавать его нашим методам, а парсить Json уже внутри.

        Итог: 3 разных вызова заменили одним.
        Новая функция сама все сделает теперь.
        Это значительно удобнее, чем каждый раз помнить, что нкаждый раз надо проверить
        - формат
        - наличие нужного ключа
        - и потом только значение
        Теперь ничего помнить не надо, можно применить 1 метод  assertJsonByName, который все помнит сам
         */
    }
}