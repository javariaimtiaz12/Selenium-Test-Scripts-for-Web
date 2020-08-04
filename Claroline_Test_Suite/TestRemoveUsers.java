
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRemoveUsers {
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
  public void testRemoveUsers() throws Exception {
    driver.get("http://localhost:8082/claroline-1.11.10/claroline/admin/admin_courses.php?cmd=exDelete&delCode=003_001&amp;offsetC=0");
    driver.findElement(By.id("breadcrumbLine")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Claroline')])[2]")).click();
    driver.findElement(By.linkText("Platform administration")).click();
    driver.findElement(By.linkText("User list")).click();
    acceptNextAlert = true;
    driver.findElement(By.xpath("(//img[@alt='Delete'])[4]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure to delete user003 user003 \\(4\\) [\\s\\S]$"));
    driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).click();
    driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).click();
    driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='claroBody']/div[2]/div")).getText(), "Deletion of the user was done sucessfully");
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
