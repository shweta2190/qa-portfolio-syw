package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp(ITestContext context) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Save driver in TestNG context for listeners
        context.setAttribute("driver", driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
