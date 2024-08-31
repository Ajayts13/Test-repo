package com.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Utility.BaseClass;

public class TestClass extends BaseClass {

	@Test
	public void testclass() throws IOException {
		BaseClass bs = new BaseClass();
		bs.OpenBrowser();
//		driver.get("Https://app.fireflink.com");
//		driver.manage().window().maximize();
	}

}
