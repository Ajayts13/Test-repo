package testNG_parctice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class readDataFromExcel {

	static String scriptID = "TS002";
	static String key = "";

	@Test
	public void readfFile() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/data/dummy.xlsx");
		Workbook w = WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		Sheet s = w.getSheet("Sheet2");
		int r = s.getLastRowNum();
		System.out.println();
		for (int i = 1; i <= r; i++) {
			String id = df.formatCellValue(s.getRow(i).getCell(0));
			if (id.equals(scriptID)) {
				int c = s.getRow(i).getLastCellNum();
				System.out.println("r: " + r + " c: " + c);
				for (int j = 1; j < c; j++) {

					System.out.println(df.formatCellValue(s.getRow(i - 1).getCell(j)) + " = "
							+ df.formatCellValue(s.getRow(i).getCell(j)));
					// String we = df.formatCellValue(s.getRow(i).getCell(j));
					// System.out.println(df.formatCellValue(s.getRow(i).getCell(j)));
					System.out.print("");

				}
			}
		}
	}

}
