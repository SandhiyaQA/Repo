package testScripts;

import Utilities.ActionsClass;
import baseClass.BaseClass;
import com.aventstack.extentreports.Status;
import configPropertyFile.conFileReader;
import excelDataProvider.ExcelDataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginBasisPay;

@Listeners(Utilities.Listeners.class)
public class LoginPage extends BaseClass {
    //static  WebDriver driver;
SoftAssert softAssert = new SoftAssert();
static int count=0;



    @DataProvider(name = "dataProviderMethod")
    public Object[][] dataProviderMethod()
    {
        ExcelDataProvider excelDataProvider=new ExcelDataProvider(driver);
        Object[][] data=excelDataProvider.readFromExcel();

        return data;

    }


    @Test(description = "Verify the Login  to get specific value")
    public void testcase1()  {
        test = reports.createTest("Login Page");
        test.log(Status.INFO,"URL Launching................................");

        driver.get(conFileReader.getURL2());
        System.out.println("URL Launched " + "Login Credential " + (++count));

        System.out.println(" *********************************************************");
        ExcelDataProvider excelDataProvider=new ExcelDataProvider(driver);
        LoginBasisPay loginBasisPay = new LoginBasisPay(driver);
        PageFactory.initElements(driver, LoginBasisPay.class);
        loginBasisPay.getUserName().sendKeys(excelDataProvider.getSpecificvalues(2,1));
        test.log(Status.INFO,"Admin Entered the username: ");
        loginBasisPay.getPassword().sendKeys(excelDataProvider.getSpecificvalues(2,2));
        test.log(Status.INFO,"Admin entered the password: ");
        loginBasisPay.getSubmit().click();
        test.log(Status.PASS,"Login Successfull");

        String loginTextMessage = loginBasisPay.getStringFunction();
        if(loginTextMessage.contains("Block"))

        {
            System.out.println("User Account Blocked");
            test.log(Status.PASS, "Login Blocked");
        }
        else
        System.out.println("User Logged in Successfully");
        test.log(Status.PASS, " User Logged in Successfully");



                }




    @Test(dataProvider = "dataProviderMethod")
    public void testcase2(Object username, Object password)  {
        test = reports.createTest("Login Page");
        test.log(Status.INFO,"URL Launching................................");

        driver.get(conFileReader.getURL2());
        ActionsClass.implicitwaits(driver, Long.valueOf(5));
        System.out.println("URL Launched Successfully" + "Login Credential " + (++count));
        System.out.println(" *********************************************************");
        ExcelDataProvider excelDataProvider=new ExcelDataProvider(driver);
        LoginBasisPay loginBasisPay = new LoginBasisPay(driver);
        PageFactory.initElements(driver, LoginBasisPay.class);
        loginBasisPay.getUserName().sendKeys(username.toString());
        test.log(Status.INFO,"Admin Entered the username: ");
        loginBasisPay.getPassword().sendKeys(password.toString());
        test.log(Status.INFO,"Admin entered the password: ");
        loginBasisPay.getSubmit().click();
        softAssert.assertEquals(driver.getCurrentUrl(),"http://157.245.105.135:8084/dashboard"," not reached dashboard");
        test.log(Status.PASS,"Login Successfull" + (++count));
        driver.navigate().refresh();
        String loginTextMessage = loginBasisPay.getStringFunction();
        if(loginTextMessage.contains("Block"))
        {
            System.out.println("User Account Blocked");
            test.log(Status.PASS, "Login Blocked");
        }
        else
            System.out.println("User Logged in Successfully");
            test.log(Status.PASS, " User Logged in Successfully");

    }




}



