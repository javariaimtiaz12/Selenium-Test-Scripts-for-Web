
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestEnrolCourseWithActivationKey {
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
  public void testEnrolCourseWithActivationKey() throws Exception {
    driver.get("http://localhost:8082/claroline-1.11.10/index.php?logout=true");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("user004");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user004");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Enrol on a new course")).click();
    driver.findElement(By.linkText("Economics")).click();
    driver.findElement(By.xpath("//a[contains(text(),'004        –\n        Course004')]")).click();
    driver.findElement(By.xpath("//div[@id='toolViewOption']/a/b")).click();
    driver.findElement(By.xpath("//div[@id='courseRightContent']/div/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='courseRightContent']/div/div")).getText(), "Your enrolment to this course has not been validated yetYou won't be able to access all this course's content and/or features until the course manager grants you the access.");
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("admin");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("admin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("004 - Course004")).click();
    driver.findElement(By.linkText("course user list")).click();
    driver.findElement(By.xpath("//img[@alt='Validation']")).click();
    driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).click();
    assertEquals(driver.findElement(By.xpath("//div[@id='courseRightContent']/div[2]/div")).getText(), "This user account is now active in the course");
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("user004");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user004");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("All platform courses")).click();
    driver.findElement(By.id("coursesearchbox_keyword")).click();
    driver.findElement(By.id("coursesearchbox_keyword")).clear();
    driver.findElement(By.id("coursesearchbox_keyword")).sendKeys("course004");
    driver.findElement(By.id("coursesearchbox_keyword")).sendKeys(Keys.ENTER);
    try {
      assertEquals(driver.findElement(By.xpath("//a[contains(text(),'004        –\n        Course004')]")).getText(), "004 –\n Course004");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
