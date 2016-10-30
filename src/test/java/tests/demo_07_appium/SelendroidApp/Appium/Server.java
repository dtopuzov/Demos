package tests.demo_07_appium.SelendroidApp.Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Server {

    public static AppiumDriverLocalService service;

    private static String appiumPath = System.getenv("APPDATA") + "\\npm\\node_modules\\appium\\build\\lib\\main.js";
    private static File appiumExecutable = new File(appiumPath);

    public static void startAppiumServer() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withAppiumJS(appiumExecutable)
                .withStartUpTimeOut(180, TimeUnit.SECONDS)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "warn");

        service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();

        if (service == null || !service.isRunning()) {
            throw new RuntimeException("Client server is not started!");
        }
    }

    public static void stopAppiumServer() {
        if (service != null) {
            service.stop();
        }
    }
}
