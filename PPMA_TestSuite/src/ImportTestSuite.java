import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ImportTestSuite {

	WebDriver driver;
	static int expected_row_count = 0;

	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sulem\\eclipse-workspace\\PhpManagerTestSuite\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://localhost/PasswordManager-9.08/src/index.php");

		driver.findElement(By.id("user")).clear();
		driver.findElement(By.id("pwd")).clear();

		driver.findElement(By.id("user")).sendKeys(Constant.userName + Constant.randomNumber);
		driver.findElement(By.id("pwd")).sendKeys(Constant.userPassword);

		// Sign Up Button Click
		driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 0)
	public void importCsvTestSuite() {

		driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/a[4]")).click();

		driver.findElement(By.id("importc")).sendKeys("C:\\Users\\sulem\\Downloads\\export.csv");

		driver.findElement(By.id("importbtn")).click();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String alertText = driver.switchTo().alert().getText();

		AssertJUnit.assertEquals(alertText, "IMPORT FINISHED!");
		driver.switchTo().alert().accept();

	}

	@Test(priority = 1)
	public void dismissImprtCvsTestSuite() {

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/a[4]")).click();

		driver.findElement(By.id("importc")).sendKeys("C:\\Users\\sulem\\Downloads\\export.csv");

		driver.findElement(By.xpath("//*[@id=\"import\"]/div/div/div[3]/button[1]")).click();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/div[2]/h1")).getText().toString(),
				"Settings");

	}

	@AfterSuite
	public void close() {
		try {
		driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
