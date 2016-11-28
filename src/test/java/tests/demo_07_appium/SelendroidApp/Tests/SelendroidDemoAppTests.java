package tests.demo_07_appium.SelendroidApp.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.demo_07_appium.SelendroidApp.Appium.Client;
import tests.demo_07_appium.SelendroidApp.Hooks.BaseTest;
import tests.demo_07_appium.SelendroidApp.Pages.HomePage;

public class SelendroidDemoAppTests extends BaseTest {

    @Test
    public void checkBox() {
        HomePage seleniumDemo = new HomePage(Client.driver);
        seleniumDemo.checkBox.tap(1, 500);
        boolean isChecked = Boolean.valueOf(seleniumDemo.checkBox.getAttribute("checked"));
        Assert.assertEquals(isChecked, false, "Checkbox is still checked.");
        seleniumDemo.checkBox.tap(1, 500);
        isChecked = Boolean.valueOf(seleniumDemo.checkBox.getAttribute("checked"));
        Assert.assertEquals(isChecked, true, "Checkbox is unchecked.");
    }

    @Test
    public void displayTextView() {
        HomePage seleniumDemo = new HomePage(Client.driver);
        seleniumDemo.displayTextViewButton.tap(1, 500);

        // Alternatively ou can use
        // seleniumDemo.findButton("Display text view").tap(1, 500);
    }
}
