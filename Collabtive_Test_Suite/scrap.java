package seleniumcollabtive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

public class scrap {
	
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
	@Test(priority = 0)
	void LoginUserTest()
	{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();
	}
	
	
	@Test(priority = 1)

		void DeassignUserToProjectTest() throws InterruptedException
		{ 
		driver = new ChromeDriver();
		driver.get("http://localhost/phpmyadmin/db_structure.php?server=1&db=collabtive");
	    	Actions action= new Actions(driver);
	    	action.moveToElement(driver.findElement(By.id("iw_3"))).clickAndHold().build().perform();
			driver.findElement(By.xpath("//*[@id=\"iw_\"]/table/tbody/tr[1]/td[3]/div/a[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"content-left-in\"]/div/div[1]/h2[2]/form/fieldset/div[3]/button[1]")).click();
			Thread.sleep(2000);
		}
	}
