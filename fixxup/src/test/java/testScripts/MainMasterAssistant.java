package testScripts;

import Utilities.ActionsClass;
import baseClass.BaseClass;
import configPropertyFile.conFileReader;
import excelDataProvider.ExcelDataProvider_LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginFixuup;
import pageObjects.MainMaster;

@Listeners(Utilities.Listeners.class)
public class MainMasterDailyHelper extends BaseClass {

    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "dataProviderMethod1")
    public Object[][] dataProviderMethod() {
        ExcelDataProvider_LoginPage excelDataProvider = new ExcelDataProvider_LoginPage(driver);
        Object[][] data = excelDataProvider.readFromExcel(conFileReader.getFileNameMainMasterDailyHelp());

        for (int i = 0; i < data.length; i++)
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
        loginFixuup.getDailyHelper().click();
        PageFactory.initElements(driver, MainMaster.class);

        ActionsClass.implicitwaits(driver, Long.valueOf(10));


        js.executeScript("window.scrollBy(0,250)");


    }


    // This test case is to add DailyHelper in MainMaster
    @Test(description = "This test  case is for adding role in Main Master",priority = 2,dataProvider = "dataProviderMethod1", dependsOnMethods = "login")
    public  void addDailyHelper(String snp, String category) throws InterruptedException {
        PageFactory.initElements(driver, MainMaster.class);
        MainMaster mainMaster=new MainMaster(driver);


        mainMaster.getAddDialyHelper().click();
        mainMaster.getCategoryDailyHelper().sendKeys(category);
        mainMaster.getSubmitDailyHelper().click();



        Thread.sleep(2000);




        driver.navigate().refresh();
    }


}



