package com.edu.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Palindrome {
    public WebDriver driver;
    public Properties prop;
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("abdcg"));
    }
    public void  propRead() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isPalindrome(String str) {

        if (str == null) {
            return false;
        }
        if (str.isEmpty())
            return false;
        int length = str.length() - 1;
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }

public void init(){
    System.setProperty("webdriver.chrome.driver",  "c/Users/chinn/Desktop/drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);//TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    driver.get(prop.getProperty("url"));
   /* else if(browserName.equals("FireFox")){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    else if (browserName.equals("Opera")){
        System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/drivers/operadriver.exe");
        driver = new OperaDriver();
    }*/
}
//Log4j Setup

/*
 public static Logger logger = null;

@BeforeTest
public static void setLog4j() {
public static Logger logger=null;
    String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
    PropertyConfigurator.configure(log4jPath);
}
  <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <dependency>
            <groupId>com.relevantcodes</groupId>
            <artifactId>extentreports</artifactId>
            <version>2.41.2</version>
        </dependency>

        logger = Logger.getLogger(LoginPage.class.getName());
        logger.info("***********************LoginPageTest Started***************************");
*/
//Extent reports Setup
/*
    public class ExtentReportsListener implements IReporter {
        private ExtentReports extent;

        public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                                   String outputDirectory) {
            extent = new ExtentReports(outputDirectory + File.separator + "POM_Extent.html", true);

            for (ISuite suite : suites) {
                Map<String, ISuiteResult> result = suite.getResults();

                for (ISuiteResult r : result.values()) {
                    ITestContext context = r.getTestContext();

                    buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                    buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                    buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                }
            }

            extent.flush();
            extent.close();
        }

        private void buildTestNodes(IResultMap tests, LogStatus status) {
            ExtentTest test;

            if (tests.size() > 0) {
                for (ITestResult result : tests.getAllResults()) {
                    test = extent.startTest(result.getMethod().getMethodName());

                    test.setStartedTime(getTime(result.getStartMillis()));
                    test.setEndedTime(getTime(result.getEndMillis()));

                    for (String group : result.getMethod().getGroups())
                        test.assignCategory(group);

                    if (result.getThrowable() != null) {
                        test.log(status, result.getThrowable());
                    } else {
                        test.log(status, "Test " + status.toString().toLowerCase()
                                + "ed");
                    }

                    extent.endTest(test);
                }
            }
        }

        private Date getTime(long millis) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(millis);
            return calendar.getTime();
        }
    }

     <listeners>
        <listener class-name="com.edu.framework.testdata.ExtentReportsListener"/>
    </listeners>

 public class Parallel {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setupBrowser(String browserName) throws InterruptedException {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            //driver.get("https://www.google.com/");
        } else if (browserName.equals("FireFox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("opera")) {
            System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/drivers/operadriver.exe");
            driver = new OperaDriver();
        }
    }

    @Test
    public void method() {
        driver.get("https://chromedriver.chromium.org/downloads");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

 */

}
