package com.edu.framework.base;

import com.edu.framework.util.DriverFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    //public static WebDriver driver;
    public static Properties prop;

    DriverFactory driver;

    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/java/com/edu/framework/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jPath);
    }

    /* public static void init() {
         System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
         driver.get(prop.getProperty("url"));
         //driver.findElement(By.id(""));
     }*/
    @BeforeTest
    @Parameters("browser")
    public void init(String browser) {
        driver = new DriverFactory();
        driver.init_driver(browser).get(prop.getProperty("url"));
    }

}
