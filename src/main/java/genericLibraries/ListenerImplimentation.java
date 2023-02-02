package genericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener{

	public ExtentReports report;
	public ExtentTest test;
	public static ExtentTest stest;
	
	@Override
	public void onTestStart(ITestResult result) {
           test = report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName());
		test.addScreenCaptureFromBase64String(new WebDriverUtility().getScreenshot());
	//	test.addScreenCaptureFromPath(new WebDriverUtility().getScreenshot(result.getMethod().getMethodName(),new JavaUtility()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName());
		test.fail(result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/extent.html");
		spark.config().setDocumentTitle("Framework");
		spark.config().setReportName("Vtiger CRM");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author","S.MD.Nasurudeen");
		report.setSystemInfo("platform", "Windows");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}