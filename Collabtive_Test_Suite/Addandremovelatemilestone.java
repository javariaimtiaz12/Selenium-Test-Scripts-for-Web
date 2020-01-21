package seleniumcollabtive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Addandremovelatemilestone {
	
	WebDriver driver;
	@BeforeMethod
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\A653\\Documents\\Eclipse Workspace Jav\\AddressBookTestSuite\\driver2\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		driver.get("http://localhost:8080/collabtive_old/");
		
	}
	
	
	@Test(priority = 0)
	void Addandremovelatemilestone() throws InterruptedException
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
		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"datepicker_miles\"]/table/tbody/tr[6]/td[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_miles\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addstone\"]/div/form/fieldset/div[5]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"miles_late_10\"]/tr[1]/td[5]/a[2]")).click();
		//*[@id="miles_late_10"]/tr[1]/td[5]/a[2]
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
     }

}
