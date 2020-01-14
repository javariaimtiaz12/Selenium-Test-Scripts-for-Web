import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCourseDesc {
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
	public void testCourseDesc() throws Exception {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Create a course site")).click();
		driver.findElement(By.id("course_title")).clear();
		driver.findElement(By.id("course_title")).sendKeys("Engineering Graphics");
		driver.findElement(By.id("course_officialCode")).clear();
		driver.findElement(By.id("course_officialCode")).sendKeys("AAOC112");
		Select category = new Select(driver.findElement(By.id("mslist2")));
		category.selectByVisibleText("Sciences");
		driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[3]/table/tbody/tr/td[2]/a[2]/img")).click();
		driver.findElement(By.id("access_public")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]* Access allowed to anybody[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("registration_validation")).click();
		driver.findElement(By.id("registration_validation")).click();
		driver.findElement(By.linkText("Optionnal settings")).click();
		driver.findElement(By.id("course_departmentName")).clear();
		driver.findElement(By.id("course_departmentName")).sendKeys("ECE");
		driver.findElement(By.linkText("Advanced options")).click();
		driver.findElement(By.id("course_userLimit")).clear();
		driver.findElement(By.id("course_userLimit")).sendKeys("60");
		driver.findElement(By.name("changeProperties")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*You have just created the course website[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Logout")).click();
	}
}
