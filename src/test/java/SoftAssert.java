import com.learning.example.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SoftAssert {

  WebDriver _webdriver;


  @Before
  public void before(){
    System.setProperty("webdriver.chrome.driver", "/Users/firstlast/Desktop/SELENIUM/ChromeDriver/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.setAcceptInsecureCerts(true);
    _webdriver = new ChromeDriver(options);
    _webdriver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
    _webdriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
  }

@Test
  public void test(){

  _webdriver.get("https://adp-ams.internal.apps.adpiapcquote.com/#/client/6f3b352c-645e-54a1-906d-ce8999b30f08/quotes/bb3cbad1-723b-472d-87e5-08fe51c7fdea");
  WebDriverWait wait = new WebDriverWait(_webdriver,5);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"unauthenticated-shell-dropdown\"]/a/span[1]")));
  _webdriver.findElement(By.xpath("//*[@id=\"unauthenticated-shell-dropdown\"]/a/span[1]")).click();
  _webdriver.findElement(By.xpath("//*[@id=\"loginIdInput\"]")).sendKeys("qa");
  _webdriver.findElement(By.xpath("//*[@id=\"loginPasswordInput\"]")).sendKeys("w@8Hiere");
  _webdriver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/ul/li[1]/a")));
  boolean test1 = _webdriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/ul/li[1]/a")).isDisplayed();
  System.out.println("Is element visible? " + test1);
  String alerts = _webdriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/ul")).getText();
  System.out.println("Alerts are: \n" + alerts);
  List<WebElement> all = _webdriver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/ul/li"));
  int totalCount = all.size();
  System.out.println("Total messages are: " + totalCount);

  Assert.assertEquals("Mismatch", 10, totalCount);

  List<WebElement> sixValies = _webdriver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/ul/li"));
  System.out.println("The bootstrap links are: ");
  for (int i = 0; i<sixValies.size(); i++){
    String text = sixValies.get(i).getText();
    System.out.println(text);
    if (text.equalsIgnoreCase("alerts")){
      String chosenElement = _webdriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/ul/li[1]/a")).getText();
      System.out.println("The chosen element is: " + chosenElement);
      _webdriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/ul/li[1]/a")).click();
      break;
    }
  }
  System.out.println("All tests passed.");


  WebElement myFrame = _webdriver.findElement(By.xpath("xpath"));
  _webdriver.switchTo().frame(myFrame);


}

@After

  public void after(){
    _webdriver.quit();
}





}


