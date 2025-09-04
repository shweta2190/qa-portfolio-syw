package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title should contain 'Google'");
    }

    @Test
    public void failingTest() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        // Intentionally failing (expecting "Yahoo" in Google title)
        Assert.assertTrue(title.contains("Yahoo"), "Title should contain 'Yahoo'");
    }
}
