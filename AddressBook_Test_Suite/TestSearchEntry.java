import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestSearchEntry {
	WebDriver driver;
	Random random = new Random();
	int rand_number = random.nextInt(1520000);
	static int expected_row_count = 0;
	private static String downloadPath = "C:\\Users\\A653\\Downloads";

	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\A653\\Documents\\Eclipse Workspace Jav\\AddressBookTestSuite\\driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/addressbookv6.1/");
		expected_row_count = driver
				.findElements(By.cssSelector("table#maintable.sortcompletecallback-applyZebra>tbody>tr")).size();
		System.out.println(expected_row_count);
	}

	@Test(priority = 0)
	public void SearchEntryTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='nav']/ul/li[1]/a")).click();
		Thread.sleep(100);
		driver.findElement(By.name("searchstring")).sendKeys("Suleman");
		driver.findElement(By.name("searchstring")).click();
		Assert.assertEquals(true, driver.getPageSource().contains("Muhammad Suleman"));
		Assert.assertEquals(true, driver.getPageSource().contains("03165282707"));
	}
}
