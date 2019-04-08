import com.learning.example.LocalChromeWebDriver;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageAutomatedTest {

    private WebDriver _webdriver = new LocalChromeWebDriver().GetWebDriver();

    @Before()
    public void Before() {
        _webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test1() throws InterruptedException {
        _webdriver.get("file:///"+LocalChromeWebDriver.GetWebUrl());

        // login
        _webdriver.findElement(By.id("login")).sendKeys("demo");
        _webdriver.findElement(By.id("password")).sendKeys("password123");
        _webdriver.findElement(By.id("user-loging")).click();

        String text = _webdriver.findElement(By.className("navbar-brand")).getText();
        Assert.assertEquals("We are now logged in", "Test project", text);
    }

//    @Test
//    public void Test2() throws InterruptedException {
//        _webdriver.get(LocalChromeWebDriver.GetWebUrl());
//        Thread.sleep(3000); // 3seconds for the page to load
//        // login
//        _webdriver.findElement(By.linkText("Forgot Password?")).click();
//
//        Thread.sleep(3000); // 3seconds for the page to load
//
//        _webdriver.findElement(By.cssSelector("#login")).sendKeys("demo");
//        _webdriver.findElement(By.id("user-forgot")).click();
//
//        _webdriver.switchTo().alert().accept();
//    }

    @After
    public void tearDown() {
        _webdriver.quit();
    }
}
