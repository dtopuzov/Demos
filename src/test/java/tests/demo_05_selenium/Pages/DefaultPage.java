package tests.demo_05_selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.demo_05_selenium.BasePage;

public class DefaultPage extends BasePage {

    private WebElement tab(String text) {
        String expr = "//*[@id=\"js-repo-pjax-container\"]//*[text() = \"" + text +
                "\" or @href='/dtopuzov/test/" + text.toLowerCase() + "']";
        return driver.findElement(By.xpath(expr));
    }

    public DefaultPage(WebDriver driver) {
        super(driver);
        driver.navigate().to("https://github.com/dtopuzov/test");
    }

    public void navigateTo(String text) {
        tab(text).click();

        // Sleep for a while, just to see what happens
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Return page when navigate example
    public IssuesPage navigateToIssues() {
        navigateTo("Issues");
        return new IssuesPage(driver);
    }
}
