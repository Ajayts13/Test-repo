package selenium_Logic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Users\\User\\Documents\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		String DeleteIcon = "//img[@title=\"Delete address\"]";
		String DeleteButton = "//span[text()=\"DELETE\"]";

		Thread.sleep(50000);

		List<WebElement> numDeleteIcons = driver.findElements(By.xpath(DeleteIcon));
		try {
			if (numDeleteIcons.size() > 0) {
				for (int i = 1; i <= numDeleteIcons.size(); i++) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeleteIcon)));
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DeleteIcon))).click();
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeleteButton)));
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DeleteButton))).click();
					Thread.sleep(1000);

				}
			} else {
				driver.navigate().refresh();
				if (!driver.findElement(By.xpath("//img[@alt='delete']")).isDisplayed()) {
					System.out.println("no items in bag");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
