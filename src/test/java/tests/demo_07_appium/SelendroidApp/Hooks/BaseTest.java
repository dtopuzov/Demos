package tests.demo_07_appium.SelendroidApp.Hooks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import tests.demo_07_appium.SelendroidApp.Appium.Client;
import tests.demo_07_appium.SelendroidApp.Appium.Server;

public class BaseTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        Server.startAppiumServer();
        Client.startAppiumClient();
    }

    @BeforeTest
    public void beforeTest() {
    }

    @AfterTest
    public void afterTest() {
    }

    @AfterClass
    public static void afterClass() {
        Client.stopAppiumClient();
        Server.stopAppiumServer();
    }
}
