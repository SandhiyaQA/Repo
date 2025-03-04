package baseClass;

import configPropertyFile.conFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
public class BaseClass
{

    protected static WebDriver driver;
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
}
