package tests.demo_06_sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SelendroidAppTests {

    private static Screen s;
    private static String androidHome = System.getenv("ANDROID_HOME");
    private static String adbPath = androidHome + File.separator + "platform-tools" + File.separator + "adb";
    private static String emulatorPath = androidHome + File.separator + "tools" + File.separator + "emulator";
    private static String testAppPath = System.getProperty("user.dir") + File.separator + "testapps" + File.separator + "selendroid-test-app-0.11.0.apk";

    private static String execCmd(String cmd) throws java.io.IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    private static void clickElement(String imagePath, int timeout) throws FindFailed {
        s.wait(imagePath, timeout).mouseMove();
        s.click();
    }

    @BeforeClass()
    public static void setUp() throws IOException, FindFailed {
        s = new Screen();
        ImagePath.setBundlePath("src/test/java/tests/demo_06_sikuli/SelendroidApp/");
        String killEmulators = execCmd("taskkill /F /IM qemu-system-i386.exe");
        System.out.println(killEmulators);
        Runtime.getRuntime().exec(emulatorPath + " -avd Emulator-Api19-Default");
        s.wait("emu_home_button.png", 180);
        String installOut = execCmd(adbPath + " -e install -r " + testAppPath);
        System.out.println(installOut);
    }

    @BeforeMethod(alwaysRun = true)
    public static void beforeTest() throws IOException, FindFailed {
        String startAppOut = execCmd(adbPath + " -e shell monkey -p io.selendroid.testapp -c android.intent.category.LAUNCHER 1");
        System.out.println(startAppOut);
        s.wait("selendroid_app_title.png", 30);
    }

    @AfterMethod(alwaysRun = true)
    public static void afterTest(ITestResult result) throws IOException, AWTException {
        String stopAppOut = execCmd(adbPath + " -e shell ps | grep io.selendroid.testapp | awk '{print $2}' | xargs adb shell kill");
        System.out.println(stopAppOut);
        File screenshot = new File(System.getProperty("user.dir") + File.separator + result.getMethod().getMethodName() + ".png");
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", screenshot);
    }

    @Test()
    public void displayToast() throws FindFailed, InterruptedException {
        s.wait("selendroid_app_display_toast_button.png", 30).mouseMove();
        s.click();
        s.wait("selendroid_app_display_toast.png", 30);
    }

    @Test()
    public void displayPopup() throws FindFailed, InterruptedException {
        s.wait("selendroid_app_display_popup_button.png", 30).mouseMove();
        s.click();
        s.wait("selendroid_app_display_popup.png", 30);
        s.click();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown() throws IOException {
        String killEmulators = execCmd("taskkill /F /IM qemu-system-i386.exe");
        System.out.println(killEmulators);
    }
}
