import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SignupTestSuite {

	WebDriver driver;
	static int expected_row_count = 0;

	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sulem\\eclipse-workspace\\PhpManagerTestSuite\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("http://localhost/PasswordManager-9.08/src/index.php");

	}

	@Test(priority = 0)
	public void signUpTestSuite() {
		
		Constant.generateRandomNumber();
		driver.findElement(By.xpath("/html/body/div/button[1]")).click();

		// Fill SignUp Informations
		driver.findElement(By.id("user")).clear();
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd1")).clear();
		driver.findElement(By.id("email")).clear();

		driver.findElement(By.id("user")).sendKeys(Constant.userName + Constant.randomNumber);
		driver.findElement(By.id("pwd")).sendKeys(Constant.userPassword);
		driver.findElement(By.id("pwd1")).sendKeys(Constant.userPassword);
		driver.findElement(By.id("email")).sendKeys(Constant.userName + Constant.randomNumber + "@gmail.com");

		// Sign Up Button Click
		driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals("Successfully signup, now please sign in!", alertText);
			driver.switchTo().alert().accept();


	}

	@Test(priority = 1)
	public void signUpEmptyUserNameTestSuite() {
		
			driver.findElement(By.xpath("/html/body/div/button[1]")).click();

			// Fill SignUp Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();
			driver.findElement(By.id("pwd1")).clear();
			driver.findElement(By.id("email")).clear();

			driver.findElement(By.id("user")).sendKeys("");
			driver.findElement(By.id("pwd")).sendKeys(Constant.userPassword);
			driver.findElement(By.id("pwd1")).sendKeys(Constant.userPassword);
			driver.findElement(By.id("email")).sendKeys(Constant.userName + Constant.randomNumber + "@gmail.com");

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
			String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals("Length of username should be at least 5!", alertText);
			driver.switchTo().alert().accept();

	}

	@Test(priority = 2)
	public void signUpEmptyPasswordTestSuite() {
		

			// Fill SignUp Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();
			driver.findElement(By.id("pwd1")).clear();
			driver.findElement(By.id("email")).clear();

			driver.findElement(By.id("user")).sendKeys(Constant.userName + Constant.randomNumber);
			driver.findElement(By.id("pwd")).sendKeys("");
			driver.findElement(By.id("pwd1")).sendKeys(Constant.userPassword);
			driver.findElement(By.id("email")).sendKeys(Constant.userName + Constant.randomNumber + "@gmail.com");

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
			String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals(
					"The second password you input doesn't match the first one. Or your password is too weak (length should be at least 7)",
					alertText);
			driver.switchTo().alert().accept();


	}

	@Test(priority = 3)
	public void signUpEmptyConfirmPasswordTestSuite() {
		

			// Fill SignUp Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();
			driver.findElement(By.id("pwd1")).clear();
			driver.findElement(By.id("email")).clear();

			driver.findElement(By.id("user")).sendKeys(Constant.userName + Constant.randomNumber);
			driver.findElement(By.id("pwd")).sendKeys(Constant.userPassword);
			driver.findElement(By.id("pwd1")).sendKeys("");
			driver.findElement(By.id("email")).sendKeys(Constant.userName + Constant.randomNumber + "@gmail.com");

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
			String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals(
					"The second password you input doesn't match the first one. Or your password is too weak (length should be at least 7)",
					alertText);
			driver.switchTo().alert().accept();


	}

	@Test(priority = 4)
	public void signUpEmptyEmailTestSuite() {
		

			// Fill SignUp Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();
			driver.findElement(By.id("pwd1")).clear();
			driver.findElement(By.id("email")).clear();

			driver.findElement(By.id("user")).sendKeys(Constant.userName + Constant.randomNumber);
			driver.findElement(By.id("pwd")).sendKeys(Constant.userPassword);
			driver.findElement(By.id("pwd1")).sendKeys(Constant.userPassword);
			driver.findElement(By.id("email")).sendKeys("");

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
			String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals("This is not a valid Email", alertText);
			driver.switchTo().alert().accept();

	}

	@Test(priority = 5)
	public void signUpWrongPasswordTestSuite() {
		

			// Fill SignUp Informations
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("pwd")).clear();
			driver.findElement(By.id("pwd1")).clear();
			driver.findElement(By.id("email")).clear();

			driver.findElement(By.id("user")).sendKeys(Constant.userName + Constant.randomNumber);
			driver.findElement(By.id("pwd")).sendKeys(Constant.userPassword);
			driver.findElement(By.id("pwd1")).sendKeys(Constant.userPassword + "1");
			driver.findElement(By.id("email")).sendKeys(Constant.userName + Constant.randomNumber + "@gmail.com");

			// Sign Up Button Click
			driver.findElement(By.id("chk")).click();
			try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
			String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals(
					"The second password you input doesn't match the first one. Or your password is too weak (length should be at least 7)",
					alertText);
			driver.switchTo().alert().accept();
		


	}

	@AfterSuite
	public void close() {
		driver.close();
	}

}
