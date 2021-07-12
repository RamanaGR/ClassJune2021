package com.edu.frameworktest.test;

import com.edu.framework.base.BaseClass;
import com.edu.framework.page.HomePage;
import com.edu.framework.page.LandingPage;
import com.edu.framework.page.LoginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    LandingPage landingPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        init();
        loginPage = new LoginPage();
        homePage = new HomePage();
        landingPage = new LandingPage();
        landingPage.login();//for login page
//        loginPage.login("","");//for homepage
//        homePage.clickOnContacts();// for ContactsPage
    }

    @Test(enabled = true)
    public void loginPageTitle() {

        String title = loginPage.verifyLoginPageTitle();//Title
        Assert.assertEquals(title, "Cogmento CRM");
    }

    @Test(enabled = false)
    public void loginTest() {
        String un = prop.getProperty("username");
        String pw = prop.getProperty("password");
        homePage = loginPage.login(un, pw);
       String titleOfHomePage = homePage.verifyHomePageTitle();
        Assert.assertEquals(titleOfHomePage, "Cogmento CRM");
    }

    @AfterMethod
    public void tearDown() {
      driver.close();
    }

}
