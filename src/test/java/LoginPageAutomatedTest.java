import com.learning.example.LocalChromeWebDriver;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class LoginPageAutomatedTest {
    //Initialize webdriver (turn on)
    private WebDriver _webdriver = new LocalChromeWebDriver().GetWebDriver();


    @Before

    public void Before() {
        _webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        _webdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //_webdriver.manage().window().fullscreen();
    }
    @Test
    public void Test1() throws InterruptedException {
           _webdriver.get("file:///"+LocalChromeWebDriver.GetWebUrl());
           _webdriver.findElement(By.id("login")).sendKeys("demo");
           _webdriver.findElement(By.id("password")).sendKeys("123");
           _webdriver.findElement(By.xpath("//input[@id='user-loging']")).click();
           Thread.sleep(3000);
           _webdriver.findElement(By.xpath("//a[contains(@href, 'forgot.html')]")).click();
           _webdriver.findElement(By.id("login")).sendKeys("demo");
           _webdriver.findElement(By.xpath("/html/body/div/div/form/input[2]")).click();
           Thread.sleep(3000);
           _webdriver.switchTo().alert().accept();
           _webdriver.navigate().back();
           _webdriver.findElement(By.name("password")).clear();
           _webdriver.findElement(By.name("password")).sendKeys("password123");
           Thread.sleep(3000);
           _webdriver.findElement(By.xpath("//input[@id='user-loging']")).click();
           _webdriver.navigate().back();
           _webdriver.findElement(By.xpath("//div[@id='formFooter']/a[@href='register.html']")).click();
           Thread.sleep(3000);
           _webdriver.findElement(By.id("login")).sendKeys("Hare");
           _webdriver.findElement(By.id("password")).sendKeys("Krishna");
           Thread.sleep(3000);
           _webdriver.findElement(By.xpath("//input[@type='submit']")).click();
           Thread.sleep(3000);
           _webdriver.switchTo().alert().dismiss();
           Thread.sleep(3000);
           _webdriver.findElement(By.xpath("//div[@id='formFooter']/a[@href='register.html']")).click();
           _webdriver.findElement(By.id("login")).clear();
           _webdriver.findElement(By.id("login")).sendKeys("Rama");
           _webdriver.findElement(By.id("password")).clear();
           _webdriver.findElement(By.id("password")).sendKeys("Vani");
           Thread.sleep(3000);
           _webdriver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
           _webdriver.switchTo().alert().dismiss();
        Thread.sleep(3000);
           _webdriver.findElement(By.xpath("//div[@id='formFooter']/a[@href='register.html']")).click();
        Thread.sleep(3000);
        _webdriver.findElement(By.id("login")).sendKeys("Sergey");
        _webdriver.findElement(By.id("password")).sendKeys("The Conqueror");
        _webdriver.findElement(By.xpath("//div[@id='formFooter']/a[@href='register.html']")).click();






        //_webdriver.switchTo().window()
          //_webdriver.findElement(By.cssSelector("class.title style-scope ytd-guide-entry-renderer")).click();


//        String text = _webdriver.findElement(By.className("navbar-brand")).getText();
//        Assert.assertEquals("We are now logged in", "Test project", text);
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

      //@After
    public void tearDown() {
        _webdriver.quit();
    }
}


//          _webdriver.get("https://www.google.com/");
//        _webdriver.findElement(By.name("q")).sendKeys("Java");
//        Thread.sleep(3000);
//        _webdriver.findElement(By.name("btnK")).click();
//        JavascriptExecutor jse = (JavascriptExecutor) _webdriver;
//        jse.executeScript("scroll(0,30000)");
//        Thread.sleep(3000);
//        _webdriver.findElement(By.id("gsr")).click();
//        Thread.sleep(3000);
//        String url = _webdriver.getCurrentUrl();
//        System.out.println("The current URL is " + url);
//        String pageTitle = _webdriver.getTitle();
//        System.out.println("The title is " + pageTitle);
//        Thread.sleep(3000);
//        _webdriver.navigate().refresh();
//        Thread.sleep(3000);
//        _webdriver.navigate().back();
//        Thread.sleep(3000);
//        _webdriver.navigate().forward();
//        Thread.sleep(3000);
//        _webdriver.navigate().to("https://www.youtube.com/");
//        Thread.sleep(3000);
//        _webdriver.findElement(By.id("search")).sendKeys("Scooter Trance Atlantic");
//        Thread.sleep(3000);
//        _webdriver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]")).click();
//        _webdriver.findElement(By.id("video-title")).click();
//        control + command + g will highlight all the instances with matching values of what we selected
