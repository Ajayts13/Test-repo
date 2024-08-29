package testNG_parctice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class readDataFile {

	public static void main(String[] args) throws Exception {
		/// testNG_Practice/src/test/resources/data/dummy.xlsx
		File f = new File("C://Users//User//Downloads//DummyData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		//Workbook w = WorkbookFactory.create(fis);
		//Workbook w = WorkbookFactory.create(fis);
		//String writtenData = w.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		//System.out.println(writtenData);

	}

}
