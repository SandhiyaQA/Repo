package testScripts;

import Utilities.ActionsClass;
import baseClass.BaseClass;
import configPropertyFile.conFileReader;
import excelDataProvider.ExcelDataProvider_LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginFixuup;
import pageObjects.MainMaster;

import java.util.List;

@Listeners(Utilities.Listeners.class)
public class MainMasterTestScriptPinCode extends BaseClass {



SoftAssert softAssert=new SoftAssert();
@DataProvider(name = "dataProviderMethod1")
public Object[][] dataProviderMethod()
{
  ExcelDataProvider_LoginPage excelDataProvider=new ExcelDataProvider_LoginPage(driver);
Object[][] data=excelDataProvider.readFromExcel(conFileReader.getFileNameMainMasterPincode());

for(int i=0;i< data.length;i++)
{
    for(int j=0;j<data[0].length;j++)
    {
        System.out.println(data[i][j]);
    }

}


return data;

}




@Test(description = "login with common credential")
public void login() throws InterruptedException {
    driver.get(conFileReader.getURL1());
    PageFactory.initElements(driver, LoginFixuup.class);


    LoginFixuup loginFixuup = new LoginFixuup(driver);
    loginFixuup.getUserName().sendKeys(conFileReader.getUserName());
    loginFixuup.getPassword().sendKeys(conFileReader.getPassword());
    loginFixuup.getSubmit().click();
    ActionsClass.implicitwaits(driver, 3L);

    JavascriptExecutor js=(JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000)","");
    Thread.sleep(1000);
    ActionsClass.mousehoverFunction(driver,loginFixuup.getMainMaster());
    loginFixuup.getPincode().click();
    PageFactory.initElements(driver, MainMaster.class);
    MainMaster mainMaster=new MainMaster(driver);

    ActionsClass.implicitwaits(driver, Long.valueOf(10));


    js.executeScript("window.scrollBy(0,250)");
    driver.navigate().refresh();

}


// This test case is to add pincode in MainMaster
@Test(description = "This test  case is for Main Master",priority = 2,dataProvider = "dataProviderMethod1", dependsOnMethods = "login")
public  void addPinCode(String sno,String pincode) throws InterruptedException {
    PageFactory.initElements(driver, MainMaster.class);
    MainMaster mainMaster=new MainMaster(driver);
    mainMaster.getAddPinCode().click();


    List<WebElement> allDropDownStateOptions= ActionsClass.listOfSelectOptions(mainMaster.getSelectPincodeState());




        String value = allDropDownStateOptions.get(0).getText();
        ActionsClass.selectByVisibleTextFunction(mainMaster.getSelectPincodeState(), value);

        Thread.sleep(2000);

        List<WebElement> allDropdownCityOptions = ActionsClass.listOfSelectOptions(mainMaster.getSelectPincodeCity());
        for(int i=0;i<allDropdownCityOptions.size();i++)
        {
            System.out.println(allDropdownCityOptions.get(i).getText());
        }
            String cityValue = allDropdownCityOptions.get(0).getText();
            ActionsClass.selectByindexFunction(mainMaster.getSelectPincodeCity(),0);
            mainMaster.getEnterPincode().sendKeys(pincode);
            mainMaster.getSubmitPincode().click();
        }


}




