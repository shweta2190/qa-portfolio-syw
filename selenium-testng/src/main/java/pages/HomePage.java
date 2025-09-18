package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriverWait wait;

    // Locator for dashboard header
    private By dashboardHeader = By.cssSelector("h6.oxd-text--h6");

    // Constructor
    public HomePage(WebDriver driver ,WebDriverWait wait) {
        this.wait = wait;
    }

    // Method to verify user is on Dashboard
    public String getDashboardHeader() {
          return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).getText();
    }
}

