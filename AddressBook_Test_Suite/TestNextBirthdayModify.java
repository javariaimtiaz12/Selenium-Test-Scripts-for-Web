import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNextBirthdayModify {
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
	public void testnextBirthdayModify() {

		driver.findElement(By.xpath("(//INPUT[@type='submit'])[1]")).click();

		driver.findElement(By.xpath("(//INPUT[@type='text'])[1]")).sendKeys("Muhammad Modify");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[2]")).sendKeys("Suleman");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[3]")).sendKeys("Quest Lab");

		driver.findElement(By.xpath("//TEXTAREA[@name='address']")).sendKeys("Rothas Road G9/4 lamabad");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[4]")).sendKeys("03165282707");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[5]")).sendKeys("03341006096");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[6]")).sendKeys("-----");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[7]")).sendKeys("----");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[8]")).sendKeys("");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[9]")).sendKeys("");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[10]")).sendKeys("-------");

		new Select(driver.findElement(By.xpath("//SELECT[@name='bday']"))).selectByValue("13");

		new Select(driver.findElement(By.xpath("//SELECT[@name='bmonth']"))).selectByValue("December");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[11]")).sendKeys("1996");

		driver.findElement(By.xpath("//TEXTAREA[@name='address2']")).sendKeys("Rothas Road G9/4 lamabad");

		driver.findElement(By.xpath("(//INPUT[@type='text'])[12]")).sendKeys("");

		driver.findElement(By.xpath("//TEXTAREA[@name='notes']")).sendKeys("");

		driver.findElement(By.xpath("(//INPUT[@type='submit'])[1]")).click();

		driver.get("http://localhost/addressbook/birthdays.php");

		driver.findElement(By.xpath("(//IMG[@src='icons/status_online.png'])[1]")).click();
	}
}
