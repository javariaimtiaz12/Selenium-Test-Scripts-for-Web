package seleniumcollabtive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Addmilestone {
	
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
	void Addmilestone() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"proj_11\"]/tr[1]/td[5]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("anothermilestone");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("dcription");
		driver.findElement(By.xpath("//*[@id=\"addstone\"]/div/form/fieldset/div[5]/button[1]")).click();





	}

}
