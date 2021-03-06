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

public class DeleteEntryTest {
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

	}

	@Test(priority = 0)
	public static void deleteEntryTest() throws Exception {

		driver.findElement(By.xpath("//a[text()='Area New']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Go To Today']")).click();
		Thread.sleep(1000);
		// <WebElement> list = driver.findElements(By.xpath("//img[@src='new.gif']"));
		// list.get(0).click();
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath("//a[@title='Demo Entry']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//a[text()='Demo Entry']")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/p[1]/a[3]")).click();
		driver.switchTo().alert().accept();
		try {
			Assert.assertEquals(driver.findElement(By.xpath("//font[@color='red']")).getText(), "Area New");
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
