package tests.demo_05_selenium.API;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Api {

    private static String baseURL = "https://api.github.com";

    private static int getIssue(String repo, String issueState) {
        RestAssured.baseURI = String.format("%s/repos/%s/issues", baseURL, repo);
        int count =
                given().
                        param("state", issueState).
                        when().
                        get().
                        then().
                        statusCode(200).
                        extract().jsonPath().getList("$").size();
        return count;
    }

    public static int getOpenIssues(String repo) {
        return getIssue(repo, "open");
    }

    public static int getClosedIssues(String repo) {
        return getIssue(repo, "closed");
    }


}
