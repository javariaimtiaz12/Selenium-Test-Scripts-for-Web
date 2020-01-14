import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAddCourseEvent {
	WebDriver driver;
	static int in = 1;
	private StringBuffer verificationErrors = new StringBuffer();
	private boolean acceptNextAlert = true;

	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\A653\\Documents\\Eclipse Workspace Jav\\ClarolineTestSUite\\driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/claroline1110/");

	}

	@Test
	public void testAddCourseTestEvent() throws Exception {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("A7 - Computer Science")).click();
		driver.findElement(By.id("CLCAL")).click();
		driver.findElement(By.linkText("Add an event")).click();
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("Exam 001");
		driver.findElement(By.id("fday")).click();
		new Select(driver.findElement(By.id("fday"))).selectByVisibleText("26");
		driver.findElement(By.id("fmonth")).click();
		new Select(driver.findElement(By.id("fmonth"))).selectByVisibleText("December");
		driver.findElement(By.id("fyear")).click();
		new Select(driver.findElement(By.id("fyear"))).selectByVisibleText("2019");
		driver.findElement(By.name("submitEvent")).click();
		try {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div")).getText(),
					"Event added to the agenda.");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Logout")).click();
	}
}
