package seleniumcollabtive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class phpautomation {
	
	WebDriver driver;
	@BeforeMethod
	void setUpphp() 
	{
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\pc\\eclipse-workspace\\AI_EF_Journal\\driver\\chromedriver.exe"
				  );

		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		driver = new ChromeDriver();
		driver.get("http://localhost/phpmyadmin/db_structure.php?server=1&db=collabtive");
	}
	
	
	@Test(priority = 0)
	void performquery() throws InterruptedException
	{

		driver.findElement(By.xpath("//*[@id=\"topmenu\"]/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"id_bookmark\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"id_bookmark\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"button_submit_bookmark\"]")).click();
		
		

	}

}