import com.learning.example.LocalChromeWebDriver;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginButtonWorksTest {

    private WebDriver _webdriver = new LocalChromeWebDriver().GetWebDriver();

    @Before()
    public void Before() {
        _webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test1() throws InterruptedException {
        _webdriver.get(LocalChromeWebDriver.GetWebUrl());

        // login
        _webdriver.findElement(By.cssSelector("#login")).sendKeys("demo");
        _webdriver.findElement(By.cssSelector("#password")).sendKeys("password123");
        WebDriverWait wait = new WebDriverWait(_webdriver, 100);
        while(!wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("login"), "demo")) &&
            !wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("password"), "password123")));
        _webdriver.findElement(By.id("user-loging")).click();

        String text = _webdriver.findElement(By.className("navbar-brand")).getText();
        Assert.assertEquals("We are now logged in", "Test project", text);
    }

    @After
    public void tearDown() {
    }
}
