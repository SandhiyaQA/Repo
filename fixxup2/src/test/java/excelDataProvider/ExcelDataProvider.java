package excelDataProvider;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataProvider {

     List<String> ListofuserNames = new ArrayList<>();
     List<String> ListofPassword = new ArrayList<>();



    FileInputStream  fileInputStream;

    {
        try {
            fileInputStream = new FileInputStream("src/test/resources/dataProvider/Fixxup.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

     XSSFWorkbook  workbook;

    {
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    XSSFSheet    sheet = workbook.getSheetAt(0);
    XSSFRow    row = sheet.getRow(1);

        //To get number of rows
         int noOfRows = sheet.getLastRowNum();

        //To get number of columns
         int noOfColumns = sheet.getRow(1).getLastCellNum();
//Method1
        public   List<String> gettingUsernamesFromExcel()
         {
            //Storing the excel rows and cells values to the ArrayList
            //List of username
            for (int i = 1; i <= noOfRows; i++) {
                for (int j = 0; j < noOfColumns; j++) {//        System.out.println(sheet.getRow(i).getCell(j));

                    ListofuserNames.add(String.valueOf(sheet.getRow(i).getCell(j)));
                    j++;

                }
            }

            return ListofuserNames;
        }


        public  List<String> gettingPasswordfromExcel() {
//List of password

            for (int i = 1; i <= noOfRows; i++) {
                for (int j = 1; j < noOfColumns; j++) {

                    ListofPassword.add(String.valueOf(sheet.getRow(i).getCell(j)));


                }
            }

            return ListofPassword;
                 }



    }





