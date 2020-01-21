package seleniumcollabtive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProjectTest {
	
	WebDriver driver;
	@BeforeMethod
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\A653\\Documents\\Eclipse Workspace Jav\\AddressBookTestSuite\\driver2\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		driver.get("http://localhost:8080/collabtive-31/index.php/");
		
	}
	@Test(priority = 1)
	void addProject1() throws InterruptedException
	{

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn_myprojects\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("huzaim");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("final ride");
		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[7]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"budget\"]")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"form_addmyproject\"]/div/form/fieldset/div[9]/button[1]")).click();
		
	}
		

}
