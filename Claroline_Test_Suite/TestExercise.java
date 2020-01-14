import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestExercise {
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
	public void testExercise() throws Exception {

		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Platform administration")).click();
		driver.findElement(By.linkText("Configuration")).click();
		driver.findElement(By.linkText("Exercises")).click();
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches(
					"^[\\s\\S]*Properties for Exercises, \\(CLQWZ\\) are now effective on server\\.[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*Automatically insert an event in the calendar at the end date[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("label_exercisesPerPage")).clear();
		driver.findElement(By.id("label_exercisesPerPage")).sendKeys("20");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*Powered by Claroline [\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Logout")).click();
	}
}
