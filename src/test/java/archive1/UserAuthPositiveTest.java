package archive;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAuthPositiveTest {
    /* 2 запроса будет. 1 - авторизует пользователя. 2 - проверяет, что пользователь авторизовался успешно
    1. Запрос https://playground.learnqa.ru/api/user/login, передаем email и password
    В случае успешной авторизации сервер верннет
    - User_ID и
    - Auth_sid cookie - авторизационная cookie
    Ко всем дальнейшим запросам будем прикладывать эту cookie, чтобы сервер понимал, что запросы идут от нашего User и авторизованы
    И еще получаем
    - x-csrf-token header - будет в заголовке, уникальный, , служит для безопасности - не позволяет делать запросы от имени пользователя злоумышленникам
    Только в случае передачи правльной cookie  и правильного заголовка последующие запросы будут считаться авторизоаванными
    Это и будем проверять в запросе https://playground.learnqa.ru/api/user/auth
    2. Передаем cookie и header, полученные из первого запроса
    Если передали верные значения, сервер вернет тот же User_ID - это означает, что юзер авторизован
    Иначе сервер вернет User_ID = 0 - это означает, что переданы неверные куки или header, или не передали их вовсе
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
}