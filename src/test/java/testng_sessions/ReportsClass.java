package testng_sessions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsClass {
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static void createReport() {
		reports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/report.html");
		reports.attachReporter(sparkReporter);
	}
	
	public static void createTest(String name) {
		test = reports.createTest(name);
	}
	
	public static void endReport() {
		reports.flush();
	}
}
