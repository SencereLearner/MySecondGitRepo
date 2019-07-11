import com.learning.example.BaseClass;
import com.learning.example.LocalChromeWebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Test {

  WebDriver _webdriver;


  @Before
  public void Before (){
    System.setProperty("webdriver.chrome.driver", "/Users/firstlast/Desktop/SELENIUM/ChromeDriver/chromedriver");
    _webdriver = new ChromeDriver();
    ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);
    _webdriver = new ChromeDriver(options);

//    options.addArguments("--disable-infobars");
//    _webdriver = new ChromeDriver(options);


    _webdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  @org.junit.Test

  public void Test1 () throws InterruptedException {

    _webdriver.get("https://vk.com");
    String parent = _webdriver.getWindowHandle();
    BaseClass.OpenLinkInNewTab(_webdriver, "https://google.com");

    Set<String> allTabs = _webdriver.getWindowHandles();
    int countTabs = allTabs.size();
    System.out.println("Total open tabs are: " + countTabs);

    for (String child:allTabs){
      if (!parent.equalsIgnoreCase(child)){
      _webdriver.switchTo().window(child);
      _webdriver.findElement(By.name("q")).sendKeys("Hare Krishna");
    }
    }
    int x = _webdriver.findElement(By.name("q")).getLocation().getX();
    int y = _webdriver.findElement(By.name("q")).getLocation().getY();
    System.out.println("The ipput field location is: X = " + x + " Y = " + y);
    Thread.sleep(1500);






  }

  @After

  public void Quit (){

    _webdriver.quit();
  }




}


