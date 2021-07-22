package com.edu.framework.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;

public class TestUtils {
    public static Workbook book;
    public static Sheet sheet;
    public static final String TESTDATA_FILE_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\edu\\framework\\testdata\\Book1.xlsx";
    public static void waitForElement(WebDriver driver, WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void senKeysWithJSExecutor(WebDriver driver, WebElement element, String text) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='" + text + "';", element);
    }

    public static void waitForSpinners(WebDriver driver, WebElement ele) {

    }

    public static void waitForElementAndSendTheKeys(WebDriver driver, WebElement element, int time, String text) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.isDisplayed();
        element.clear();
        element.sendKeys(text);
    }
//int obj[][]= {{1,2},{2,3},{3,4},{}};
// obj[0][0] =1
    //obj[0][1]=2
    // obj[1][0]=2
    //obj[1][1]=3
    //obj[2][0]=3
    //obj[2][1]=4
    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;

        try {
            file = new FileInputStream(TESTDATA_FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        //Object [][] data = new Object [4][3];
        //data[1][1];
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i +1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }

}

