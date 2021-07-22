package com.edu.framework.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportConfig {

    private static ExtentReports extentReports = new ExtentReports();
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

    static {
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("OS Version", System.getProperty("os.version"));
    }

    public synchronized static ExtentReports getExtentReports() {

        ExtentSparkReporter reporter = new ExtentSparkReporter("./test-output/ExtentReports/extent-report.html");
        reporter.config().setReportName("Automation Framework ");
        extentReports.attachReporter(reporter);
        return extentReports;
    }


    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getExtentReports().createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

}
