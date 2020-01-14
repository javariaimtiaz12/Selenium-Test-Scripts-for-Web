import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestSendMessage {
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
	public void testSendMessage() throws Exception {

		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Platform administration")).click();
		driver.findElement(By.linkText("Send a message to all users")).click();
		driver.findElement(By.id("message_subject")).clear();
		driver.findElement(By.id("message_subject")).sendKeys("Hello");
		driver.findElement(By.id("message_fontselect_open")).click();
		driver.findElement(By.cssSelector("#mce_18_aria > span.mceText")).click();
		driver.findElement(By.cssSelector("span.mceIcon.mce_bold")).click();
		driver.findElement(By.cssSelector("span.mceIcon.mce_italic")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(
					driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Administrator[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.name("send")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
}
