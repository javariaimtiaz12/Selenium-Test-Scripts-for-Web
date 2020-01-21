package seleniumcollabtive;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProject {
	static WebDriver driver;
	@BeforeMethod
	static
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
	void AddProjectTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"proj_1\"]/tr[1]/td[5]/a[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	//*void setUpphp()
	{
		System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\pc\\eclipse-workspace\\AI_EF_Journal\\driver\\chromedriver.exe"
				  );

		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		driver = new ChromeDriver();
		driver.get("http://localhost/phpmyadmin/tbl_sql.php?db=collabtive&table=projekte");
		
	}
	
	
	@Test(priority = 1)
	void performquery()
	{
		driver.findElement(By.xpath("//*[@id=\"sqlquerycontainer\"]/div[1]/div[6]/div[1]/div/div/div/div[5]/div/pre")).click();
		driver.findElement(By.xpath("//*[@id=\"sqlquerycontainer\"]/div[1]/div[6]/div[1]/div/div/div/div[5]/div/pre")).click();
		driver.findElement(By.xpath("//*[@id=\"sqlquerycontainer\"]/div[1]/div[6]/div[1]/div/div/div/div[5]/div/pre")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\\\"sqlquerycontainer\\\"]/div[1]/div[6]/div[1]/div/div/div/div[5]/div/pre")).sendKeys("SET @autoid :=0;\r\n" + 
				"UPDATE projekte SET ID = @autoid := (@autoid+1);\r\n" + 
				"ALTER TABLE projekte AUTO_INCREMENT = 1;");
		
		driver.findElement(By.xpath("//*[@id=\"button_submit_query\"]")).click();
		//driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		

	}



	
}
