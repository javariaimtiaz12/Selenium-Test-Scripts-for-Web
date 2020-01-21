package seleniumcollabtive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Adduser {
	WebDriver driver;
	@BeforeMethod
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\pc\\eclipse-workspace\\AI_EF_Journal\\driver\\chromedriver.exe"
				  );

		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		driver = new ChromeDriver();
		driver.get("http://localhost/collabtive/");
		
	}
	
	
	@Test(priority = 0)
	void Adduser() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mainmenue\"]/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn_member\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Ali");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Ali@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Ali");
		driver.findElement(By.xpath("//*[@id=\"rate\"]")).sendKeys("ten");
		driver.findElement(By.xpath("//*[@id=\"11\"]")).click();
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"roleselect\"]")));
		dropdown.selectByVisibleText("User");
	}
	
	//((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

	
}
