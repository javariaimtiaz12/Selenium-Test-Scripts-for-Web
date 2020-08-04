
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSearchAdmin {
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
  public void testSearchAdmin() throws Exception {
    driver.get("http://localhost:8082/claroline-1.11.10/claroline/admin/admin_users.php");
    driver.findElement(By.id("breadcrumbLine")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Claroline')])[2]")).click();
    driver.findElement(By.linkText("Platform administration")).click();
    driver.findElement(By.linkText("Advanced")).click();
    driver.findElement(By.id("lastName")).click();
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys("java");
    driver.findElement(By.xpath("//input[@value='Search user']")).click();
    driver.findElement(By.linkText("Advanced")).click();
    driver.findElement(By.xpath("//input[@value='Search user']")).click();
    driver.findElement(By.id("L0")).click();
    assertEquals(driver.findElement(By.id("L0")).getText(), "java");
    driver.findElement(By.xpath("//div[@id='claroBody']/table[2]")).click();
    driver.findElement(By.xpath("//div[@id='claroBody']/table[2]/tbody/tr/td[5]")).click();
    assertEquals(driver.findElement(By.linkText("admin@admin.com")).getText(), "admin@admin.com");
    driver.findElement(By.xpath("//div[@id='claroBody']/table[2]")).click();
    driver.findElement(By.id("campusFooterCenter")).click();
    driver.findElement(By.xpath("//div[@id='claroBody']/table[2]/tbody/tr/td[6]")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='claroBody']/table[2]/tbody/tr/td[6]")).getText(), "Course creatorAdministrator");
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
