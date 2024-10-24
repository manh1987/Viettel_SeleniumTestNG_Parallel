package com.anhtester.listeners;

import com.anhtester.helpers.CaptureHelper;
import com.anhtester.helpers.PropertiesHelper;
import com.anhtester.reports.ExtentReportManager;
import com.anhtester.reports.ExtentTestManager;
import com.anhtester.utils.LogUtils;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        // TODO Auto-generated method stub
        LogUtils.info("onStart: "+ result.getName());
        PropertiesHelper.loadAllFiles();
        CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onFinish(ITestContext result) {
        // TODO Auto-generated method stub
        LogUtils.info("onFinish: "+ result.getName());
        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("onTestStart: "+ result.getName());
        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.info("onTestSuccess: "+ result.getName());
        CaptureHelper.takeScreenshot(result.getName());
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.error("onTestFailure: " + result.getName());
        CaptureHelper.takeScreenshot(result.getName());
        //Làm gì đó khi testcase fail
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.addScreenshot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        LogUtils.warn("onTestSkipped: "+ result.getName());
        CaptureHelper.takeScreenshot(result.getName());
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }
}
