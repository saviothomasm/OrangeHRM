package BaseClass;

import java.io.IOException;
//import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.Buzz_TestCase;

public class ExtendReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;


    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); //specify location of the report

        sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report"); //Title of report
        sparkReporter.config().setReportName("OrangeHRM Functional Testing"); //name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

    }

    public void onTestSuccess(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.log(Status.PASS, "Test Passed");

    }

    public void onTestFailure(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
/*
        try
        {
            String imgPath= new Buzz_TestCase().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }

 */
    }

    public void onTestSkipped(ITestResult result)
    {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();

        //send report via mail
/*
	try { URL url = new
	URL("file://"+System.getProperty("user.dir")+"\\reports\\"+repName);

	//create the email message

	ImageHtmlEmail email = new ImageHtmlEmail();
	email.setDataSourceResolver(new DataSourceUrlResolver(url));
	email.setHostName("smtp.googlemail.com");
	email.setSmptPort(465);
	email.setAuthenticator(new DefaultAuthenticator("savio196@gmail.com"),"password"));
	email.setSSLOnConnect(true);
	email.SetFrom("savio196@gmail.com");
	email.setSubject("Test Results");
	email.setMsg("Please find Attached Report....");
	email.addTo("mt5aviogmail.com"); //receiver
	email.attach(url, "extent report", "please check report...");
	email.send();
	}
	catch(Exception e)
	{
		e.printStackTrace();

	*/

    }



}
