package archive;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAuthNegativeTest {
    /* Сделаем НЕГАТИВНЫЙ тест авторизации
    2 запроса будет. 1 - авторизует пользователя. 2 - Передаем только cookie или только token
    1. Запрос https://playground.learnqa.ru/api/user/login, передаем email и password
    В случае успешной авторизации сервер вернет
    - User_ID,
    - Auth_sid cookie - авторизационная cookie,
    - x-csrf-token header
    Только в случае передачи правльной cookie  и правильного заголовка последующие запросы будут считаться авторизоаванными

    2. Передаем только cookie или только token header, полученные из первого запроса и Не передаем вторую составляющую авторизации
    Это будем проверять в запросе https://playground.learnqa.ru/api/user/auth
    Сервер вернет User_ID = 0 - это означает, что сервер не считает нас авторизованными

    Тест будет параметризованным: в 1м случае не будет передавать cookie, а во 2м - заголовок.
    Достаточно будет сделать 1 тест с нужными if-ами, как это было сделано в archive.ParametrizedTest
     */
    @Test
    public void testAuthUser () {
        // 1) Делаем 1й запрос для того чтоб залогиниться
        Map<String, String> authData = new HashMap<>();
        // прописываем валидные параметры авторизации:
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response responseGetAuth = RestAssured
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/user/login")
                .andReturn();

        //разберем респонс на несколько нужных нам далее параметров:
        Map<String, String> cookies = responseGetAuth.getCookies();
        Headers headers = responseGetAuth.getHeaders();
        int userIdOnAuth = responseGetAuth.jsonPath().getInt("user_id");

        // Теперь напишем 4 проверки
        // 1. Проверяем, что пришел статус код 200
        assertEquals(200, responseGetAuth.statusCode(), "Unexpected status code");
        // 2. Проверяем, что во всем списке cookies содержится cookie Auth_sid
        assertTrue(cookies.containsKey("auth_sid"),"Response doesn't have auth_sid cookie");
        // 3. Убеждаемся, что в headers у нас есть Header с именем x-csrf-token
        assertTrue(headers.hasHeaderWithName("x-csrf-token"), "Response doesn't have 'x-csrf-token' header");
        // 4. Проверяем, что в User_id пришел не ноль
        assertTrue(responseGetAuth.jsonPath().getInt("user_id")>0, "User_id should be greater than 0"); // ??? почему не используем userIdOnAuth в условии?

        // 2) Формируем 2й запрос, в котором проверяем, что мы успешно залогинились
        JsonPath responseCheckAuth = RestAssured
                .given()
                .header("x-csrf-token", responseGetAuth.header("x-csrf-token"))
                .cookie("auth_sid", responseGetAuth.cookie("auth_sid"))
                .get("https://playground.learnqa.ru/api/user/auth")
                .jsonPath();                ;

        /* Теперь надо убедиться, что в ответе запроса также будет user_id
           и сравним со значением, которое мы получили из первого запроса и убедимся, что они совпадают
         */
        int userIdOnCheck = responseCheckAuth.getInt("user_id");
        assertTrue(userIdOnCheck>0, "Unexpected user_id" + userIdOnCheck);
        // сравниваем userIdOnAuth и userIdOnCheck
        assertEquals(
                userIdOnAuth,
                userIdOnCheck,
                "user id from auth request is not equal to user id from check request"
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"cookie","headers"})
    public void testNegativeAuthUser (String condition) {
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response responseGetAuth = RestAssured
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/user/login")
                .andReturn();
        //опять разберем респонс на несколько нужных нам далее параметров:
        Map<String, String> cookies = responseGetAuth.getCookies();
        Headers headers = responseGetAuth.getHeaders();
        /*
        в этом тесте делам почти тоже самое что и в первом, поэтому много кода копируем,
        но в конце теста мы во второй запрос будем передавать что-то одно.
        Для этого знакомимся с новой сущностью - Request Specification. Это специальный класс, объектом которого будет наша переменная spec.
        С помощью этого механизма мы можем выполнять нужный нам запрос, объявляя его по частям.
        По сути берем наш билдер и разбиваем его на части
         */
        RequestSpecification spec = RestAssured.given();
        // Постепенно будем обогащать наш будущий запрос данными
        // сначала зададим url на который будет отправлять запрос (эта часть будет всегда, она общая)
        spec.baseUri("https://playground.learnqa.ru/api/user/auth");

        if (condition.equals("cookie")) {
            spec.cookie("auth_sid", cookies.get("auth_sid")); // если в качестве параметра нам пришло cookie, то мы будем передавать только cookie
        } else if (condition.equals("headers")) {
            spec.header("x-csrf-token", headers.get("x-csrf-token")); // если пришло значение header, то передаем только header
        } else {
            throw new IllegalArgumentException("Condition value is known: " + condition); // на всякий случай исключение, если мы передали что-то не то в condition
        }

        JsonPath responseForCheck = spec.get().jsonPath();
        // тут мы от переменной spec вызываем метод get без указания url, т.к. он уже задан выше в коде. И ответ сразу парсит переменную как Json

        // теперь выводим assert. Убеждаемся, что user_id будет 0. Если не так, выводится эксепшен
        assertEquals(0, responseForCheck.getInt("user_id"), "user_id should be 0 for unauthorized request");

    }
}