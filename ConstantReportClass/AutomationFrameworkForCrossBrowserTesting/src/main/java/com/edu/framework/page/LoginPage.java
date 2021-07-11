package com.edu.framework.page;

import com.edu.framework.base.BaseClass;
import com.edu.framework.util.DriverFactory;
import com.edu.framework.util.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(xpath = "//input[@name='email']")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signupBtn;

    @FindBy(css = ".ui.negative.message p")
    WebElement failedMsg;

    @FindBy(css = ".tibrr-cookie-consent-button button")
    WebElement gotIt;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String verifyLoginPageTitle() {
        return driver.getTitle();
    }

    public HomePage login(String un, String pwd) {
        TestUtils.waitForElementAndSendTheKeys(driver,username,30,un);
        //username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage(DriverFactory.getDriver());
    }
}
