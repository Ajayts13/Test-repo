package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class test2 {
	@Test
	public void testimg(){
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/TestDataFolder/msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
}

}