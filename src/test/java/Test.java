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


    _webdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  @org.junit.Test

  public void Test1 () throws InterruptedException {

    _webdriver.get("https://google.com");

    List<WebElement> links=_webdriver.findElements(By.tagName("a"));

    System.out.println("Total links are "+links.size());

    for(int i=0;i<links.size();i++)
    {

      WebElement ele= links.get(i);

      String url=ele.getAttribute("href");

      BaseClass.verifyBrokenLinks(url);

    }

//success comment




  }

  @After

  public void Quit (){

    _webdriver.quit();
  }




}


