package tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import lib.ApiCoreRequests;
import lib.Assertions;
import lib.BaseTestCase;
import lib.DataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("CRUD cases")
@Feature("Delete user")
@Link(name = "User Story: Delete user", url="https://scenarios/user-delete")
@Owner("Anastasia Batakovskaya")
public class UserDeleteTest extends BaseTestCase {
    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    //Exercise 18.1
    @Test
    @Description("This test checks that we cannot delete reserved user")
    @DisplayName("Test negative delete reserved user")

    @Issue("JIRA-123")
    @TmsLink("TMS-456")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteReservedUser() {
        //LOGIN as existing user Kotov with id = 2
        Allure.step("LOGIN as existing reserved user");
        Map<String, String> userData = new HashMap<>(); // очистили HashMap
        userData.put("email", "vinkotov@example.com");
        userData.put("password", "1234");
        int userId = 2;

        Response responseGetAuth = apiCoreRequests
                .makePostRequest(this.getApiURL() + "user/login", userData)
                .andReturn();

        String header = this.getHeader(responseGetAuth, "x-csrf-token");
        String cookie = this.getCookie(responseGetAuth, "auth_sid");

        // DELETE user with id = 2
        Allure.step("DELETE user with id = 2");
        Response responseDeleteData = apiCoreRequests
                .makeDeleteRequest(this.getApiURL() + "user/" + userId, header, cookie)
                .andReturn();
        // System.out.println("responseDeleteData.asString() = " + responseDeleteData.asString()); -> {"error":"Please, do not delete test users with ID 1, 2, 3, 4 or 5."}
        Assertions.assertJsonHasField(responseDeleteData, "error");

        // Check that user with id = 2 still exists, and we can receive user info
        Allure.step("Check that user with id = 2 still exists, and we can receive user info");
        Response responseUserData = apiCoreRequests
                .makeGetRequest(this.getApiURL() + "user/" + userId, header, cookie)
                .andReturn();
        // System.out.println("responseUserInfo.asString() = " + responseUserData.asString()); -> = {"id":"2","username":"Vitaliy","email":"vinkotov@example.com","firstName":"Vitalii","lastName":"Kotov"}
        String[] expectedFields = {"id", "username", "firstName", "lastName", "email"};
        Assertions.assertJsonHasFields(responseUserData, expectedFields);
    }

    //Exercise 18.2
    @Test
    @Description("This test creates user, performs login, deletes user, then tries to get userData by id and makes sure it's not possoble ")
    @DisplayName("Test positive delete user")
    @Issue("JIRA-130")
    @TmsLink("TMS-501")
    @Severity(SeverityLevel.CRITICAL)
    public void testPositiveDeleteUser() {
        //CREATE user
        Allure.step("CREATE user");
        Map<String, String> userData = DataGenerator.getRegistrationData();
        Response response = apiCoreRequests
                .makePostRequest(this.getApiURL() + "user/", userData)
                .andReturn();

        String email = userData.get("email");
        String password = userData.get("password");
        int userId = getIntFromJason(response, "id");


        //LOGIN as newly created user
        Allure.step("LOGIN as newly created user");
        userData = new HashMap<>(); // очистили HashMap, чтобы не посылать лишние параметры
        userData.put("email", email);
        userData.put("password", password);

        Response responseGetAuth = apiCoreRequests
                .makePostRequest(this.getApiURL() + "user/login", userData)
                .andReturn();

        String header = this.getHeader(responseGetAuth, "x-csrf-token");
        String cookie = this.getCookie(responseGetAuth, "auth_sid");

        // DELETE user with id = userId
        Allure.step("DELETE user");
        Response responseDeleteData = apiCoreRequests
                .makeDeleteRequest(this.getApiURL() + "user/" + userId, header, cookie)
                .andReturn();
        // System.out.println("responseDeleteData.asString() = " + responseDeleteData.asString()); -> = {"success":"!"}
        Assertions.assertJsonHasField(responseDeleteData, "success");

        // Check that user deleted successfully, and we can't receive user info
        Response responseUserData = apiCoreRequests
                .makeGetRequest(this.getApiURL() + "user/" + userId, header, cookie)
                .andReturn();
        // System.out.println("responseUserInfo.asString() = " + responseUserData.asString()); //-> = User not found
        Assertions.assertResponseCodeEquals(responseUserData, 404);
        Assertions.assertResponseTextEquals (responseUserData, "User not found");
    }

    //Exercise 18.3
    @Test
    @Description("This test performs authorization as one user, then tries to delete another existing user")
    @DisplayName("Test negative delete user")
    @Issue("JIRA-140")
    @TmsLink("TMS-502")
    @Severity(SeverityLevel.NORMAL)
    public void testNegativeDeleteUser() {
        //CREATE user1
        Allure.step("CREATE user1");
        Map<String, String> userData = DataGenerator.getRegistrationData();
        Response response = apiCoreRequests
                .makePostRequest(this.getApiURL() + "user/", userData)
                .andReturn();
        int userId1 = getIntFromJason(response, "id");

        //CREATE user2
        Allure.step("CREATE user1");
        userData = DataGenerator.getRegistrationData();
        apiCoreRequests
                .makePostRequest(this.getApiURL() + "user/", userData)
                .andReturn();
        String email = userData.get("email");
        String password = userData.get("password");

        //LOGIN as user2
        Allure.step("LOGIN as user2");
        Map<String, String> authData = new HashMap<>();
        authData.put("email", email);
        authData.put("password", password);

        Response responseGetAuth = apiCoreRequests
                .makePostRequest(this.getApiURL() + "user/login", authData)
                .andReturn();

        String header = this.getHeader(responseGetAuth, "x-csrf-token");
        String cookie = this.getCookie(responseGetAuth, "auth_sid");

        //Try to delete User1
        Allure.step("Try to delete User1");
        Response responseDeleteData = apiCoreRequests
                .makeDeleteRequest(this.getApiURL() + "user/" + userId1, header, cookie)
                .andReturn();
        //System.out.println("responseDeleteData.asString() = " + responseDeleteData.asString());
        //Assertions.assertResponseCodeEquals(responseDeleteData, 400);
        Assertions.assertJsonByName(responseDeleteData, "error", "This user can only delete their own account.");
    }
}
