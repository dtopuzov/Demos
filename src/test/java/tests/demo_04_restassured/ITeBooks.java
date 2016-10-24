package tests.demo_04_restassured;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class ITeBooks {

    private static String baseURL = "http://it-ebooks-api.info/v1/";

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void runBeforeClass() {
        System.out.println("Start tests in ITeBooks class.");
    }

    @AfterClass
    public static void runAfterClass() {
        System.out.println("End tests in ITeBooks class.");
    }

    @Before
    public void setUp() {
        System.out.println("Start test: " + testName.getMethodName());
    }

    @After
    public void tearDown() {
        System.out.println("End test: " + testName.getMethodName());
    }

    @Test
    public void SearchForBook() {
        when()
            .get(baseURL + "search/{seachString}", "selenium")
        .then()
            .statusCode(200)
            .body(containsString("selenium"))
            .body("Books[0].Title", equalTo("Selenium 1.0 Testing Tools"));
    }

    @Test
    public void GetBookDetails() {
        String expectedID = "947185260";
        String actualId =
                when()
                    .get(baseURL + "book/{id}", expectedID)
                .then()
                    .statusCode(200)
                    .contentType("application/json")
                    .time(lessThan(5000L), TimeUnit.MILLISECONDS)
                    .body(containsString(expectedID))
                .extract()
                    .path("ID").toString();

        Assert.assertEquals("Id is not correct", expectedID, actualId);
    }
}