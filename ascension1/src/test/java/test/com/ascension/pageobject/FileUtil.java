/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com.ascension.pageobject;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author halleluyamengesha
 */
public class FileUtil {
    
    public static Input getData() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("/Users/halleluyamengesha/Desktop/School/Java Programming/Java Selenium Project/Input - Project.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);
        //getting first worksheet
        Sheet firstSheet = workbook.getSheetAt(0);
        //get first row
        Row r = firstSheet.getRow(0); //first row
        Cell c = r.getCell(1); //zipcode value
        int zipCode = (int) c.getNumericCellValue();

        Input input = new Input(zipCode);

        System.out.println(input);
        inputStream.close();

        return input;

    }
}
