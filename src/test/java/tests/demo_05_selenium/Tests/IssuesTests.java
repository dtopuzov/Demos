package tests.demo_05_selenium.Tests;

import org.junit.Test;
import tests.demo_05_selenium.BaseTest;
import tests.demo_05_selenium.Pages.IssuesPage;

import static org.junit.Assert.assertTrue;

public class IssuesTests extends BaseTest {
    @Test
    public void verifyClosedAreMoreThanOpen() {
        IssuesPage issues = new IssuesPage(driver);
        int open = issues.getOpenIssuesCount();
        int closed = issues.getClosedIssuesCount();
        System.out.println("Open: " + String.valueOf(open));
        System.out.println("Closed: " + String.valueOf(closed));
        assertTrue("Open issues are more than closed.", open < closed);
    }
}
