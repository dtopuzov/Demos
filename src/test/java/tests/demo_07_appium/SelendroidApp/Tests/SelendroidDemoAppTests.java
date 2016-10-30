package tests.demo_07_appium.SelendroidApp.v1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SelendroidDemoAppTests {

    private static AppiumDriverLocalService service;
    private static AndroidDriver driver;

    private static String appiumPath = System.getenv("APPDATA") + "\\npm\\node_modules\\appium\\build\\lib\\main.js";
    private static File appiumExecutable = new File(appiumPath);

    @BeforeClass
    public static void beforeClass() throws Exception {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withAppiumJS(appiumExecutable)
                .withStartUpTimeOut(180, TimeUnit.SECONDS)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug");

        service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();

        if (service == null || !service.isRunning()) {
            throw new RuntimeException("Appium server is not started!");
        }

        File appDir = new File("testapps");
        File app = new File(appDir, "selendroid-test-app-0.11.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 240);
        capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, 120);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, "io.selendroid.testapp");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Emulator-Api19-Default");
        driver = new AndroidDriver<>(service.getUrl(), capabilities);
    }

    @BeforeTest
    public void beforeTest() {
    }

    @AfterTest
    public void afterTest() {
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
        service.stop();
    }

    @Test
    public void smokeTest() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }
}
