package com.edu.framework.util;

import com.aventstack.extentreports.Status;
import com.edu.framework.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

public class TestListeners extends BaseClass implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //Do tier down operations for ExtentReports reporting!
        ExtentReportConfig.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        //ExtentReports log operation for passed tests.
        ExtentReportConfig.getTest().log(Status.PASS, "Test passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        //Get driver from BaseTest and assign to local webdriver variable.
        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        //ExtentReports log and screenshot operations for failed tests.
        ExtentReportConfig.getTest().log(Status.FAIL, "Test Failed",
                ExtentReportConfig.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
        ExtentReportConfig.getTest().log(Status.INFO, iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        //ExtentReports log operation for skipped tests.
        ExtentReportConfig.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
}