package com.edu.framework.page;


import com.edu.framework.util.DriverFactory;
import com.edu.framework.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.edu.framework.base.BaseClass;

import java.io.IOException;


public class ContactsPage extends BaseClass {
    @FindBy(xpath = "//div[@id='main-nav']/div/a/i[@class='users icon']")
    WebElement contactPageLable;

    @FindBy(name = "first_name")
    WebElement firstname;

    @FindBy(name = "last_name")
    WebElement lastname;

    @FindBy(xpath = "//div[@name='company']")
    WebElement cmpny;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement save;
    @FindBy(xpath = "//div[@class='item']/a/button")
    WebElement create;
    @FindBy(xpath = "//div[@id='dashboard-toolbar']/div[1]")
    WebElement contactName;

    WebDriver driver;

    public ContactsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean verifyConatctLabel() {

        return contactPageLable.isDisplayed();
    }

    public void selectContactByCount(int count) {
        driver.findElement(By.xpath("//div[@class='table-wrapper']/table/tbody/tr[" + count + "]/td/div/input")).click();
    }

    public String createNewContact(String ftname, String ltname, String cmp) throws InterruptedException, IOException {
        Thread.sleep(2000);
        create.click();
        TestUtils.waitForElement(driver, firstname, 20);
        //.visibilityOfElementLocated((By) firstname));
        firstname.sendKeys(ftname);
        lastname.sendKeys(ltname);
        try {
            cmpny.sendKeys(cmp);
        } catch (Exception e) {
            TestUtils.senKeysWithJSExecutor(driver, cmpny, cmp);
        }

        save.click();
        Thread.sleep(3000);
        return contactName.getText();
    }
}
