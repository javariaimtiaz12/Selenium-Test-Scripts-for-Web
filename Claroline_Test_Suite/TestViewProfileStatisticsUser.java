
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestViewProfileStatisticsUser {
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
  public void testViewProfileStatisticsUser() throws Exception {
    driver.get("http://localhost:8082/claroline-1.11.10/index.php?logout=true");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("user002");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user002");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Manage my account")).click();
    driver.findElement(By.linkText("View my statistics")).click();
    driver.findElement(By.id("cidReq")).click();
    new Select(driver.findElement(By.id("cidReq"))).selectByVisibleText("Computer Science");
    driver.findElement(By.id("cidReq")).click();
    driver.findElement(By.xpath("//div[@id='leftContent']/div[4]/div/table/tbody/tr/td")).click();
    assertEquals(driver.findElement(By.linkText("Sample exercise")).getText(), "Sample exercise");
    driver.findElement(By.xpath("//div[@id='leftContent']/div[4]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='leftContent']/div[4]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/small")).getText(), "0/10");
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
