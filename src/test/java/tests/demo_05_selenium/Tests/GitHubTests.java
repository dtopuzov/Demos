package tests.demo_05_selenium.Tests;

import org.junit.Test;
import tests.demo_05_selenium.BaseTest;
import tests.demo_05_selenium.Pages.DefaultPage;
import tests.demo_05_selenium.Pages.IssuesPage;

import static org.junit.Assert.assertTrue;

public class GitHubTests extends BaseTest {
    @Test
    public void test_01_navigation1() {
        DefaultPage home = new DefaultPage(driver);
        home.navigateTo("Issues");
        home.navigateTo("Pull requests");
        home.navigateTo("Projects");
        home.navigateTo("Pulse");
        home.navigateTo("Graphs");
    }

    @Test
    public void test_01_navigation2() {
        DefaultPage home = new DefaultPage(driver);
        IssuesPage issues = home.navigateToIssues();
        int open = issues.getOpenIssuesCount();
        int closed = issues.getClosedIssuesCount();
        System.out.println("Open: " + String.valueOf(open));
        System.out.println("Closed: " + String.valueOf(closed));
        assertTrue("Open issues are more than closed.", open < closed);
    }

    @Test
    public void test_02_verifyClosedAreMoreThanOpen() {
        IssuesPage issues = new IssuesPage(driver);
        int open = issues.getOpenIssuesCount();
        int closed = issues.getClosedIssuesCount();
        System.out.println("Open: " + String.valueOf(open));
        System.out.println("Closed: " + String.valueOf(closed));
        assertTrue("Open issues are more than closed.", open < closed);
    }
}
