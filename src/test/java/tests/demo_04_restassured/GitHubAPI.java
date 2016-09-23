package tests.demo_04_restassured;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.demo_04_restassured.GitHubObjects.Issue;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

public class GitHubAPI {

    // Please set environment variables
    // GITHUB_USER -> Email of your GitHub user
    // GITHUB_USER_PASS -> Your github password
    // PERSONAL_TOKEN -> Your github personal token.
    // See: https://help.github.com/articles/creating-an-access-token-for-command-line-use/

    private static String user = System.getenv("GITHUB_USER");
    private static String password = System.getenv("GITHUB_USER_PASS");
    private static String personalToken = System.getenv("PERSONAL_TOKEN");

    private static String baseURL = "https://api.github.com";
    private static String testRepo = "dtopuzov/test";

    @BeforeClass
    public static void setUp() {
        // This will setup basic authentication for all the tests
        RestAssured.authentication = basic("username", "password");

        // This will set base URL for all the tests
        RestAssured.baseURI = String.format("%s/repos/%s/issues", baseURL, testRepo);
    }

    @Test
    public void CreateIssueWithBasicAuthentication() {
        Issue issue = new Issue();
        issue.title = "Title";
        issue.body = "Thsi is body.";

        given().
                auth().
                preemptive(). // See https://github.com/rest-assured/rest-assured/issues/356#issuecomment-123187692
                basic(user, password).
                contentType("application/json; charset=UTF-8").
                body(issue).
        when().
                post().
        then().
                statusCode(201);
    }

    @Test
    public void CreateIssueWithTokenAuthentication() {
        // TODO: Implemet it.
    }

    @Test
    public void CloseIssue() {
        // TODO: Implemet it.
    }

    @Test
    public void VerifyClosedIssuesAreMoreThanOpened() {
        // TODO: Implemet it.
        // URL sample: https://api.github.com/repos/dtopuzov/test/issues?state=open
    }
}
