package tests.demo_07_appium.SelendroidApp.Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;

public class Client {

    public static AndroidDriver driver;

    public static void startAppiumClient() throws MalformedURLException {
        File appDir = new File("testapps");
        File app = new File(appDir, "selendroid-test-app-0.11.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator"); // Can be random
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); // Path to app under test
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 240); // Timeout to appium commands
        capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, 120); // Fail if android device not found in 2 minutes
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, "io.selendroid.testapp"); // Used to ensure app is running (not crashed at startup)
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity"); // Used to ensure app is running (not crashed at startup)
        // Replace Emulator-Api19-Default with name of emulator you want to test
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Emulator-Api19-Default");
        // If  you nwat to test on real android device remove the line above and use
        // capabilities.setCapability(MobileCapabilityType.UDID, "<id of your device>"); // Use adb devices to take it.
        driver = new AndroidDriver<>(Server.service.getUrl(), capabilities);

    }

    public static void stopAppiumClient() {
        if (driver != null) {
            driver.quit();
        }
    }
}
