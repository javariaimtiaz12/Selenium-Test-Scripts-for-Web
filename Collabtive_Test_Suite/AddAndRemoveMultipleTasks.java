package seleniumcollabtive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAndRemoveMultipleTasks {
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
	void AddAndRemoveMultipleTasks() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"proj_11\"]/tr[1]/td[5]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn_1\"]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Taskautomation");
		driver.findElement(By.xpath("//*[@id=\"text_ifr\"]")).sendKeys("taskdcription");
		driver.findElement(By.xpath("//*[@id=\"end1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_task1\"]/table/tbody/tr[7]/td[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_task1\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"assigned\"]/option[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"addtaskform1\"]/fieldset/div[6]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"task_5\"]/tr[1]/td[5]/a[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		//*[@id="task_6"]/tr[1]/td[5]/a[2]
		//*[@id="task_1"]/tr[1]/td[5]/a[2]
		//*[@id="task_2"]/tr[1]/td[5]/a[2]
		}

}
