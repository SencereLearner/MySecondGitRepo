import com.learning.example.LocalChromeWebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class Test {
  private WebDriver _webdriver = new LocalChromeWebDriver().GetWebDriver();
  @Before

  public void Before (){
    _webdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  @org.junit.Test

  public void Test1 (){
    System.out.println("My test");

  }

  @After

  public void Quit (){
    _webdriver.quit();
  }




}


