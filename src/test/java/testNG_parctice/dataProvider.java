package testNG_parctice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	@DataProvider(name = "data")
	public static Object[][] datatest() {

		Object[][] obj = null;

		obj[0][0] = "Ajay";
		obj[0][1] = "pass";
		obj[1][0] = "Aj";
		obj[1][1] = "fail";

		return obj;
	}

	@Test(dataProvider = "data")
	public void loginTest(String s) {
		System.out.println(s);
		
	}
}
