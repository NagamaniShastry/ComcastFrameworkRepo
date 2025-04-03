package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutlility.UtilityClassObject;


public class ListenerImpClass implements ITestListener,ISuiteListener
{
	//public ExtentSparkReporter spark;
	public  ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) 
	{
		// TODO Auto-generated method stub
		//ISuiteListener.super.onStart(suite);
		System.out.println("Report Configuration");
		//Spark report config
		
		String time =  new Date().toString().replace(" ","_").replace(":","_");
		
		 
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);						
		//add env information and create test	
					
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER", "chrome");
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		//ISuiteListener.super.onFinish(suite);
		System.out.println("Report Backup");
		report.flush();   // to save the file
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		System.out.println("=====>"+result.getMethod().getMethodName()+"==START===");
	    test = report.createTest(result.getMethod().getMethodName());
	    UtilityClassObject.setTest(test);
	    test.log(Status.INFO,result.getMethod().getMethodName()+"===Started===");

	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{  
		//ITestListener.super.onTestSuccess(result);
		System.out.println("=====>"+result.getMethod().getMethodName()+"=====");
	 
		test.log(Status.PASS,result.getMethod().getMethodName()+"==COMPLETED===");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//ITestListener.super.onTestFailure(result);
		String testName = result.getMethod().getMethodName();
	//	TakesScreenshot ts =  (TakesScreenshot)BaseClass.sdriver;
     	TakesScreenshot ts =  (TakesScreenshot)UtilityClassObject.getDriver();	
		String  filepath = ts.getScreenshotAs(OutputType.BASE64); 
		
		String time =  new Date().toString().replace(" ","_").replace(":","_");
		test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"==FAILED===");

		
	/*	String time =  new Date().toString().replace(" ","_").replace(":","_");
		
	    File src = ts.getScreenshotAs(OutputType.FILE);	    
	    File dest = new File("./ScreenShot/"+testName+" "+time+".png");	    
	    try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	   
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		//test.log(Status.SKIP,result.getMethod().getMethodName()+"==SKIPPED===");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	


}
