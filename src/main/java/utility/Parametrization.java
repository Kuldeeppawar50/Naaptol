package utility;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Parametrization {

    public static String parameter1(String Sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException, FileNotFoundException {
        FileInputStream file=new FileInputStream("E:\\Data.xlsx");
        String value= WorkbookFactory.create(file).getSheet(Sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
        return value;
    }

}
