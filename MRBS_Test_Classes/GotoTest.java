import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GotoTest {
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
	public static void gotoTest() throws Exception {

		driver.findElement(By.xpath("//input[@value='goto']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Area New']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Go To Today']")).click();
		Thread.sleep(1000);
		try {
			Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Demo Entry']")).getText(), "Demo Entry");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void close() {
		driver.close();
	}

}
