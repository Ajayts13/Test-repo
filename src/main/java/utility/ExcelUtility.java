package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileInputStream fis;
	FileOutputStream fos;
	static XSSFWorkbook wf;

	// to get the row count of the excel sheet
	public static int getRowCount(String filepath, String sheetName) throws IOException {

		fis = new FileInputStream(filepath);
		wf = new XSSFWorkbook(fis);
		XSSFSheet sn = wf.getSheet(sheetName);
		int rowCount = sn.getLastRowNum();
		return rowCount;
	}

	// to get the column count of the excel sheet
	public static int getcellCount(String filepath, String sheetName, int rownumber) throws IOException {

		fis = new FileInputStream(filepath);
		wf = new XSSFWorkbook(fis);
		XSSFSheet sn = wf.getSheet(sheetName);
		int cellCount = sn.getRow(rownumber).getLastCellNum();
		return cellCount;

	}

	// to get the specific cell value
	public static String getCellValue(String filepath, String sheetName, int rowcount, int columrnCount)
			throws IOException {

		fis = new FileInputStream(filepath);
		wf = new XSSFWorkbook(fis);
		XSSFSheet sn = wf.getSheet(sheetName);
		String value = sn.getRow(rowcount).getCell(columrnCount).toString();
		return value;

	}
	
	
	
	
	
	

}
