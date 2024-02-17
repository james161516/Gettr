package Rahulshettyacademy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports getReportObject()
	{
		ExtentReports extent;
		String path = System.getProperty("user.dir") +"\\Reports\\index.HTML";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
	extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Manoj");
		return extent;
	}

}
