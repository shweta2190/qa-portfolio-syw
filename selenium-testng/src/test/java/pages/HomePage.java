package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locator for dashboard header
    private By dashboardHeader = By.cssSelector("h6.oxd-text--h6");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to verify user is on Dashboard
    public String getDashboardHeader() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return driver.findElement(dashboardHeader).getText();
    }
}

