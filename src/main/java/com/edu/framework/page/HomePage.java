package com.edu.framework.page;


import com.edu.framework.util.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.edu.framework.base.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//div[@id='main-nav']/div/a/i[@class='users icon']")
    WebElement contacts;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {

        return driver.getTitle();
    }

    public void clickOnContacts() {
        TestUtils.waitForElement(driver, contacts, 30);
        contacts.click();
    }
}
