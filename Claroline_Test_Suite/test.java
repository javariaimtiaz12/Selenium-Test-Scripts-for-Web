import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\A653\\Documents\\Eclipse Workspace Jav\\ClarolineTestSUite\\driver2\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
  }

  @Test
  public void testSsss() throws Exception {
    driver.get("http://localhost:8080/example/signup.html");
    driver.findElement(By.id("fn")).click();
    driver.findElement(By.id("fn")).clear();
    driver.findElement(By.id("fn")).sendKeys("fatima");
    driver.findElement(By.id("last")).click();
    driver.findElement(By.id("last")).clear();
    driver.findElement(By.id("last")).sendKeys("ali");
    driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
    driver.findElement(By.id("mail")).click();
    driver.findElement(By.id("mail")).clear();
    driver.findElement(By.id("mail")).sendKeys("fatima@ali");
    driver.findElement(By.id("pass")).click();
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("fam123");
    driver.findElement(By.id("rep_pass")).click();
    driver.findElement(By.id("rep_pass")).clear();
    driver.findElement(By.id("rep_pass")).sendKeys("fam123");
    driver.findElement(By.id("pin")).click();
    driver.findElement(By.id("pin")).clear();
    driver.findElement(By.id("pin")).sendKeys("852000");

//    WebElement radioButton= driver.findElement(By.xpath("//input[@value='MS']"));
//    if (!radioButton.isSelected())
//    {
//    	radioButton.click();
//    }
//   
   // driver.findElement(By.xpath("//select[option[@value='BS']]")).sendKeys("BS");
    WebElement radioButton= driver.findElement(By.xpath("//select[option[@value='MS']]"));
    radioButton.click();
    
  
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter Country'])[1]/following::select[1]")).click();
    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter Country'])[1]/following::select[1]"))).selectByVisibleText("Turkey");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Enter Country'])[1]/following::select[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
  }

}