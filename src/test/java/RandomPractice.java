import com.learning.example.BaseClass;
import org.apache.poi.examples.util.TempFileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.AssertJUnit;
import sun.font.TrueTypeFont;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RandomPractice {
  public WebDriver _webdriver;


  @Before
  public void before() {
    System.setProperty("webdriver.chrome.driver", "/Users/firstlast/Desktop/SELENIUM/ChromeDriver/chromedriver");
    _webdriver = new ChromeDriver();
    _webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    _webdriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    _webdriver.manage().window().maximize();

  }

  @Test

  public void test() throws Exception {

_webdriver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

List<WebElement> radio = _webdriver.findElements(By.cssSelector("#male"));
int totalButtons = radio.size();
System.out.println("Total nodes for \"Male\" is: " + totalButtons);
    //checking coordinates
    int x = _webdriver.findElement(By.cssSelector("#male")).getLocation().getX();
    int y = _webdriver.findElement(By.cssSelector("#male")).getLocation().getY();
    System.out.println("The location is: " + x + "," + y);

  for (int i = 0; i<radio.size(); i++){

    WebElement element = radio.get(i);
    int location = element.getLocation().getX();
  if (location==0){
    System.out.println("The chosen element is hidden, go to the next one--->>>");
  }
  else {
    System.out.println("The right element got found");
    radio.get(i).click();
    break;
  }
}





//BaseClass.IfElementNotClickableUseActionClassMethod(_webdriver, "/html/body/div[2]/div[2]/div/quote-button/button/span[1]");
Thread.sleep(1000);






  }
    @After
    public void after () {
    _webdriver.quit();
    }
}



///------------------
//    _webdriver.get("https://staging-ams.internal.apps.insureon.com/#/client/70106375-233c-4ed5-b785-3b4654e7c733/quotes");
//    BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[@id=\"unauthenticated-shell-dropdown\"]/a/span[1]");
//    _webdriver.findElement(By.xpath("//*[@id=\"unauthenticated-shell-dropdown\"]/a/span[1]")).click();
//    _webdriver.findElement(By.xpath("//*[@id=\"loginIdInput\"]")).sendKeys("qa");
//    _webdriver.findElement(By.xpath("//*[@id=\"loginPasswordInput\"]")).sendKeys("123");
//    BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[@id=\"loginBtn\"]");
//    _webdriver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
//    Thread.sleep(2000);
//
//    for (int i = 1; i<5; i++){
//      String values = _webdriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr[" + i + "]/td[5]")).getText();
//      System.out.println("Value " + i + " is: " + values);
//    }
//----------------
//    _webdriver.findElement(By.cssSelector("#email")).sendKeys("genesisprognosis1156@gmail.com");
//            _webdriver.findElement(By.name("passwd")).sendKeys("123456");
//            _webdriver.findElement(By.cssSelector("#SubmitLogin")).click();
//            WebDriverWait wait = new WebDriverWait(_webdriver, 5);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Order history and details']")));
//            _webdriver.findElement(By.xpath("//*[text()='Order history and details']")).click();
//
//            //WebElement val = _webdriver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[" + 2 + "]/td[1]/a"));
//
//            ArrayList<String> allValues = new ArrayList<>();
//        for (int i = 1; i < 6; i++) {
//        String result = _webdriver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[" + i + "]/td[1]/a")).getText();
//        allValues.add(result);
//        System.out.println("Value " + i + ": " + _webdriver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[" + i + "]/td[1]/a")).getText());
//        }
//
//        Thread.sleep(1000);
////    for (int i = 0; i < 5; i++) {
////      System.out.println(allValues.get(i));
////    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  String allValues = _webdriver.findElement(By.xpath("//div[@class='footer-links']/div[1]/ul")).getText();
//    System.out.println("Values are: ");
//            System.out.println(allValues);
//
//            //String actual = "Professional Liability, Errors and Omissions, General Liability, Business Owner's Policy, Workers' Compensation, Cyber Liability";
//            if (allValues.contains("Professional Liability, General Liability")){
//            System.out.println("Test passed");
//            String text = _webdriver.findElement(By.linkText("Professional Liability")).getText();
//            _webdriver.findElement(By.linkText("Professional Liability")).click();
//            System.out.println("Clicked on " + text);
//            }
//            else {
//            System.out.println("Test failed");
//            }

//////////////////

//    BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[@id=\"unauthenticated-shell-dropdown\"]/a");
//            _webdriver.findElement(By.xpath("//*[@id=\"unauthenticated-shell-dropdown\"]/a")).click();
//            _webdriver.findElement(By.xpath("//*[@id=\"loginIdInput\"]")).sendKeys("qa");
//            _webdriver.findElement(By.xpath("//*[@id=\"loginPasswordInput\"]")).sendKeys("123");
//            BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[@id=\"loginBtn\"]");
//            _webdriver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
//            Thread.sleep(2000);
//            _webdriver.get("https://staging-ams.internal.apps.insureon.com/#/client/70106375-233c-4ed5-b785-3b4654e7c733/quotes");
//
//            Thread.sleep(2000);
//            WebElement element = _webdriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[1]/a"));
//            Actions actions = new Actions(_webdriver);
//            actions.moveToElement(element).click().perform();
//            Thread.sleep(1500);
//            BaseClass.WaitUntilElementIsVisible(_webdriver, "//*[@id=\"Documents\"]");
//            _webdriver.findElement(By.xpath("//*[@id=\"Documents\"]")).click();
//            _webdriver.findElement(By.xpath("//*[@id=\"Client Files\"]")).click();
//            Thread.sleep(1500);
//
//            String color = _webdriver.findElement(By.xpath("//*[@id=\"Documents\"]")).getCssValue("color");
//            String backcolor = _webdriver.findElement(By.xpath("//*[@id=\"Documents\"]")).getCssValue("background-color");
//            System.out.println(color);
//            System.out.println(backcolor);
//
//            Thread.sleep(1000);
//            _webdriver.findElement(By.xpath("//*[@id=\"mainBox\"]/div[3]/div[1]/div/div[2]/div[2]/span/button")).click();
//            _webdriver.findElement(By.xpath("//*[@id=\"uploadFile\"]")).sendKeys("/Users/firstlast/Desktop/20180402_173309.jpg");
//            Thread.sleep(2000);
//            _webdriver.findElement(By.xpath("//*[@id=\"documentForm\"]/div[2]/div/textarea")).sendKeys("Hare Krishna.\nHare Rama.");
//            Thread.sleep(1000);
//
//            WebElement element1 = _webdriver.findElement(By.xpath("//*[@id=\"documentForm\"]/div[5]/div/button[1]"));
//            ((JavascriptExecutor)_webdriver).executeScript("arguments[0].scrollIntoView();",element1);
//            _webdriver.findElement(By.xpath("//*[@id=\"documentForm\"]/div[5]/div/button[1]")).click();



