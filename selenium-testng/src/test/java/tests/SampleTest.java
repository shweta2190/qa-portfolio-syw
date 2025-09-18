package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void openExampleDotCom() {
        driver.get("https://example.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Example Domain"), "Title should contain 'Example Domain'");
    }
    
    @Test
    public void loginToOrangeHRM() {
        driver.get(baseUrl);
        // Page Object usage
        LoginPage loginPage = new LoginPage(driver, wait);
        HomePage homePage = loginPage.loginAs("Admin", "admin123");

        // Validate dashboard
        String dashboardHeader = homePage.getDashboardHeader();
        Assert.assertTrue(dashboardHeader.contains("Dashboard"), "User should land on Dashboard after login");
    }

    @Test
    public void failingTest() {
        driver.get("https://demoqa.com");
        String title = driver.getTitle();
        // Intentionally failing (expecting "Yahoo" in Demo title)
        Assert.assertTrue(title.contains("Yahoo"), "Title should contain 'Yahoo'");
    }
}
