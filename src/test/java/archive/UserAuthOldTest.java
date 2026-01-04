package archive;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lib.BaseTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAuthOldTest  {
    /*
    В BeforeEach принято записывать логику, с которой должны начинаться все тесты в классе, например, с подготовки каких-то тестовых данных.
    Вынесем сюда первую чать наших тестов
     */
    String cookie;
    String header;
    int userIdOnAuth;

    @BeforeEach
    public void loginUser () {
       // String cookie="gg";
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response responseGetAuth = RestAssured // также сюда переносим 1й запрос на логин нашего пользователя
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/user/login")
                .andReturn();
        /*
        Вводим this - это специальный указатель, который позволяет сделать переменную полем класса (точнее, сослаться на поле класса
        и, как следствие, передавать ее значение из одной функции в другие
        На самом деле, указывать this нужно только в том случае, когда внутри и вне нашей функции существуют 2 переменные с одинаковым именем
        и внутри функции мы хотим использовать обе. Иначе указывать необязательно.
        Но мы все равно будем, чтобы подчеркнуть, что эти переменные находятся ВНЕ функции и НЕ являются локальными
         */
        this.cookie = responseGetAuth.getCookie("auth_sid");
        this.header = responseGetAuth.getHeader("x-csrf-token");
        this.userIdOnAuth = responseGetAuth.jsonPath().getInt("user_id");
        // теперь мы сможем использовать эти переменные в тестах
    }

    @Test
    public void testAuthUser () {

        // Формируем запрос, в котором проверяем, что мы успешно залогинились
        JsonPath responseCheckAuth = RestAssured
                .given()
                // здесь будем использовать вместо переменной которая была внутри класса, переменную из другого класса, описанную выше
                .header("x-csrf-token", this.header)
                .cookie("auth_sid", this.cookie)
                .get("https://playground.learnqa.ru/api/user/auth")
                .jsonPath();

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
        /*
        знакомимся с новой сущностью - Request Specification. Это специальный класс, объектом которого будет наша переменная spec.
        С помощью этого механизма мы можем выполнять нужный нам запрос, объявляя его по частям.
        По сути берем наш билдер и разбиваем его на части
         */
        RequestSpecification spec = RestAssured.given();
        // зададим url на который будет отправлять запрос (эта часть будет всегда, она общая)
        spec.baseUri("https://playground.learnqa.ru/api/user/auth");

        if (condition.equals("cookie")) {
            spec.cookie("auth_sid", this.cookie); // если в качестве параметра нам пришло cookie, то мы будем передавать только cookie
        } else if (condition.equals("headers")) {
            spec.header("x-csrf-token", this.header); // если пришло значение header, то передаем только header
        } else {
            throw new IllegalArgumentException("Condition value is known: " + condition); // на всякий случай исключение, если мы передали что-то не то в condition
        }

        JsonPath responseForCheck = spec.get().jsonPath();
        // тут мы от переменной spec вызываем метод get без указания url, т.к. он уже задан выше в коде. И ответ сразу парсит переменную как Json

        // теперь выводим assert. Убеждаемся, что user_id будет 0. Если не так, выводится эксепшен
        assertEquals(0, responseForCheck.getInt("user_id"), "user_id should be 0 for unauthorized request");

    }
}