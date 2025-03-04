package testScripts;

import Utilities.ActionsClass;
import baseClass.BaseClass;
import com.aventstack.extentreports.Status;
import configPropertyFile.conFileReader;
import excelDataProvider.ExcelDataProvider_LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.AdminPageObjects;
import pageObjects.LoginFixuup;

import java.time.Duration;

@Listeners(Utilities.Listeners.class)
public class Admin extends BaseClass {
    //static  WebDriver driver;
SoftAssert softAssert = new SoftAssert();
static int count=0;



    @DataProvider(name = "dataProviderMethod")
    public Object[][] dataProviderMethod()
    {
        ExcelDataProvider_LoginPage excelDataProvider=new ExcelDataProvider_LoginPage(driver);
        Object[][] data=excelDataProvider.readFromExcel(conFileReader.getFileName());

        return data;

    }


    @Test(description = "Verify the Login  to get specific value")
    public void testcase1()  {
        test = reports.createTest("Login Page");
        test.log(Status.INFO,"URL Launching................................");

        driver.get(conFileReader.getURL2());
        System.out.println("URL Launched " + "Login Credential " + (++count));

        System.out.println(" *********************************************************");
        ExcelDataProvider_LoginPage excelDataProvider=new ExcelDataProvider_LoginPage(driver);
        LoginFixuup loginBasisPay = new LoginFixuup(driver);
        PageFactory.initElements(driver, LoginFixuup.class);
      /*  loginBasisPay.getUserName().sendKeys(excelDataProvider.getSpecificvalues(2,1));
        test.log(Status.INFO,"Admin Entered the username: ");
        loginBasisPay.getPassword().sendKeys(excelDataProvider.getSpecificvalues(2,2));
        test.log(Status.INFO,"Admin entered the password: ");
        loginBasisPay.getSubmit().click();*/
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
        ExcelDataProvider_LoginPage excelDataProvider=new ExcelDataProvider_LoginPage(driver);
        LoginFixuup loginBasisPay = new LoginFixuup(driver);
        PageFactory.initElements(driver, LoginFixuup.class);
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


@Test
    public void loginGeneral()
    {
        LoginFixuup loginBasisPay = new LoginFixuup(driver);
        PageFactory.initElements(driver, LoginFixuup.class);
        driver.get(conFileReader.getURL2());
        loginBasisPay.getUserName().sendKeys(conFileReader.getUserName());
        loginBasisPay.getPassword().sendKeys(conFileReader.getPassword());
        loginBasisPay.getSubmit().click();

    }

    @Test(description = "adding new admin " , dependsOnMethods = "loginGeneral", dataProvider = "dataProviderMethod")
    public void addAdminPage(String value1,String value2,String value3,String value4, String value5, String value6,String value7) throws InterruptedException {
        test= reports.createTest("Adding Admin");
        AdminPageObjects adminPageObjects = new AdminPageObjects(driver);
        PageFactory.initElements(driver, AdminPageObjects.class);
        //user Management---> Add admin
        adminPageObjects.getUserManagement().click();
        test.log(Status.INFO,"User Management Clicked");
        adminPageObjects.getAdmin().click();
        test.log(Status.INFO,"Admin Selected");

        adminPageObjects.getAddAdmin().click();
        test.log(Status.INFO,"Add Admin Clicked:");
        adminPageObjects.getUserName().sendKeys(value1);

        test.log(Status.INFO," Entering the username");
        adminPageObjects.getPassword().sendKeys(value2);
        //get roll-->
        test.log(Status.INFO,"");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        adminPageObjects.getRoll().click();
        //getting roles from excel
        /*if(String.valueOf(value3).equalsIgnoreCase("maker"))
        {
            ActionsClass.selectByindexFunction(driver, adminPageObjects.roll, 1);
        }

        if(String.valueOf(value3).equalsIgnoreCase("checker"))
        {
            ActionsClass.selectByindexFunction(driver, adminPageObjects.roll, 2);
        }

        if(String.valueOf(value3).equalsIgnoreCase("approver"))
        {
            ActionsClass.selectByindexFunction(driver, adminPageObjects.roll, 3);
        }


        if(String.valueOf(value3).equalsIgnoreCase("pgsubmit"))
        {
            ActionsClass.selectByindexFunction(driver, adminPageObjects.roll, 4);
        }

        if(String.valueOf(value3).equalsIgnoreCase("admin"))
        {
            ActionsClass.selectByindexFunction(driver, adminPageObjects.roll, 5);
        }
        adminPageObjects.getEmail().sendKeys(String.valueOf(value4));

        adminPageObjects.getContactNumber().sendKeys(String.valueOf(value5));

        adminPageObjects.getAddress().sendKeys(String.valueOf(value6));

        adminPageObjects.getPinCode().sendKeys(String.valueOf(value7));
        adminPageObjects.getSubmit().click();

        Thread.sleep(2000);
        if (adminPageObjects.getToastMessage().isDisplayed()) {
            if (adminPageObjects.getToastMessage().getText().contains("already")) {
                adminPageObjects.getCancel().click();
            } else {
                driver.navigate().refresh();
            }


        }*/
    }

}



