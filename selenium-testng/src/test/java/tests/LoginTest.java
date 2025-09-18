package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    @DataProvider(name="users")
    public Object[][] getUsers() {
        return new Object[][] {
            {"Admin", "admin123"},   // Valid user
            {"wrongUser", "admin123"} // Invalid user (negative case)
        };
    }

    @Test(dataProvider="users")
    public void loginTest(String username, String password) {
        //String baseUrl;
        driver.get(baseUrl);
       
        LoginPage loginPage = new LoginPage(driver, wait);
        HomePage homePage = loginPage.loginAs(username, password);

        if (username.equals("Admin")) {
            Assert.assertTrue(homePage.getDashboardHeader().contains("Dashboard"),
                    "Valid user should land on Dashboard");
        } else {
            Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"),
                    "Invalid login should show error");
        }
    }
}
