package archive;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex13UserAgentTest {
    // создаем константы
    static final String USER_AGENT_1 = "Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    static final String USER_AGENT_2 = "Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1";
    static final String USER_AGENT_3 = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";
    static final String USER_AGENT_4 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0";
    static final String USER_AGENT_5 = "Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1";


    static Map<String, Map<String, String>> userAgentList = new HashMap<>();
    static {
        Map<String, String> expectedValues = new HashMap<>();

        expectedValues.put("platform","Mobile");
        expectedValues.put("browser","No");
        expectedValues.put("device","Android");
        userAgentList.put(USER_AGENT_1, expectedValues);

        expectedValues = new HashMap<>();
        expectedValues.put("platform","Mobile");
        expectedValues.put("browser","Chrome");
        expectedValues.put("device","iOS");
        userAgentList.put(USER_AGENT_2, expectedValues);

        expectedValues = new HashMap<>();
        expectedValues.put("platform","Googlebot");
        expectedValues.put("browser","Unknown");
        expectedValues.put("device","Unknown");
        userAgentList.put(USER_AGENT_3, expectedValues);

        expectedValues = new HashMap<>();
        expectedValues.put("platform","Web");
        expectedValues.put("browser","Chrome");
        expectedValues.put("device","No");
        userAgentList.put(USER_AGENT_4, expectedValues);

        expectedValues = new HashMap<>();
        expectedValues.put("platform","Mobile");
        expectedValues.put("browser","No");
        expectedValues.put("device","iPhone");
        userAgentList.put(USER_AGENT_5, expectedValues);


    }

    @ParameterizedTest
    @ValueSource(strings = {USER_AGENT_1, USER_AGENT_2, USER_AGENT_3, USER_AGENT_4, USER_AGENT_5})
    public void testUserAgentCheck(String userAgent){ // в параметре userAgent будет храниться то имя, которое будет передаваться провайдером данных

        JsonPath response = RestAssured
                .given()
                .header("User-Agent", userAgent)
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .jsonPath();
        String receivedPlatform = response.getString("platform");
        String expectedPlatform = userAgentList.get(userAgent).get("platform");
        // response.prettyPrint();

        assertEquals(expectedPlatform, receivedPlatform, "\nUser-Agent:\n" + userAgent + "\nInvalid platform value");

        String receivedBrowser = response.getString("browser");
        String expectedBrowser = userAgentList.get(userAgent).get("browser");

        assertEquals(expectedBrowser, receivedBrowser, "\nUser-Agent:\n" + userAgent + "\nInvalid browser value");

        // assertEquals(response.getString("browser"),
        //      this.userAgentList.get(userAgent).get("browser"),
        //         "\nUser-Agent:\n" + userAgent + "\nInvalid browser value");

        String receivedDevice = response.getString("device");
        String expectedDevice = userAgentList.get(userAgent).get("device");

        assertEquals(expectedDevice, receivedDevice, "\nUser-Agent:\n" + userAgent + "\nInvalid device value");

    }
}