package com.learning.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class LocalChromeWebDriver {

    private WebDriver _webDriver;

    public LocalChromeWebDriver() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            URL res = null;
            if (os.indexOf("win") >= 0) {
                res = getClass().getClassLoader().getResource("chromedriver.exe");
            } else if (os.indexOf("mac") >= 0) {
                res = getClass().getClassLoader().getResource("chromedriver");
            }

            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", absolutePath);
            _webDriver = new ChromeDriver();

        } catch (URISyntaxException ex) {
        }
    }

    public  WebDriver GetWebDriver() {
        return _webDriver;
    }

    public static String GetWebUrl() {
        try {
            URL res = LocalChromeWebDriver.class.getClassLoader().getResource("automated-learning/index.html");
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            return absolutePath;
        } catch (URISyntaxException ex) {
            return "";
        }
    }
}
