package com.edu.framework.page;

import com.edu.framework.base.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseClass {
    //WebElement logo1 = driver.findElement(By.xpath("//div[@class=\"rd-navbar-panel\"]"));
    //Object Repository
    @FindBy(xpath = "//div[@class='rd-navbar-panel']")    //Pagefactory
            WebElement logo;
    @FindBy(xpath = "//div[@class='rd-navbar-wrap']/a")
    WebElement login;
    @FindBy(xpath = "//span[@class='mdi-chart-bar icon icon-md']")
    WebElement signup;
    @FindBy(css = ".tibrr-cookie-consent-button button")
    WebElement gotIt;

    public LandingPage() {
        PageFactory.initElements(driver, this);
    }


    public String verifyTitle() {
        String title = driver.getTitle();
        return title;
    }

    public boolean verifyLogo() {
        boolean isDisplayed = logo.isDisplayed();
        return isDisplayed;
    }

    public boolean verifyLoginButton() {
        boolean isLogin = login.isEnabled();
        return isLogin;
    }

    public LoginPage login() {
        try {
            if (gotIt.isDisplayed())
                gotIt.click();
        } catch (Exception e) {

        }
        login.click();
        return new LoginPage();
    }

    public void clickGotIt() {
        if (gotIt.isDisplayed())
            gotIt.click();
    }

    public boolean verifySignUpButton() {
        boolean isSignUp = signup.isEnabled();
        return isSignUp;
    }

    public SignUpPage signUp() {
        signup.click();
        return new SignUpPage();
    }
}
