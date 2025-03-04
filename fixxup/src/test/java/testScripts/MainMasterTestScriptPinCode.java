package testScripts;

import Utilities.ActionsClass;
import baseClass.BaseClass;
import configPropertyFile.conFileReader;
import excelDataProvider.ExcelDataProvider_LoginPage;
import org.openqa.selenium.WebElement;
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
public class MainMasterTestScriptCity extends BaseClass {
    //static  WebDriver driver;
List<Integer> ActualUserNames=new ArrayList<>();
List<Integer> ActualPassword = new ArrayList<>();


SoftAssert softAssert=new SoftAssert();
@DataProvider(name = "dataProviderMethod1")
public Object[][] dataProviderMethod()
{
  ExcelDataProvider_LoginPage excelDataProvider=new ExcelDataProvider_LoginPage(driver);
Object[][] data=excelDataProvider.readFromExcel(conFileReader.getFileNameMainMasterCity());

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
    loginFixuup.getCity().click();

}


// This test case is to add city in MainMaster
@Test(description = "This test  case is for Main Master",priority = 2,dataProvider = "dataProviderMethod1", dependsOnMethods = "login")
public  void addCity(String sno,String city) throws InterruptedException {

    PageFactory.initElements(driver, MainMaster.class);
    MainMaster mainMaster=new MainMaster(driver);

    ActionsClass.implicitwaits(driver, Long.valueOf(10));

    mainMaster.getAddCity().click();

    List<WebElement> allDropDownStateOptions= ActionsClass.listOfSelectOptions(mainMaster.getSelectState());
    //for(int i=0;i<)

    for(int i=0;i<allDropDownStateOptions.size();i++)
    {
        String value = allDropDownStateOptions.get(i).getText();
        ActionsClass.selectByVisibleTextFunction(mainMaster.getSelectState(), value);
        mainMaster.getAddCityname().sendKeys(city);
        mainMaster.getCitySubmit().click();
    }




}

}




