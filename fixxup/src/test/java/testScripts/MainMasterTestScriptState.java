package testScripts;

import Utilities.ActionsClass;
import baseClass.BaseClass;
import configPropertyFile.conFileReader;
import excelDataProvider.ExcelDataProvider_LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginFixuup;
import pageObjects.MainMaster;

import java.util.ArrayList;
import java.util.List;

@Listeners(Utilities.Listeners.class)
public class MainMasterTestScript extends BaseClass {
    //static  WebDriver driver;
List<Integer> ActualUserNames=new ArrayList<>();
List<Integer> ActualPassword = new ArrayList<>();


SoftAssert softAssert=new SoftAssert();
@DataProvider(name = "dataProviderMethod1")
public Object[][] dataProviderMethod()
{
  ExcelDataProvider_LoginPage excelDataProvider=new ExcelDataProvider_LoginPage(driver);
Object[][] data=excelDataProvider.readFromExcel();

for(int i=0;i< data.length;i++)
{
    for(int j=0;j<data[0].length;j++)
    {
        System.out.println(data[i][j]);
    }

}
  //  Object[][] data={{"ff","dd"},{"ee","dd"}};

return data;

}




@Test(description = "login with common credential")
public void login()
{
    driver.get(conFileReader.getURL1());
    PageFactory.initElements(driver, LoginFixuup.class);


    LoginFixuup loginFixuup = new LoginFixuup(driver);
    loginFixuup.getUserName().sendKeys(conFileReader.getUserName());
    loginFixuup.getPassword().sendKeys(conFileReader.getPassword());
    loginFixuup.getSubmit().click();
    ActionsClass.implicitwaits(driver, 3L);

    ActionsClass.mousehoverFunction(driver,loginFixuup.getMainMaster());
    loginFixuup.getState().click();

}


// This test case is to add manager
@Test(description = "This test  case is for user manager",priority = 2,dataProvider = "dataProviderMethod1", dependsOnMethods = "login")
public  void addManager(String sno,String state) throws InterruptedException {

    PageFactory.initElements(driver, MainMaster.class);
    MainMaster mainMaster=new MainMaster(driver);

    ActionsClass.implicitwaits(driver, Long.valueOf(10));

    Thread.sleep(1000);
    ActionsClass.implicitwaits(driver, Long.valueOf(10));

    Thread.sleep(1000);
    ActionsClass.implicitwaits(driver, Long.valueOf(10));

    mainMaster.getAddState().click();
    Thread.sleep(1000);
    System.out.println(state);
    System.out.println("******************************************************");
    mainMaster.getAddNewState().sendKeys(state);
    Thread.sleep(1000);
    mainMaster.addStateSubmitOption().click();
    Thread.sleep(1000);




}

}




