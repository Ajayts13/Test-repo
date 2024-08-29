package testNG_parctice;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

public class DataProviderusingUtility {

	@Test
	public static void redayExcell() throws IOException {

		int c = utility.ExcelUtility
				.getRowCount(System.getProperty("user.dir") + "/src/test/resources/data/dummyData.xlsx", "Sheet1");
		// int c =
		// utility.ExcelUtility.getRowCount(System.getProperty("user.dir")+"/src/test/resources/data/dummyData.xlsx",
		// "Sheet1");

		System.out.println(c);
	}

}
