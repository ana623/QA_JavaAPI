package lib;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.Map;

import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTestCase { // надо, чтобы все тесты наследовались от этого класса
    protected static final String ENV = "test";  // dev | test
    protected String getApiURL() {
        String url = "";
        if (ENV.equals("dev"))
            url = "https://playground.learnqa.ru/api_dev/";
        else if (ENV.equals("test"))
            url = "https://playground.learnqa.ru/api/";
        return url;
    }

    protected String getHeader(Response Response, String name){
        Headers headers = Response.getHeaders();
        assertTrue(headers.hasHeaderWithName(name), "Response doesn't have header with name " + name);
        return headers.getValue(name);
    }

    protected String getCookie(Response Response, String name){
        Map<String, String> cookies = Response.getCookies();
        assertTrue(cookies.containsKey(name), "Response doesn't have cookie with name " + name);
        return cookies.get(name);
    }

    protected int getIntFromJason(Response Response, String name){
        Response.then().assertThat().body("$", hasKey(name)); // знак $ указывает, что мы ищем наш ключ в корне Json
        return Response.jsonPath().getInt(name);
    }

    protected String getStringFromJason(Response Response, String name){
        Response.then().assertThat().body("$", hasKey(name)); // знак $ указывает, что мы ищем наш ключ в корне Json
        return Response.jsonPath().getString(name);
    }
}

