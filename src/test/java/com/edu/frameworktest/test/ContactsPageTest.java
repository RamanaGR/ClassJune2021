package com.edu.frameworktest.test;

import com.edu.framework.base.BaseClass;
import com.edu.framework.page.ContactsPage;
import com.edu.framework.page.HomePage;
import com.edu.framework.page.LandingPage;
import com.edu.framework.page.LoginPage;

import com.edu.framework.util.TestUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class ContactsPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage hp;
    ContactsPage cp;
    LandingPage lp;
    String sheetname = "contacts";

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        init();
        loginPage = new LoginPage();
        hp = new HomePage();
        cp = new ContactsPage();
        lp = new LandingPage();
        lp.login();
        hp = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        //lp.clickGotIt();
        hp.clickOnContacts();
    }

    @Test(priority = 1,enabled = false)
    public void verifyConatctsPageLabelTest() {
        Assert.assertTrue(cp.verifyConatctLabel(), "Cotacts lbel is not displayed");
    }

    @Test(priority = 3,enabled = false)
    public void selectContactTest() {
        cp.selectContactByCount(2);
    }

    @Test(priority = 2,enabled = false)
    public void validateCreateNewContact() throws InterruptedException, IOException {
        String actual = null;
        try {
            actual = cp.createNewContact(prop.getProperty("firstName"), prop.getProperty("lastName"),
                    prop.getProperty("cmpny"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(actual, "vedang grao");
    }


   @DataProvider
    public Object[][] getContactTestData() {
        Object data[][] = TestUtils.getTestData(sheetname);
        return data;
    }
    //csv - comma seperated values- abu,mondal,inno -- OpenCSV lib

    @Test(dataProvider = "getContactTestData")
    public void validateCreateNewContact(String fname, String lname, String cpny) throws IOException, InterruptedException {
        cp.createNewContact(fname, lname, cpny);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
