import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCourseCategoryEdit {
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
	public void testCourseCategoryEdit() throws Exception {

		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Platform administration")).click();
		driver.findElement(By.linkText("Manage course categories")).click();
		driver.findElement(By.cssSelector("img[alt=\"Edit category\"]")).click();
		driver.findElement(By.id("category_code")).clear();
		driver.findElement(By.id("category_code")).sendKeys("Sci");
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*Economics \\(ECO\\)[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		String Categories_Claroline = driver.getTitle();
		driver.findElement(By.cssSelector("img[alt=\"Move down category\"]")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*Category moved down[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Logout")).click();
	}
}
