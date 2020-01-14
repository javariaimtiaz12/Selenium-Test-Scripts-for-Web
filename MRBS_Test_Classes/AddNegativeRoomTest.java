import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddNegativeRoomTest {
	private static WebDriver driver;

	@BeforeSuite
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Quest\\eclipse-workspace\\FlexTesting\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.BASE_URL);

		// Login User Administrator
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value=' Log in ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("NewUserName")).clear();
		driver.findElement(By.name("NewUserName")).sendKeys(Constants.ADMIN_USER_NAME);
		driver.findElement(By.name("NewUserPassword")).clear();
		driver.findElement(By.name("NewUserPassword")).sendKeys(Constants.ADMIN_PASSWORD);
		driver.findElement(By.xpath("/html/body/form/input[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Admin']")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 0)
	public static void addRoomTest() throws Exception {

		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[1]/ul/li[4]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[2]/form/table/tbody/tr[1]/td[2]/input"))
				.clear();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[2]/form/table/tbody/tr[1]/td[2]/input"))
				.sendKeys("New Room");
		driver.findElement(By.name("description")).clear();
		driver.findElement(By.name("description")).sendKeys("Nice Room");
		driver.findElement(By.name("capacity")).clear();
		driver.findElement(By.name("capacity")).sendKeys("okk");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@value='Add Room']")).click();
		Thread.sleep(2000);
		try {
			Assert.assertEquals(driver.findElement(By.xpath("/html/body/p[1]")).getText(),
					"Unknown column 'okk' in 'field list'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void close() {
		driver.close();
	}

	public static void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

}
