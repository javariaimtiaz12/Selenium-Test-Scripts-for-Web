import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeeEntryPasswordTestSuite {

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
	public void seeEntryPasswordTestSuite() {

		driver.findElement(By.id("srch-term")).sendKeys(Constant.userName + Constant.randomNumber);
		driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/button[2]")).click();

		String checkStr = driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[2]/td[2]/span")).getText()
				.toString();

		driver.findElement(By.xpath("//*[@id=\"1\"]/a")).click();

		Assert.assertEquals(Constant.userPassword,
				driver.findElement(By.xpath("//*[@id=\"1\"]/span")).getText().toString());


	}

	@AfterSuite
	public void close() {
		driver.close();
	}

}
