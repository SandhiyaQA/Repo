package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ExtentReport {
ExtentSparkReporter sparkReporter;
    ExtentReports reports;
    ExtentTest test;
@BeforeClass
    public void extentReporting()
    {

         reports.attachReporter(sparkReporter);
         sparkReporter.config().setDocumentTitle("Fixxup");
         sparkReporter.config().setReportName("FixxUP TEST");
         sparkReporter.config().setTheme(Theme.DARK);
         reports.setSystemInfo("Fixxup","version1");


    }

    @AfterClass
    public void teardown()
    {
    reports.flush();
    }

}
