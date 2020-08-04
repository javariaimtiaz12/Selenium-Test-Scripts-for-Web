

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAddUserTwice {
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
  public void testAddUserTwice() throws Exception {
    driver.get("http://localhost:8082/claroline-1.11.10/index.php?logout=true");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("admin");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Platform administration")).click();
    driver.findElement(By.linkText("User list")).click();
    driver.findElement(By.id("claroBody")).click();
    driver.findElement(By.linkText("Create user")).click();
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("user001");
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("user001");
    driver.findElement(By.id("officialCode")).click();
    driver.findElement(By.id("officialCode")).clear();
    driver.findElement(By.id("officialCode")).sendKeys("001");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("user001");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user001");
    driver.findElement(By.id("password_conf")).click();
    driver.findElement(By.id("password_conf")).clear();
    driver.findElement(By.id("password_conf")).sendKeys("user001");
    driver.findElement(By.id("applyChange")).click();
    driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).getText(), "This official code is already used by another user.");
    driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div[2]")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div[2]")).getText(), "This username is already taken");
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
