import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAddCourse {
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
	public void testAddCourse() throws Exception {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Create a course site")).click();
		driver.findElement(By.id("course_title")).clear();
		driver.findElement(By.id("course_title")).sendKeys("Computer Science");
		driver.findElement(By.id("course_officialCode")).clear();
		driver.findElement(By.id("course_officialCode")).sendKeys("CS212");
		Select category = new Select(driver.findElement(By.id("mslist2")));
		category.selectByVisibleText("Mathematics");
		driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[3]/table/tbody/tr/td[2]/a[2]/img")).click();
		driver.findElement(By.id("course_titular")).clear();
		driver.findElement(By.id("course_titular")).sendKeys("Javaria Imtiaz");
		driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[7]/label[1]")).click();
		driver.findElement(By.linkText("Advanced options")).click();
		driver.findElement(By.id("course_status_date")).click();
		driver.findElement(By.name("changeProperties")).click();
		String message = driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div")).getText();
		Assert.assertTrue(message.contains("You have just created the course website : CS212"));
	}
}
