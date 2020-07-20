import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DismissAddEntryTestSuite {

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
	public void dismissAddEntryTestSuite() {

		driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/a[1]")).click();

		// Fill The Form
		driver.findElement(By.id("newiteminput")).clear();
		driver.findElement(By.id("newiteminput")).sendKeys("Demo Account");

		driver.findElement(By.id("newiteminputuser")).clear();
		driver.findElement(By.id("newiteminputuser")).sendKeys(Constant.userName + Constant.randomNumber);

		driver.findElement(By.id("newiteminputpw")).clear();
		driver.findElement(By.id("newiteminputpw")).sendKeys(Constant.userPassword);

		driver.findElement(By.id("newiteminputurl")).clear();
		driver.findElement(By.id("newiteminputurl")).sendKeys("http://mega.nz");

		driver.findElement(By.id("newiteminputcomment")).clear();
		driver.findElement(By.id("newiteminputcomment"))
				.sendKeys("This is Demo Password and Username for Testing purpose");

		driver.findElement(By.id("newiteminputtags")).clear();
		driver.findElement(By.id("newiteminputtags")).sendKeys("");

		driver.findElement(By.xpath("//*[@id=\"add\"]/div/div/div[3]/button[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/div[2]/h1")).getText().toString(),
				"Settings");

	}

	@AfterSuite
	public void close() {
		driver.close();
	}

}
