import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestWiki {
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
	public void testWiki() throws Exception {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Platform administration")).click();
		driver.findElement(By.linkText("Modules")).click();
		driver.findElement(By.xpath("(//img[@alt='Properties'])[11]")).click();
		driver.findElement(By.linkText("Local settings")).click();
		driver.findElement(By.id("label_showWikiEditorToolbar_FALSE")).click();
		driver.findElement(By.id("label_forcePreviewBeforeSaving_TRUE")).click();
		driver.findElement(By.id("label_forcePreviewBeforeSaving_FALSE")).click();
		driver.findElement(By.id("label_showWikiEditorToolbar_TRUE")).click();
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		// Warning: verifyTextPresent may require manual changes
		try {
			Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*Properties for Wiki, \\(CLWIKI\\) are now effective on server\\.[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		driver.findElement(By.linkText("About")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
}
