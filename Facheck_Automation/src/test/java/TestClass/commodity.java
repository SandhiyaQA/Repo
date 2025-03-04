package TestClass;

import BaseClass.BaseClass;
import PageObjectsClass.Shop_Update;
import PageObjectsClass.loginPageObject;
import actionclass.actionClass;
import configFileReader.configFileRead;
import excelDataProvider.ExcelDataProvider_LoginPage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

@Listeners(Utilities.Listeners.class)
public class Shop_Update_Create extends BaseClass {
    actionClass act = new actionClass();
    FileInputStream fileInputStream;
    XSSFWorkbook workbook;
    static ExcelDataProvider_LoginPage excel = new ExcelDataProvider_LoginPage(driver);

    public static List<String> select_Category;



 /*   public void dataProviderMethod1() {
        ExcelDataProvider_LoginPage excelDataProvider = new ExcelDataProvider_LoginPage(driver);
        List<String> data = excelDataProvider.readFromExcel();

       Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
       Iterator<Row> rowIterator = sheet.iterator();

       // Skip header row
       rowIterator.next();

       // Loop through each row and fill the form
       while (rowIterator.hasNext()) {
           Row row = rowIterator.next();
           Shop_Update.getSelectCategory().sendKeys(row.getCell(0).getStringCellValue());
           Shop_Update.getTrader().sendKeys();
           Shop_Update.getShopNo().sendKeys(row.getCell(0).getStringCellValue());

           driver.findElement(By.name("field_2")).sendKeys(row.getCell(1).getStringCellValue());
           driver.findElement(By.name("field_3")).sendKeys(row.getCell(2).getStringCellValue());
        }
    }*/

public static void se()
{
    select_Category= excel.readFromExcel();
    for (String category : select_Category) {
        System.out.println(category);
    }


}
    @Test(priority =1)
    public void loginPage() {
        loginPageObject loginPageObject = PageFactory.initElements(driver, loginPageObject.class);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        act.sendKeys(loginPageObject.getEmail(), configFileRead.getUserName());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        act.sendKeys(loginPageObject.getPassword(), configFileRead.getPassword());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        act.click(loginPageObject.getSubmit());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        System.out.println("Hello URL Launched");

    }
    @Test(priority = 2,groups = {"A"},dependsOnMethods = {"loginPage"})
    public void shopUpdate_Create() throws InterruptedException, AWTException {

/*
        test = reports.createTest("Login Page");
        test.log(Status.INFO,"URL Launching...");
*/
     /*
    --   ExcelDataProvider_LoginPage excelDataProvider = new ExcelDataProvider_LoginPage(driver);
    --   List<String> data = excelDataProvider.readFromExcel();
    */
        PageFactory.initElements(driver,Shop_Update.class);
        driver.navigate().refresh();
        Thread.sleep(2000);
        act.click(Shop_Update.getTrader());
        act.click(Shop_Update.getShopUpdate());
        Thread.sleep(3000);
        act.click(Shop_Update.getCreate());
        act.click(Shop_Update.getSelectCategory());
        try {
            fileInputStream = new FileInputStream(configFileRead.getShopUpdateFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
        Iterator<Row> rowIterator = sheet.iterator();

        // Skip header row
        rowIterator.next();

        // Loop through each row and fill the form
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            act.selectByVisibleText(Shop_Update.getSelectCategory(), String.valueOf(row.getCell(0)));
            System.out.println(row.getCell(1));
            act.selectByVisibleText(Shop_Update.getShopNo(),String.valueOf(row.getCell(1)));
            act.selectByVisibleText(Shop_Update.getBusinessMode(),String.valueOf(row.getCell(2)));
            act.selectByVisibleText(Shop_Update.getOwnerShipType(),String.valueOf(row.getCell(3)));
            act.sendKeys(Shop_Update.getUploadLicenseCertificate(),String.valueOf(row.getCell(4)));
            act.sendKeys(Shop_Update.getRegistrationNumber(),String.valueOf(row.getCell(5)));
            act.sendKeys(Shop_Update.getRegDate(),String.valueOf(row.getCell(6)));
            act.sendKeys(Shop_Update.getFileNo(),String.valueOf(row.getCell(7)));
            act.sendKeys(Shop_Update.getAllotmentNo(),String.valueOf(row.getCell(8)));
            act.sendKeys(Shop_Update.getLicenseHolderName(),String.valueOf(row.getCell(9)));
            act.sendKeys(Shop_Update.getLicenseNum(),String.valueOf(row.getCell(10)));
            act.sendKeys(Shop_Update.getLicenseHolderAddress(),String.valueOf(row.getCell(11)));
            act.sendKeys(Shop_Update.getCity(),String.valueOf(row.getCell(12)));
            act.sendKeys(Shop_Update.getPincode(),String.valueOf((row.getCell(13))));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");
            act.sendKeys(Shop_Update.getRegistrationCertificate(),String.valueOf(row.getCell(14)));
             act.selectByVisibleText(Shop_Update.getPrimary(),String.valueOf(row.getCell(15)));
            act.sendKeys(Shop_Update.getAlloteeName(),String.valueOf(row.getCell(16)));
            act.sendKeys(Shop_Update.getGender(),String.valueOf(row.getCell(17)));
            act.selectByVisibleText(Shop_Update.getRelationName(),String.valueOf(row.getCell(18)));
            act.sendKeys(Shop_Update.getMobileNumber(),String.valueOf(row.getCell(19)));
            act.sendKeys(Shop_Update.getEmailAddress(),String.valueOf(row.getCell(20)));
            act.sendKeys(Shop_Update.getUploadPhoto(),String.valueOf(row.getCell(21)));
            act.selectByVisibleText(Shop_Update.getidProof(),String.valueOf((row.getCell(22))));
            act.sendKeys(Shop_Update.getIdProofDocument(),String.valueOf((row.getCell(23))));
            act.selectByVisibleText(Shop_Update.getActiveStatus(),String.valueOf(row.getCell(24)));
            //act.selectByValue(Shop_Update.getMaintainancePending()





        }

        //------------
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        PageFactory.initElements(driver,PageObjectsClass.Shop_Update.class);
        Thread.sleep(3000);

      //  act.selectByValue(Shop_Update.getSelectCategory());
        act.click(Shop_Update.getShopNo());
       // act.selectByValue(Shop_Update.getShopNo());


    }



}
