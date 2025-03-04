package testScripts;

import Utilities.ActionsClass;
import baseClass.BaseClass;
import configPropertyFile.conFileReader;
import excelDataProvider.ExcelDataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestScripts extends BaseClass {
    //static  WebDriver driver;
List<String> ActualUserNames=new ArrayList<>();
List<String> ActualPassword = new ArrayList<>();

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
        System.out.println(ActualUserNames.get(0));



        ActionsClass.implicitwaits(driver, conFileReader.getSeconds());
        PageFactory.initElements(driver, LoginPageObjects.class);
        LoginPageObjects loginPageObjects=new LoginPageObjects(driver);


            driver.get(conFileReader.getURL());



           for(int j=0;j<ActualUserNames.size();j++)
            {
                for(int k=0;k<ActualPassword.size(); k++){
                    if(j==k){
                    loginPageObjects.getUserName().sendKeys(ActualUserNames.get(j));
                    loginPageObjects.getPassword().sendKeys(ActualPassword.get(k));
                    loginPageObjects.getSubmit();
                     driver.navigate().refresh();

                }}
            }
    }
@Test(priority = 0, description = "Login validation with multiple values", enabled = false)
    public void testcase2()
{
    driver.get(conFileReader.getURL());
    ActionsClass.implicitwaits(driver, conFileReader.getSeconds());
}

}
