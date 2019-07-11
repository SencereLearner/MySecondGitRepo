import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelSheetsFunctions {

  XSSFWorkbook wb;
  XSSFSheet sheet1;
  //In order to use this class from our main section (@Test or main method), we need to:
  // 1) Create an instance of this class first, thus invoking ExcelSheetsFunctions method, thus setting up Excel and specify Excel path 2) And then to call readExcelData method.
  public ExcelSheetsFunctions(String excelPath){
    try {
      File src = new File(excelPath);
      FileInputStream fis = new FileInputStream(src);
      wb = new XSSFWorkbook(fis);
    }
    catch (Exception e) {
      System.out.println("The error message is " + e.getMessage());
    }
  }

  public String readExcelData (int sheetNumber, int row, int column){
    sheet1 = wb.getSheetAt(sheetNumber);
    String data = sheet1.getRow(row).getCell(column).getStringCellValue();
    return data;

  }

}


