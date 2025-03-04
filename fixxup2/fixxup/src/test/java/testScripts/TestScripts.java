package testScripts;

import Utilities.ActionsClass;
import Utilities.logger;
import baseClass.BaseClass;
import com.aventstack.extentreports.Status;
import configPropertyFile.conFileReader;
import excelDataProvider.ExcelDataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginPageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Listeners(Utilities.Listeners.class)
public class TestScripts extends BaseClass {
    //static  WebDriver driver;
List<Integer> ActualUserNames=new ArrayList<>();
List<Integer> ActualPassword = new ArrayList<>();


SoftAssert softAssert=new SoftAssert();
@DataProvider(name = "dataProviderMethod")
public Object[][] dataProviderMethod()
{
  ExcelDataProvider excelDataProvider=new ExcelDataProvider();
Object[][] data=excelDataProvider.readFromExcel();

for(int i=0;i< data.length;i++)
{
    for(int j=0;j<data[0].length;j++)
    {
        System.out.println(data[i][j]);
    }

}/*
    Object[][] data={{"ff","dd"},{"ee","dd"}};
*/

return data;

}


    @Test(description = "Verify the Login Functionality")
    public void testcase1() throws IOException, InterruptedException {
        ExcelDataProvider excelDataProvider= new ExcelDataProvider();
        System.out.println("Verifying the login fuctionality");
        System.out.println(ActualUserNames.addAll(excelDataProvider.gettingUsernamesFromExcel()));
        System.out.println(ActualPassword.addAll(excelDataProvider.gettingPasswordfromExcel()));
        System.out.println(ActualUserNames.size());
        System.out.println(ActualPassword.size());
        System.out.println(ActualUserNames);
        System.out.println(ActualPassword);
        //System.out.println(ActualUserNames.get(0));



        ActionsClass.implicitwaits(driver, conFileReader.getSeconds());
        PageFactory.initElements(driver, LoginPageObjects.class);
        LoginPageObjects loginPageObjects=new LoginPageObjects(driver);


            driver.get(conFileReader.getURL1());



           for(int j=0;j<ActualUserNames.size();j++)
            {
                for(int k=0;k<ActualPassword.size(); k++){
                    if(j==k){
                    loginPageObjects.getUserName().sendKeys(String.valueOf(ActualUserNames.get(j)));
                    loginPageObjects.getPassword().sendKeys(String.valueOf(ActualPassword.get(k)));
                    loginPageObjects.getSubmit();
                     driver.navigate().refresh();

                }}
            }
    }
@Test(priority = 0, description = "Login validation with multiple values", enabled = false)
    public void testcase2()
{
    driver.get(conFileReader.getURL1());
    ActionsClass.implicitwaits(driver, conFileReader.getSeconds());
}


@Test(dataProvider = "dataProviderMethod")
    public void validationWithDataProvider(Object username,Object password)
{
int count=0;
test = reports.createTest("Login Page");
test.log(Status.INFO,"URL Launching................................");


    PageFactory.initElements(driver, LoginPageObjects.class);
    LoginPageObjects loginPageObjects=new LoginPageObjects(driver);


    driver.get(conFileReader.getURL1());
    softAssert.assertEquals(conFileReader.getURL1(),driver.getCurrentUrl(),"The URL is wrong");
    test.log(Status.PASS,"URL Launched successfully");

    //logger Objects
    logger logger=new logger();
    logger.infoLog("URL launched Successfully");
    loginPageObjects.getUserName().sendKeys(username.toString());
    logger.infoLog("Entered the username");
    test.log(Status.PASS,"Login credential ");
    loginPageObjects.getPassword().sendKeys(password.toString());
    logger.infoLog("Entered the password ");
    loginPageObjects.getSubmit();

    logger.infoLog("Clicked submit button");

    softAssert.assertEquals(conFileReader.getURL2(),driver.getCurrentUrl(),"redirected to some other page");
    test.log(Status.PASS,"Logged in Successfully!!!!!");


}

}
