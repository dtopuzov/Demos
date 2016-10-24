package tests.demo_04_restassured.TelerikAPI;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import tests.demo_04_restassured.TelerikAPI.Objects.CreateUser;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelerikApi {

    // Please set environment variables
    // APP_ID -> Ypur app id
    // MASTER_KEY -> Your master key

    private static String appId = System.getenv("APP_ID");
    private static String mesterKey = System.getenv("MASTER_KEY");

    private static final String userId = UUID.randomUUID().toString();
    private static String createUserId = "";

    @BeforeClass
    public static void setUp() {
        // This will set base URL for all the tests
        String baseURI = "http://api.everlive.com/v1/";
        RestAssured.baseURI = baseURI + appId;
        // We want all the details for failed tests
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void test_01_createValidUser() {

        CreateUser body = new CreateUser();
        body.displayName = "User";
        body.email = "user_" + userId + "@gmail.com";
        body.password = "123456";
        body.username = "user" + userId;

        createUserId =
                given().
                        header("Content-Type", "application/json").
                        body(body).
                        when().
                        post("/Users").
                        then().
                        statusCode(201).
                        extract().
                        path("Result.Id");
    }

    @Test
    public void test_02_getValidUserShouldReturnUserDetails() {
        when().
                get("/Users/{id}", createUserId).
                then().
                statusCode(200).
                body(containsString(createUserId));
    }

    @Test
    public void test_03_getNotExistingUserShouldReturn404() {
        when().
                get("/Users/{id}", UUID.randomUUID().toString()).
                then().
                statusCode(404);
    }

    @Test
    public void test_04_getAllUsersShouldReturnResult() {
        when().
                get("/Users").
                then().
                statusCode(200).
                body("Count", greaterThanOrEqualTo(1)).
                body(containsString(createUserId));
    }

    @Test
    public void test_05_createUserWithInvalidEmail() {
        CreateUser body = new CreateUser();
        body.displayName = "User";
        body.email = "invaliduser_" + userId + "gmail.com";
        body.password = "123456";
        body.username = "invaliduser" + userId;

        given().
                header("Content-Type", "application/json").
                body(body).
                when().
                post("/Users").
                then().
                statusCode(400).
                body("message", equalTo("The specified email value is not a valid email address."));
    }

    @Test
    public void test_06_createAlreadyExistingUser() {
        CreateUser body = new CreateUser();
        body.displayName = "User";
        body.email = "user_" + userId + "@gmail.com";
        body.password = "123456";
        body.username = "user" + userId;

        given().
                header("Content-Type", "application/json").
                body(body).
                when().
                post("/Users").
                then().
                statusCode(400).
                body(containsString("A user with the same username already exists"));
    }

    @Test
    public void test_07_updateValidUser() {

        CreateUser body = new CreateUser();
        body.displayName = "Updated User";

        given().
                contentType("application/json").
                header("Authorization", "Masterkey " + mesterKey).
                body(body).
                when().
                put("/Users/" + createUserId).
                then().
                statusCode(200);

        when().
                get("/Users/{id}", createUserId).
                then().
                statusCode(200).
                body(containsString("Updated User"));
    }

    @Test
    public void test_08_updateNotExistingUser() {

        CreateUser body = new CreateUser();
        body.displayName = "Updated User";
        body.password = "654321";

        given().
                contentType("application/json").
                header("Authorization", "Masterkey " + mesterKey).
                body(body).
                when().
                put("/Users/" + UUID.randomUUID().toString()).
                then().
                statusCode(404);
    }

    @Test
    public void test_09_updateUserWithoutAuthentication() {
        CreateUser body = new CreateUser();
        body.displayName = "Updated User";
        body.password = "654321";

        given().
                contentType("application/json").
                body(body).
                when().
                put("/Users/" + createUserId).
                then().
                statusCode(403);
    }

    @Test
    public void test_10_deleteValidUser() {
        given().
                contentType("application/json").
                header("Authorization", "Masterkey " + mesterKey).
                when().
                delete("/Users/" + createUserId).
                then().
                statusCode(200);

        when().
                get("/Users/{id}", createUserId).
                then().
                statusCode(404);
    }

    @Test
    public void test_11_deleteUserWithoutAuthentication() {
        given().
                contentType("application/json").
                when().
                delete("/Users/" + createUserId).
                then().
                statusCode(403);
    }
}
