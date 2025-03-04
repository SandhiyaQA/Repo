package baseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import configPropertyFile.conFileReader;
import extentReport.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
public class BaseClass extends ExtentReport
{
    protected static ExtentSparkReporter sparkReporter;
    protected  static ExtentReports reports;
    protected static ExtentTest test;
    protected static WebDriver driver;
    @BeforeClass
    public void extentReporting()
    {
        sparkReporter=new ExtentSparkReporter("Reports");
        reports = new ExtentReports();
        sparkReporter.config().setDocumentTitle("Fixxup");
        sparkReporter.config().setReportName("FixxUP TEST");
        sparkReporter.config().setTheme(Theme.DARK);
        reports.setSystemInfo("Fixxup","version1");
        reports.attachReporter(sparkReporter);


    }



    @BeforeTest
    public void initialization() throws IOException {


       String browser = conFileReader.getBrowser();
       if(browser.equalsIgnoreCase("chrome")) {
           ChromeOptions options = new ChromeOptions();
           options.addArguments("start--maximized");
           driver = new ChromeDriver(options);
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       }

       else
           if(browser.equalsIgnoreCase("firefox"))
           {
               FirefoxOptions firefoxOptions = new FirefoxOptions();
               firefoxOptions.addArguments("start--maximized");
               driver = new FirefoxDriver(firefoxOptions);
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           }

    }


    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    @AfterClass
    public void teardown()
    {
        reports.flush();
    }

}
