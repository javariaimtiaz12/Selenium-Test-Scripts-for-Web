


	

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAddDeniedCourse {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddDeniedCourse() throws Exception {
    driver.get("http://localhost:8082/claroline-1.11.10/index.php");
    driver.findElement(By.linkText("Create a course site")).click();
    driver.findElement(By.id("course_title")).click();
    driver.findElement(By.id("course_title")).clear();
    driver.findElement(By.id("course_title")).sendKeys("Computer Science");
    driver.findElement(By.id("course_officialCode")).click();
    driver.findElement(By.id("course_officialCode")).clear();
    driver.findElement(By.id("course_officialCode")).sendKeys("225");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=mslist2 | label=Sciences]]
    driver.findElement(By.xpath("//option[@value='2']")).click();
    driver.findElement(By.xpath("//fieldset[@id='mandatories']/div/dl/dd[3]/table/tbody/tr/td[2]/a[2]/img")).click();
    driver.findElement(By.id("mandatories")).click();
    driver.findElement(By.id("course_titular")).clear();
    driver.findElement(By.id("course_titular")).sendKeys("John");
    driver.findElement(By.name("changeProperties")).click();
    
    Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/span")).getText(),
		"You have just created the course website : 225");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
