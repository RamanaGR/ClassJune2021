package com.edu.frameworktest.test;

import com.edu.framework.base.BaseClass;
import com.edu.framework.page.LandingPage;
import com.edu.framework.util.ExtentReportConfig;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LandingPageTest extends BaseClass {
    LandingPage landingPage;
    public LandingPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(Method method) {
        init();
       landingPage = new LandingPage();
        ExtentReportConfig.startTest(method.getName(),"");
    }

    @Test(enabled = true)
    public void testTitle() {
        String actual = landingPage.verifyTitle();
        String expected = "#1 Free CRM customer relationship management software cloud";
        Assert.assertEquals(expected, actual);
    }

    @Test(enabled = false)
    public void testLandingPageLogo() {
        boolean isLogo = landingPage.verifyLogo();
        Assert.assertTrue(isLogo);
    }

    @Test(enabled = true)
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
