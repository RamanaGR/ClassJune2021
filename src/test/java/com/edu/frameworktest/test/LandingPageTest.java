package com.edu.frameworktest.test;

import com.edu.framework.base.BaseClass;
import com.edu.framework.page.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseClass {
    LandingPage landingPage;
    public LandingPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        init();
       landingPage = new LandingPage();
    }

    @Test(enabled = true)
    public void testTitle() {
        String actual = landingPage.verifyTitle();
        String expected = "#1 Free CRM customer relationship management software cloud";
        Assert.assertEquals(expected, actual);
    }

    @Test(enabled = true)
    public void testLandingPageLogo() {
        boolean isLogo = landingPage.verifyLogo();
        Assert.assertTrue(isLogo);
    }

    @Test
    public void testLoginButton() {
        boolean isLogin = landingPage.verifyLoginButton();
        landingPage.login();
        Assert.assertTrue(isLogin);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
