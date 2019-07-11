import com.learning.example.BaseClass;
import com.learning.example.LocalChromeWebDriver;
import junit.framework.TestResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestException;
import sun.jvm.hotspot.code.SafepointBlob;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.xml.bind.Element;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPageAutomatedTest {
  public WebDriver _webdriver = new LocalChromeWebDriver().GetWebDriver();

  //BaseClass BaseClass = new BaseClass();
  @Before
  public void Before() {
    _webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    _webdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    _webdriver.manage().window().maximize();
  }

  @Test
  public void Test1() throws InterruptedException {
    //_webdriver.get("file:///"+LocalChromeWebDriver.GetWebUrl());
    _webdriver.navigate().to("https://www.insureon.com/");
    String parentHandle = _webdriver.getWindowHandle();
    BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[text()='Twitter']");
    BaseClass.ScrollDownToLocateElement(_webdriver, "//*[text()='Twitter']");//don't have to scroll down(optional)
    WebElement linkedIN = _webdriver.findElement(By.xpath("//*[text()='Twitter']"));
    Actions newTab= new Actions(_webdriver);
    newTab.keyDown(Keys.COMMAND).click(linkedIN).keyUp(Keys.COMMAND).build().perform();
    BaseClass.SwitchFocus(_webdriver);
    Thread.sleep(1500);
    //BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[@id=\"signin-link\"]/span[2]");
    _webdriver.findElement(By.xpath("//*[@id=\"signin-link\"]/span[2]")).click();
    _webdriver.findElement(By.id("search-query")).sendKeys("Hare Krishna");
    WebElement enter=_webdriver.findElement(By.id("search-query"));
    enter.sendKeys(Keys.ENTER);
    Thread.sleep(1000);
    String testText = _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[1]/button")).getText();
    _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[1]/button")).click();
    Thread.sleep(1000);
    _webdriver.findElement(By.xpath("//*[@id=\"stream-item-user-98057130\"]/div/div/a/img")).click();
    BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[@id=\"page-container\"]/div[1]/div/div[1]/div[2]/div[1]/div/a/img");
    _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[1]/div/div[1]/div[2]/div[1]/div/a/img")).click();
    Thread.sleep(1500);
//    BaseClass.ScreenshotTaken(_webdriver, "Krishna");
//
//    WebElement logo = _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[1]/div/div[1]/div[2]/div[1]/div/a/img"));
//    String logoSRC = logo.getAttribute("src");
//
//    try {
//      URL imageURL = new URL(logoSRC);
//      BufferedImage saveImage = ImageIO.read(imageURL);
//
//      ImageIO.write(saveImage, "png", new File ("/Users/firstlast/Desktop/Selscr/KrishnaPicture.png"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    Thread.sleep(300);

    Actions action = new Actions(_webdriver);
    action.sendKeys(Keys.ESCAPE).build().perform();

    Thread.sleep(1000);
    WebElement highlightedText = _webdriver.findElement(By.xpath("//div[@class='ProfileHeaderCard']/p"));
    BaseClass.HighlightElementBackgroundAndBorder(_webdriver, highlightedText);
    String cutText = _webdriver.findElement(By.xpath("//div[@class='ProfileHeaderCard']/p")).getText();
    String textCut = cutText.substring(20, 26);


    WebElement highlightedText2 = _webdriver.findElement(By.id("search-query"));
    BaseClass.HighlightElementBackgroundAndBorder(_webdriver, highlightedText2);

    _webdriver.findElement(By.id("search-query")).sendKeys(textCut);
    action.sendKeys(Keys.ENTER).build().perform();
    Thread.sleep(700);
    _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[1]/button")).click();

    WebElement field1 = _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[2]/select"));
    BaseClass.HighlightElementBorderOnly(_webdriver, field1);
    Thread.sleep(500);
    _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[2]/select")).click();
    Thread.sleep(500);
    action.sendKeys(Keys.ESCAPE).build().perform();

    WebElement field2 = _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[3]/select"));
    BaseClass.HighlightElementBorderOnly(_webdriver, field2);
    Thread.sleep(500);
    _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[3]/select")).click();
    Thread.sleep(500);
    Select el2 = new Select(_webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[3]/select")));
    el2.selectByIndex(1);
    WebElement field3 = _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[4]/select"));
    BaseClass.HighlightElementBorderOnly(_webdriver, field3);
    Thread.sleep(500);
    _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[4]/select")).click();
    Thread.sleep(500);
    _webdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div[1]/div[4]/select/option[61]")).click();
    Thread.sleep(300);
    BaseClass.ScrollDownToLocateElement(_webdriver, "//*[text()='Help Center']");
    WebElement link2 = _webdriver.findElement(By.xpath("//*[text()='Help Center']"));
    Actions newTab2= new Actions(_webdriver);
    newTab2.keyDown(Keys.COMMAND).click(link2).keyUp(Keys.COMMAND).build().perform();
    Thread.sleep(700);
    BaseClass.SwitchFocus(_webdriver);
    //----> Help Center got opened
    BaseClass.WaitUntilElementIsVisible(_webdriver, "/html/body/div[1]/footer/div/div[1]/div/div[3]/a");
    BaseClass.ScrollDownToLocateElement(_webdriver, "/html/body/div[1]/footer/div/div[1]/div/div[3]/a");
    _webdriver.findElement(By.xpath("/html/body/div[1]/footer/div/div[1]/div/div[3]/a")).click();
    Thread.sleep(2000);
    //-----------> CAN'T CLICK ON ACCEPT/DECLINE COOKIES OR ON APPLY BUTTON
    //BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[text()='Apply']");
    //_webdriver.findElement(By.xpath("//*[text()='Apply']")).click();
    _webdriver.switchTo().window(parentHandle);
    Thread.sleep(1000);
    String url = "https://www.vk.com";
    ((JavascriptExecutor)_webdriver).executeScript("window.open(arguments[0])",url);


    ArrayList<String> tabs4 = new ArrayList<String> (_webdriver.getWindowHandles());
    _webdriver.switchTo().window(tabs4.get(4));
    Thread.sleep(800);
    _webdriver.close();
    _webdriver.switchTo().window(tabs4.get(3));
    Thread.sleep(800);
    _webdriver.close();
    _webdriver.switchTo().window(tabs4.get(2));
    Thread.sleep(800);
    _webdriver.close();
    _webdriver.switchTo().window(tabs4.get(1));
    Thread.sleep(800);
    _webdriver.close();
    _webdriver.switchTo().window(parentHandle);

    _webdriver.get("https://www.facebook.com/");
    BaseClass.SwitchFocus(_webdriver);
    WebDriverWait wait = new WebDriverWait(_webdriver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("birthday_month")));
    Select dropDown = new Select(_webdriver.findElement(By.name("birthday_month")));
    dropDown.selectByIndex(2);
    WebElement testCondition = dropDown.getFirstSelectedOption();

    if (testCondition.getText().equals("Feb")){
      System.out.println("The test is successful, please continue");
    }
    else {
      System.out.println("The test failed, cease.");
      _webdriver.quit();
    }

    WebElement firstOption = dropDown.getFirstSelectedOption();
    System.out.println("The default values is " + firstOption.getText());

    List<WebElement> allDropDownValues = dropDown.getOptions();
    int totalCount = allDropDownValues.size();
    System.out.println("The total drop down size is " + totalCount);

    for (WebElement allValuesListed : allDropDownValues){
      String allNames = allValuesListed.getText();
      System.out.println("All the values are " + allNames);
    }
    if (firstOption.getText().equals("Feb")){
      System.out.println("The test passed");
    }
    else {
      System.out.println("The test failed");
      _webdriver.quit();
    }































  }

    @After
    public void tearDown() {
    _webdriver.quit();
    }


  }


