package archive;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CookiesTest {

    @Test
    public void testGetCookies() {
        Map<String,String> data = new HashMap<>();
        data.put("login","secret_login");
        data.put("password","secret_pass");
        Response response = RestAssured
                .given()
                .body(data)
                .when()
                .post("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();
        System.out.println("\nPretty text:");
        response.prettyPrint();

        System.out.println("\nHeaders:");
        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);

        System.out.println("\nCookies:");
        Map<String,String> responseCookies = response.getCookies();
        System.out.println(responseCookies);

        /* вывести только значение cookie
        String responseCookie = response.getCookie("auth_cookie");
        System.out.println(responseCookie);
         */
    }

    @Test
    /*  1. Отправляем логин-пароль на сервер в POST запросе get_auth_cookie,
        если логин-пароль верны, сервер устанавливает куки в "auth_cookie",
        если нет - сервер устанавливает "auth_cookie" = null
        2. "auth_cookie" записываем в переменную responseCookie
        3. Если "auth_cookie" != null, записываем их в новую переменную cookies (берем из responseCookie)
        4. Передаем cookies в новый POST запрос check_auth_cookie через метод cookies и распечатываем
    */
    public void testCookiesExchange() {
        Map<String,String> data = new HashMap<>();
        data.put("login","secret_login2");
        data.put("password","secret_pass2");
        Response responseForGet = RestAssured
                .given()
                .body(data)
                .when()
                .post("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();

        String responseCookie = responseForGet.getCookie("auth_cookie");
        // System.out.println(responseCookie);

        Map<String, String> cookies = new HashMap<>();
        if ( responseCookie != null){
            cookies.put("auth_cookie",responseCookie);
        }

        Response responseForCheck = RestAssured
                .given()
                .body(data)
                .cookies(cookies)
                .when()
                .post("https://playground.learnqa.ru/api/check_auth_cookie")
                .andReturn();
        responseForCheck.print();
    }
}
