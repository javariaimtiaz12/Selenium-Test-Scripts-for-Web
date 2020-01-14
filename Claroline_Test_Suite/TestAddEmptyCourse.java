import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAddEmptyCourse {
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
	public void testAddEmptyCourse() throws Exception {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Create a course site")).click();
		driver.findElement(By.name("changeProperties")).click();
		String message = driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/span[1]")).getText();
		Assert.assertTrue(message.contains("Course title needed"));
		String message2 = driver.findElement(By.xpath("//*[@id='claroBody']/div[2]/div/span[2]")).getText();
		Assert.assertTrue(message2.contains("Course code needed"));
		driver.findElement(By.linkText("Logout")).click();
	}

}
