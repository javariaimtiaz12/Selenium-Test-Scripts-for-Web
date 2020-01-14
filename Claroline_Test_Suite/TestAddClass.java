import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAddClass {
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
	public void testAddClass() throws Exception {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Platform administration")).click();
		driver.findElement(By.linkText("Manage classes")).click();
		driver.findElement(By.linkText("Create a new class")).click();
		driver.findElement(By.name("class_name")).clear();
		driver.findElement(By.name("class_name")).sendKeys("CS-A");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		/*
		 * String message=
		 * driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div")).getText();
		 * System.out.println (message);
		 * Assert.assertTrue(message.contains("The new class has been created"));
		 */
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*The new class has been created[\\s\\S]*$"));
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.findElement(By.linkText("Logout")).click();
	}

}
