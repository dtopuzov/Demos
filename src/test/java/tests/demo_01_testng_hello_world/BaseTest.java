package tests.demo_01_testng_hello_world;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }

    @BeforeGroups(alwaysRun = true)
    public void beforeGroup() {
        System.out.println("@BeforeGroups");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        // Demo how to get test name before test
        System.out.println("Start test: " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodBaseTest(ITestResult result) {
        // Demo how to get test name after test
        String testCase = result.getMethod().getMethodName();
        System.out.println("End test: " + testCase);

        // Demo how to get test status and other properties
        System.out.println("Test Ended: " + result.getStatus());
        // int SUCCESS = 1;
        // int FAILURE = 2;
        // int SKIP = 3;
        // int SUCCESS_PERCENTAGE_FAILURE = 4;
        // int STARTED = 16;
        System.out.println("Test Started: " + result.getStartMillis());
        System.out.println("Test Ended: " + result.getEndMillis());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        System.out.println("@AfterTest");
    }

    @AfterGroups(alwaysRun = true)
    public void afterGroups() {
        System.out.println("@AfterGroups");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }
}
