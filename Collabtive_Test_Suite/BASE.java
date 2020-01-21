package seleniumcollabtive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BASE {
	
	WebDriver driver;
	@BeforeClass
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
	
	
	@Test(priority = 1)
	void performLogin()
	{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();

	}
	
	
	@Test(priority = 2, dependsOnMethods={"performLogin"})
	void addProject()
	{

		//driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		//driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		//driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn_myprojects\"]")).click();

		
	}

		


	

}
