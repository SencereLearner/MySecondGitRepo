import com.learning.example.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewAutomationProject {
  public WebDriver _webdriver;

  @Before
  public void BeforeTest(){
    System.setProperty("webdriver.chrome.driver", "/Users/firstlast/Desktop/SELENIUM/ChromeDriver/chromedriver");
    _webdriver = new ChromeDriver();
    _webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  @Test
  public void Test(){
    _webdriver.get("https://vk.com");

    List<WebElement> links=_webdriver.findElements(By.tagName("a"));

    System.out.println("Total links are "+links.size());

    for(int i=0;i<links.size();i++)
    {

//      WebElement ele= links.get(i);
//
//      String url=ele.getAttribute("href");

      //BaseClass.verifyLinkActive("https://vk.com");

    }



  }

  @After
  public void After(){
    _webdriver.quit();
  }

}
