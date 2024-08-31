package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	// All Variables
	public static String propertyfilepath = System.getProperty("user.dir") + "/TestDataFolder/propFile.properties";
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public Sheet sheet;
	public static DataFormatter df;
	public static Properties properties;
	// public static Logger logger;
	public static String testDataFilepath = System.getProperty("user.dir") + "/src/test/resources/VTigerTestdata.xlsx";
	public static WebDriver driver;
	public static String screenshootFilePath = System.getProperty("user.dir") + "/src/test/resources/Screenshots";

//----------------------------------------------------------------------------------------------------------------------------------
	// Read Property File Path
	public static String GetPropertyValue(String PropertyKey) throws IOException {
		// TODO Auto-generated method stub
		fis = new FileInputStream(propertyfilepath);
		Properties properties = new Properties();
		properties.load(fis);

		return properties.getProperty(PropertyKey);
	}

	// ----------------------------------------------------------------------------------------------------------------------------------

	// Launch the browser mentioned in property file
	public static void OpenBrowser() throws IOException {
		String BrowserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: GetPropertyValue("browser");

		switch (BrowserName.toLowerCase()) {
		case "chrome": {
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		case "firefox": {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		}

		case "edge": {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/TestDataFolder/msedgedriver.exe");
			 driver = new EdgeDriver();
			 driver.manage().window().maximize();
			break;
		}
		}
	}
	


	// ----------------------------------------------------------------------------------------------------------------------------------

	public static void getUrl(String url) {
		driver.get(url);
	}

//-----------------------------------------------------------------------------------
	// Enter Input into Element
	public void enterInputintoElement(String input, WebElement element) {

		element.sendKeys(input);
	}

	// -----------------------------------------------------------------------------------
	// click on Element
	public void ClickonElement(WebElement element) {

		element.click();
	}

	// -----------------------------------------------------------------------------------
	// Element Displayed
	public void ElementDisplayed(WebElement element) {
		try {
			element.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Required Elemnt is not present in the page");
		}
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public Alert switchToAlert() {
		Alert al = driver.switchTo().alert();
		return al;
	}

//**************************************************************************************************************************************************************	
	// Select DROPDOWN option by value
	public void SelectValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	// **************************************************************************************************************************************
	// User Defined Method Get Data FromExcel
	public static LinkedHashMap<String, String> getDataFromExcel(String excelPath, String sheetName, String uniqueData,
			boolean isTableVertical) throws IOException {
		FileInputStream fisExcel = new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fisExcel);
		DataFormatter df = new DataFormatter();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNumber = sheet.getLastRowNum(); // return index ==> index

		String value = "";
		String actualTestCaseName = "";
		String actualKey = "";

		// For Horizontal Data Featching In Key Value Pair
		if (isTableVertical == false) {
			for (int i = 0; i <= lastRowNumber; i++) {
				String actualTestcase = "";
				try {
					actualTestcase = df.formatCellValue(sheet.getRow(i).getCell(0));

				} catch (NullPointerException n) {
					actualTestcase = "";
				}

				if (actualTestcase.equals(uniqueData)) {
					short lastcellNumber = sheet.getRow(i).getLastCellNum(); // return count/size ==> count-1
					for (int j = 1; j < lastcellNumber; j++) {
						actualKey = df.formatCellValue(sheet.getRow(i - 1).getCell(j));
						value = df.formatCellValue(sheet.getRow(i).getCell(j));
						map.put(actualKey, value);
					}
					break;
				}
			}
		}

		// For Vertical Data Featching In Key Value Pair
		else if (isTableVertical == true) {
			for (int i = 1; i <= sheet.getRow(i).getLastCellNum(); i++) {

				try {
					actualTestCaseName = df.formatCellValue(sheet.getRow(0).getCell(i));

				} catch (Exception e) {
				}
				if (actualTestCaseName.equalsIgnoreCase(uniqueData)) {
					for (int j = 0; j <= sheet.getLastRowNum(); j++) {

						try {
							actualKey = df.formatCellValue(sheet.getRow(j).getCell(i - 1));
							try {
								value = df.formatCellValue(sheet.getRow(j).getCell(i));
							} catch (Exception e) {
							}

							if ((actualKey.isEmpty() && value.isEmpty()) || actualKey.isEmpty()) {
							} else {
								map.put(actualKey, value);
							}
						} catch (Exception e) {
						}
					}
					break;
				}
			}
		}
		workbook.close();
		fisExcel.close();
		return map;
	}

//*********************************************************************************************************************************	

	public void getScreenshot(String result) throws IOException {

		TakesScreenshot ss = (TakesScreenshot) driver;
		File f = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(screenshootFilePath + result + "screenshor.png"));

	}

}
