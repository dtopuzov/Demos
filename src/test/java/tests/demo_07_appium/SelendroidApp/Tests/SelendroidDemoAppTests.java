package tests.demo_07_appium.SelendroidApp.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.demo_07_appium.SelendroidApp.Appium.Client;
import tests.demo_07_appium.SelendroidApp.Hooks.BaseTest;
import tests.demo_07_appium.SelendroidApp.Pages.HomePage;

public class SelendroidDemoAppTests extends BaseTest {

    @Test
    public void checkBox() throws InterruptedException {
        HomePage seleniumDemo = new HomePage(Client.driver);
        seleniumDemo.checkBox.tap(1, 500);
        Thread.sleep(1000);
        boolean isCecked = Boolean.valueOf(seleniumDemo.checkBox.getAttribute("checked"));
        Assert.assertEquals(isCecked, false, "Checkbox is still checked.");

        seleniumDemo.checkBox.tap(1, 500);
        Thread.sleep(1000);
        isCecked = Boolean.valueOf(seleniumDemo.checkBox.getAttribute("checked"));
        Assert.assertEquals(isCecked, true, "Checkbox is unchecked.");
    }
}
