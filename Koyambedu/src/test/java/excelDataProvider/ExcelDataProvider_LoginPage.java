package excelDataProvider;

import configPropertyFile.conFileReader;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProvider_LoginPage {
    WebDriver driver;

    public ExcelDataProvider_LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    String value;
    FileInputStream fileInputStream;
    XSSFWorkbook workbook;
    public Object[][] readFromExcel(String FileName) {

    {
        try {
            fileInputStream = new FileInputStream(FileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    {
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    XSSFSheet sheet = workbook.getSheetAt(conFileReader.getSheetnumber());
    XSSFRow row = sheet.getRow(1);

    //To get number of rows
    int noOfRows = sheet.getLastRowNum();

    //To get number of columns
    int noOfColumns = sheet.getRow(1).getLastCellNum();


        Object[][] data = new Object[noOfRows][noOfColumns];
        for (int i = 1; i <= noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                System.out.println(sheet.getRow(i).getCell(j).toString());

                System.out.println("No of Rows"+noOfRows+ "No of columns"+noOfColumns);

                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();


            }
            System.out.println("********************");


        }
        return data;
    }




}







