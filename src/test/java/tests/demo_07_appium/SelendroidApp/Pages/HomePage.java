package tests.demo_07_appium.SelendroidApp.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.demo_07_appium.SelendroidApp.Appium.Client;

public class HomePage {

    AppiumDriver driver;

    // You can use Android and iOS find by together if you test cross-platform app
    @AndroidFindBy(className = "android.widget.CheckBox")
    @iOSFindBy(className = "UIACheckBox")
    public MobileElement checkBox;

    // You can use only @FinddBy or @AndroidFindBy if app you test is not available for iOS
    @FindBy(xpath = "//android.widget.Button[@text='Display text view']")
    public MobileElement displayTextViewButton;

    @FindBy(xpath = "//android.widget.Button[@text='Displays a Toast']")
    public MobileElement displayToastButton;

    // This demonstrates how you can have method returning MobileElement instead of property
    // You can use methods when you need some more complex logic.
    // ..or in cases when you have too much buttons and you do not want to create property for all of them
    public MobileElement findButton(String buttonName) {
        String xpath = "//android.widget.Button[@text='" + buttonName + "']";
        MobileElement button = (MobileElement) Client.driver.findElement(By.xpath(xpath));
        return button;
    }

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
