import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTestSuite {

	WebDriver driver;
	static int expected_row_count = 0;

	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sulem\\eclipse-workspace\\PhpManagerTestSuite\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://localhost/PasswordManager-9.08/src/index.php");

	}

	@Test(priority = 0)
	public void loginTestSuite() {


			// Fill Sign In Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();

			driver.findElement(By.id("user")).sendKeys(Constant.userName + Constant.randomNumber);
			driver.findElement(By.id("pwd")).sendKeys(Constant.userPassword);

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/div[2]/h1")).getText().toString(),
					"Settings");


	}

	@Test(priority = 1)
	public void loginNegativeUsernameTestSuite() {

		driver.findElement(
				By.xpath("//*[@id=\"pwdtable\"]/div[1]/div[2]/a"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
			// Fill Sign In Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();

			driver.findElement(By.id("user")).sendKeys("DemoUser");
			driver.findElement(By.id("pwd")).sendKeys(Constant.userPassword);

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Assert.assertEquals(
					driver.findElement(By.id("nouser")).getText().toString(), "We don't have this user on file");

	}

	@Test(priority = 2)
	public void loginNegativePasswordTestSuite() {


			// Fill Sign In Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();

			driver.findElement(By.id("user")).sendKeys(Constant.userName + Constant.randomNumber);
			driver.findElement(By.id("pwd")).sendKeys("DemoPassword");

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Assert.assertEquals(
				driver.findElement(By.id("pwderr")).getText().toString(), "Wrong Password");


	}

	@Test(priority = 3)
	public void loginEmptyFieldsTestSuite() {


			// Fill Sign In Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();

			driver.findElement(By.id("user")).sendKeys("");
			driver.findElement(By.id("pwd")).sendKeys("");

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Assert.assertEquals(driver.findElement(By.id("nouser")).getText().toString(),
				"We don't have this user on file");


	}

	@AfterSuite
	public void close() {
		driver.close();
	}
}
