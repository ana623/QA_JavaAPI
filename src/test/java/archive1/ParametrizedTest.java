package archive;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedTest {
    // 2. Универсальный вариант, параметризованный, включает сразу 3 теста в одном тесте - дефолтный вызов без имени и 2 вызова с именем
    @ParameterizedTest
    @ValueSource(strings = {"", "John", "Peter"}) // 3 набора имен, тест будет запущен 3 раза, каждый раз подставляя очередное имя из набора
    public void testHelloMethodName(String name){ // в параметре name будет храниться то имя, которое будет передаваться провайдером данных
        Map<String, String> queryParams = new HashMap<>(); // создаем пустой HashMap
        //надо обработать ситуацию, когда имя - пустое
        if (name.length() > 0) {
            queryParams.put("name", name); // добавляем имя в качестве параметра, когда имя НЕ пустое
            // пустое имя мы передавать не будем и, соот-но, HashMap останется пустым
        }
        JsonPath response = RestAssured
                .given()
                .queryParams(queryParams) // в случае пустого имени HashMap queryParams будет пустым, это норм, RestAssured не будет передавать никакие данные в запросе
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        String expectedName = (name.length() > 0) ? name: "someone"; /* специальный тернарный оператор if в java
        синтаксис: переменная = условие ? результат_если_true : результат_если_false */
        assertEquals("Hello, " + expectedName, answer, "The answer is not expected");
    }
   /*
   1. Вариант НЕпараметризорванный, 2 вызова
   @Test
    // вызов без имени (дефолт)
    public void testHelloMethodWithoutName(){
        JsonPath response = RestAssured
            .get("https://playground.learnqa.ru/api/hello")
            .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, someone", answer, "The answer is not expected");
    }
    @Test
    // вызов с именем
    public void testHelloMethodWithName(){
        String name = "Username";
        JsonPath response = RestAssured
                .given()
                .queryParam("name", name)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, " + name, answer, "The answer is not expected");
    }
    */

}