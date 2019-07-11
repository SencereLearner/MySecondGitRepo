package com.learning.example;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseClass {

  public static void IfElementNotClickableUseActionClassMethod(WebDriver _webdriver, String xpath){
    Actions act = new Actions(_webdriver);
    act.moveToElement(_webdriver.findElement(By.xpath(xpath))).click().build().perform();
  }

  public static void OpenLinkInNewTab(WebDriver _webdriver, String url){
    ((JavascriptExecutor)_webdriver).executeScript("window.open(arguments[0])",url);
  }



  public static void ScreenshotTaken(WebDriver _webdriver, String screenshotName){
    TakesScreenshot ts = (TakesScreenshot) _webdriver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    try {
      FileHandler.copy(source, new File("/Users/firstlast/Desktop/Selscr/"+screenshotName+".png"));
    } catch (IOException e) { e.printStackTrace();
    }
  }

  public static void HighlightElementBackgroundAndBorder(WebDriver _webdriver, WebElement element){
    //Second parameter WebElement element just means we have to say _webdriver.findElement...define path
    JavascriptExecutor js = (JavascriptExecutor) _webdriver;
    js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", element);
//    the bottom code will unhighlight the fields, after being highlighted for half a second.
//    try {
//      Thread.sleep(500);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//      System.out.println(e.getMessage());
//    }
//    js.executeScript("arguments[0].setAttribute('style', 'border: solid 2px white')", element);
  }
  public static void HighlightElementBorderOnly(WebDriver _webdriver, WebElement element){
    JavascriptExecutor js = (JavascriptExecutor) _webdriver;
    js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
//    the bottom code will unhighlight the fields, after being highlighted for half a second.
//    try {
//      Thread.sleep(500);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//      System.out.println(e.getMessage());
//    }
//    js.executeScript("arguments[0].setAttribute('style', 'border: solid 2px white')", element);
  }

  public static void SwitchFocus(WebDriver _webdriver){
    for (String winHandle : _webdriver.getWindowHandles()){
      _webdriver.switchTo().window(winHandle);}
  }

  public static void ScrollDown(WebDriver _webdriver){
    JavascriptExecutor jse6 = (JavascriptExecutor)_webdriver;
    jse6.executeScript("scroll(0,10000)");

  }

  public static void ScrollDownToLocateElement(WebDriver _webdriver, String xpath){
    WebElement element = _webdriver.findElement(By.xpath(xpath));
    ((JavascriptExecutor)_webdriver).executeScript("arguments[0].scrollIntoView();",element);
    //Note: in case test fails here, make sure we look for elements by xpath only, as indicated here.
    //Can have the same method but locating elements by name, id, css or other way.
  }
//test method below which I need to delete after checking

//      public static String CutText(WebElement someText){
//      //emailTitle = "Automatic reply: Certificate of Insurance";
//      return someText.substring(20,26).trim();
//  }
   public static String CutText(String someText){

    return someText.substring(20, 26).trim();
   }
//  public static String getClientId(String inputString) {
//        String locator = "Client ID:";
//        int startPosition = inputString.indexOf(locator) + locator.length();
//        int endPosition = inputString.indexOf("\n", startPosition);
//        return inputString.substring(startPosition, endPosition).trim();
  //}

  public static String ClientID2(String idString){

    return idString.substring(11).trim();
  }
  public static void WaitUntilElementIsVisible(WebDriver _webdriver, String xpath){
    WebDriverWait wait = new WebDriverWait(_webdriver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
  }

  //===================================================================================================================//
  //THE METHOD BELOW IS FOR READING EXCEL. I HAVE THE SAME METHOD IN EXCELSHEETSFUNCTIONS CLASS, WHICH IS SPECIALLY MEANT FOR THAT. THIS IS JUST TO KEEP ALL THE METHODS I HAVE TOGETHER.
  //I USED CONSTRUCTOR HERE AND THAT'S WHY THE EXCEL SHEET READING METHOD IS CALLED BASE CLASS, BECAUSE CONSTRUCTOR'S NAME HAS TO MATCH CLASS NAME.
  XSSFWorkbook wb;
  XSSFSheet sheet1;
  //In order to use this class from our main section (@Test or main method), we need to:
  // 1) Create an instance of this class, thus invoking BaseClass method, thus setting up Excel and specify Excel path 2) And then to call readExcelData method.
  public BaseClass (String excelPath){
    try {
      File src = new File(excelPath);
      FileInputStream fis = new FileInputStream(src);
      wb = new XSSFWorkbook(fis);
    }
    catch (Exception e) {
      System.out.println("The error message is " + e.getMessage());
    }
  }

  public String readExcelData (int sheetNumber, int row, int column){
    sheet1 = wb.getSheetAt(sheetNumber);
    String data = sheet1.getRow(row).getCell(column).getStringCellValue();
    return data;
  }
  //===================================Verify Broken Links Method======================================================//

  public static void verifyBrokenLinks(String linkUrl)
  {
    try
    {
      URL url = new URL(linkUrl);

      HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

      httpURLConnect.setConnectTimeout(3000);

      httpURLConnect.connect();

      if(httpURLConnect.getResponseCode()==200)
      {
        System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
      }
      if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
      {
        System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
      }
    } catch (Exception e) {

    }
  }
  //===================================================================================================================//

}





