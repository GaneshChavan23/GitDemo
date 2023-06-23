package com.Utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	ExtentSparkReporter htmlreport;
	ExtentReports report;
	ExtentTest test;

	public void Configuration() {
		//ReadConfig c=new ReadConfig();
		String path = System.getProperty("user.dir") + "//ExtentReport//" + "Report.html";
		htmlreport = new ExtentSparkReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlreport);

		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Name", "Ganesh");
		report.setSystemInfo("TestType", "Sanity");

		htmlreport.config().setDocumentTitle("Sanity Report");
		htmlreport.config().setReportName("Extent Report");
		htmlreport.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext context) {
		Configuration();
		System.out.println("OnStart.....");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Execution Start....." + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Successfully passed....." + result.getName());
		test=report.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Test Case Pass" + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
		System.out.println("Test Case Successfully Failed....." + result.getName());
		test=report.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Case Fail" + result.getName(), ExtentColor.RED));
		
		String Screenshotpath=System.getProperty("user.dir") + "//Screenshot//" + result.getName() + ".png";
		File ScreenshotFile=new File(Screenshotpath);
		if(ScreenshotFile.exists()) {
			test.fail("Capture Scrrenshot" + test.addScreenCaptureFromPath(Screenshotpath));
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped....." + result.getName());
		test=report.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Test Case Skip" + result.getName(), ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

}
