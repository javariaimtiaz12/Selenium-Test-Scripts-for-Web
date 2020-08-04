

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAddMultipleUsers {
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
  public void testAddMultipleUsers() throws Exception {
    driver.get("http://localhost:8082/claroline-1.11.10/claroline/admin/adminaddnewuser.php");
    driver.findElement(By.xpath("(//a[contains(text(),'Claroline')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='userBannerLeft']/ul/li[3]")).click();
    driver.findElement(By.linkText("Platform administration")).click();
    driver.findElement(By.linkText("Create user")).click();
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("user002");
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("user002");
    driver.findElement(By.id("officialCode")).click();
    driver.findElement(By.id("officialCode")).clear();
    driver.findElement(By.id("officialCode")).sendKeys("002");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("user002");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user002");
    driver.findElement(By.id("password_conf")).click();
    driver.findElement(By.id("password_conf")).clear();
    driver.findElement(By.id("password_conf")).sendKeys("user002");
    driver.findElement(By.id("applyChange")).click();
    driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).getText(), "The new user has been sucessfully created");
    driver.findElement(By.xpath("(//a[contains(text(),'Claroline')])[2]")).click();
    driver.findElement(By.linkText("Platform administration")).click();
    driver.findElement(By.linkText("Create user")).click();
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("user003");
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("user003");
    driver.findElement(By.id("officialCode")).click();
    driver.findElement(By.id("officialCode")).clear();
    driver.findElement(By.id("officialCode")).sendKeys("003");
    driver.findElement(By.id("claroBody")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("user003");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user003");
    driver.findElement(By.id("password_conf")).click();
    driver.findElement(By.id("password_conf")).clear();
    driver.findElement(By.id("password_conf")).sendKeys("user003");
    driver.findElement(By.id("applyChange")).click();
    driver.findElement(By.xpath("//div[@id='claroBody']/div[2]")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).getText(), "The new user has been sucessfully created");
    driver.findElement(By.xpath("(//a[contains(text(),'Claroline')])[2]")).click();
    driver.findElement(By.linkText("Platform administration")).click();
    driver.findElement(By.linkText("Send a message to all users")).click();
    driver.findElement(By.linkText("Administration")).click();
    driver.findElement(By.linkText("Create user")).click();
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("user004");
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("user004");
    driver.findElement(By.id("officialCode")).click();
    driver.findElement(By.id("officialCode")).clear();
    driver.findElement(By.id("officialCode")).sendKeys("004");
    driver.findElement(By.xpath("//html")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("user004");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user004");
    driver.findElement(By.id("password_conf")).click();
    driver.findElement(By.id("password_conf")).clear();
    driver.findElement(By.id("password_conf")).sendKeys("user004");
    driver.findElement(By.id("applyChange")).click();
    driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).getText(), "The new user has been sucessfully created");
    driver.findElement(By.linkText("Logout")).click();
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
