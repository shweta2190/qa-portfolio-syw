package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton   = By.cssSelector("button[type='submit']");

    // Constructor
    public LoginPage(WebDriver driver , WebDriverWait wait)   {
        this.driver = driver;
        this.wait = wait;
    }

    // Actions
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    public void enterPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(loginButton).click();
    }

    // High-level method
    public HomePage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new HomePage(driver, wait);
    }
}

