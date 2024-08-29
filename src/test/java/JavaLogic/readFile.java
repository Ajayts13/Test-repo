package JavaLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class readFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		File f = new File("./src/test/resources/data/dummy.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook w=WorkbookFactory.create(fi);
		Sheet one = w.getSheet("Sheet1");
		int rowNum=one.getLastRowNum();
		System.out.println(rowNum);
		
		
	}

}

