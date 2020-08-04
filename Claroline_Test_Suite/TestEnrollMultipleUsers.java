

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestEnrollMultipleUsers {
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
  public void testEnrollMultipleUsers() throws Exception {
    driver.get("http://localhost:8082/claroline-1.11.10/index.php?logout=true");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("user002");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user002");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Enrol on a new course")).click();
    driver.findElement(By.linkText("Humanities")).click();
    driver.findElement(By.linkText("Back to parent category")).click();
    driver.findElement(By.linkText("Sciences")).click();
    driver.findElement(By.xpath("//a[contains(text(),'225        –\n        Computer Science')]")).click();
    driver.findElement(By.xpath("//div[@id='toolViewOption']/a/b")).click();
    driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).getText(), "You've been enrolled on the course");
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("user003");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user003");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Enrol on a new course")).click();
    driver.findElement(By.id("claroBody")).click();
    driver.findElement(By.linkText("Sciences")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'225        –\n        Computer Science')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='toolViewOption']/a/b")).click();
    driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).getText(), "You've been enrolled on the course");
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("user004");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user004");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Enrol on a new course")).click();
    driver.findElement(By.linkText("Sciences")).click();
    driver.findElement(By.xpath("//a[contains(text(),'225        –\n        Computer Science')]")).click();
    driver.findElement(By.xpath("//div[@id='toolViewOption']/a/b")).click();
    driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).click();
    driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //div[@id='courseRightContent']/div[2]/div | ]]
    driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).getText(), "You've been enrolled on the course");
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
