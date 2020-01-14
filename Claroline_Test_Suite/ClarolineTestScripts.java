import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class ClarolineTestScripts {
	WebDriver driver;
	static int in=1;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private boolean acceptNextAlert = true;


	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\A653\\Documents\\Eclipse Workspace Jav\\ClarolineTestSUite\\driver2\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		driver.get("http://localhost:8080/claroline1110/");
		

		
	}

	
//	@Test
//	  public void testAddClass() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Manage classes")).click();
//	    driver.findElement(By.linkText("Create a new class")).click();
//	    driver.findElement(By.name("class_name")).clear();
//	    driver.findElement(By.name("class_name")).sendKeys("CS-A");
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//		/*
//		 * String message=
//		 * driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div")).getText();
//		 * System.out.println (message);
//		 * Assert.assertTrue(message.contains("The new class has been created"));
//		 */
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The new class has been created[\\s\\S]*$"));
//	    } catch (Exception e)
//	    {
//        System.out.println (e);	}
//	    driver.findElement(By.linkText("Logout")).click();
//	  }



//	  @Test
//	  public void testAddCourse() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Create a course site")).click();
//	    driver.findElement(By.id("course_title")).clear();
//	    driver.findElement(By.id("course_title")).sendKeys("Computer Science");
//	    driver.findElement(By.id("course_officialCode")).clear();
//	    driver.findElement(By.id("course_officialCode")).sendKeys("CS212");
//	    Select category =  new Select(driver.findElement(By.id("mslist2")));
//	    category.selectByVisibleText("Mathematics");
//	    driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[3]/table/tbody/tr/td[2]/a[2]/img")).click();
//	    driver.findElement(By.id("course_titular")).clear();
//	    driver.findElement(By.id("course_titular")).sendKeys("Javaria Imtiaz");
//	    driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[7]/label[1]")).click();
//	    driver.findElement(By.linkText("Advanced options")).click();
//	    driver.findElement(By.id("course_status_date")).click();
//	    driver.findElement(By.name("changeProperties")).click();
//	    String message= driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div")).getText();
//	    Assert.assertTrue(message.contains("You have just created the course website : CS212"));
//	  }

	
	


//	  @Test
//	  public void testAddUser() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Create user")).click();
//	    driver.findElement(By.id("lastname")).clear();
//	    driver.findElement(By.id("lastname")).sendKeys("Naman");
//	    driver.findElement(By.id("firstname")).clear();
//	    driver.findElement(By.id("firstname")).sendKeys("Agr");
//	    driver.findElement(By.id("officialCode")).clear();
//	    driver.findElement(By.id("officialCode")).sendKeys("a7");
//	    driver.findElement(By.id("username")).clear();
//	    driver.findElement(By.id("username")).sendKeys("nam");
//	    driver.findElement(By.id("username")).clear();
//	    driver.findElement(By.id("username")).sendKeys("naman");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("123456");
//	    driver.findElement(By.id("password_conf")).clear();
//	    driver.findElement(By.id("password_conf")).sendKeys("123456");
//	    driver.findElement(By.id("student")).click();
//	    driver.findElement(By.id("student")).click();
//	    driver.findElement(By.id("student")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(student\\)[\\s\\S]*$"));
//	    } catch (Error e) {
//	    	System.out.println (e);
//	    }
//	    driver.findElement(By.id("applyChange")).click();
//	  Assert.assertEquals("Create a new user - Claroline", driver.getTitle());
//	    driver.findElement(By.linkText("Logout")).click();
//	  }
	
//	@Test
//	  public void testAddCategory() throws Exception {
//	char[] s= Character.toChars(in);
//
//    driver.findElement(By.id("login")).clear();
//    driver.findElement(By.id("login")).sendKeys("admin");
//    driver.findElement(By.id("password")).clear();
//    driver.findElement(By.id("password")).sendKeys("admin");
//    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//    driver.findElement(By.linkText("Platform administration")).click();
//    driver.findElement(By.linkText("Manage course categories")).click();
//    driver.findElement(By.linkText("Create a category")).click();
//    driver.findElement(By.id("category_name")).clear();
//    driver.findElement(By.id("category_name")).sendKeys("Software Eng");
//    driver.findElement(By.id("category_code")).clear();
//    driver.findElement(By.id("category_code")).sendKeys("SE112"+ s.toString());
//    in++;
//    driver.findElement(By.id("hidden")).click();
//    driver.findElement(By.id("visible")).click();
//    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//    // Warning: verifyTextPresent may require manual changes
//    try {
//      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category created[\\s\\S]*$"));
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
//    driver.findElement(By.linkText("Logout")).click();
//  }


//	  @Test
//	  public void testAddNewCategory() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Manage course categories")).click();
//	    driver.findElement(By.linkText("Create a category")).click();
//	    driver.findElement(By.id("category_name")).clear();
//	    driver.findElement(By.id("category_name")).sendKeys("Software Testing");
//	    driver.findElement(By.id("category_code")).clear();
//	    driver.findElement(By.id("category_code")).sendKeys("SWT22");
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category created[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }

	
//	  @Test
//	  public void testAddPhone() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Claroline.net news")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Claroline\\.net news\n[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Manage my account")).click();
//	    driver.findElement(By.id("phone")).clear();
//	    driver.findElement(By.id("phone")).sendKeys("7788814476");
//	    driver.findElement(By.id("applyChange")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*The information have been modified[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }


	

//	  @Test
//	  public void testAnnouncement() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Configuration")).click();
//	    driver.findElement(By.linkText("Announcement")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Use 0 to display all[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.id("label_announcementPortletMaxItems")).clear();
//	    driver.findElement(By.id("label_announcementPortletMaxItems")).sendKeys("0");
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Properties for Announcement, \\(CLANN\\) are now effective on server[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Logout")).click();
//	    }


	
	
//	  @Test
//	  public void testAssign() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Configuration")).click();
//	    driver.findElement(By.linkText("Assignments")).click();
//	    driver.findElement(By.id("label_confval_def_sub_vis_change_only_new_FALSE")).click();
//	    driver.findElement(By.id("label_confval_def_sub_vis_change_only_new_TRUE")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	 Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*ets how the assignment property \"default works visibility\" acts\\. It will change the visibility of all the new submissions or it will change the visibility of all submissions already done in the assignment and the new one\\.[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	 Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*For assignments list[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	 Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*/<COURSEID>/work/[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Quota")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	 Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Maximum size of a document that a user can uploa[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	     Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Properties for Assignments, \\(CLWRK\\) are now effective on server\\.[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Submissions")).click();
//	    driver.findElement(By.id("label_clwrk_endDateDelay")).clear();
//	    driver.findElement(By.id("label_clwrk_endDateDelay")).sendKeys("364");
//	    driver.findElement(By.id("label_clwrk_endDateDelay")).clear();
//	    driver.findElement(By.id("label_clwrk_endDateDelay")).sendKeys("365");
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("View all")).click();
//	    driver.findElement(By.linkText("Logout")).click();
//	  }

	
	
	


//	  @Test
//	  public void testCourseCategoryEdit() throws Exception {
//	    
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Manage course categories")).click();
//	    driver.findElement(By.cssSelector("img[alt=\"Edit category\"]")).click();
//	    driver.findElement(By.id("category_code")).clear();
//	    driver.findElement(By.id("category_code")).sendKeys("Sci");
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Economics \\(ECO\\)[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    String Categories_Claroline = driver.getTitle();
//	    driver.findElement(By.cssSelector("img[alt=\"Move down category\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category moved down[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }

	


//	  @Test
//	  public void testCourseDesc() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Create a course site")).click();
//	    driver.findElement(By.id("course_title")).clear();
//	    driver.findElement(By.id("course_title")).sendKeys("Engineering Graphics");
//	    driver.findElement(By.id("course_officialCode")).clear();
//	    driver.findElement(By.id("course_officialCode")).sendKeys("AAOC112");
//	    Select category =  new Select(driver.findElement(By.id("mslist2")));
//        category.selectByVisibleText("Sciences");
//	    driver.findElement(By.xpath("//*[@id=\"mandatories\"]/div/dl/dd[3]/table/tbody/tr/td[2]/a[2]/img")).click();
//	    driver.findElement(By.id("access_public")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]* Access allowed to anybody[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.id("registration_validation")).click();
//	    driver.findElement(By.id("registration_validation")).click();
//	    driver.findElement(By.linkText("Optionnal settings")).click();
//	    driver.findElement(By.id("course_departmentName")).clear();
//	    driver.findElement(By.id("course_departmentName")).sendKeys("ECE");
//	    driver.findElement(By.linkText("Advanced options")).click();
//	    driver.findElement(By.id("course_userLimit")).clear();
//	    driver.findElement(By.id("course_userLimit")).sendKeys("60");
//	    driver.findElement(By.name("changeProperties")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	     Assert. assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You have just created the course website[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }


//	  @Test
//	  public void testDeletingCategory() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Manage course categories")).click();
//	    driver.findElement(By.xpath("//*[@id=\"claroBody\"]/table/tbody/tr[3]/td[6]")).click();
//	    Assert.assertTrue(closeAlertAndGetItsText().matches("^Are you sure to delete Software Eng [\\s\\S]$"));
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Category deleted\\.[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }

	
//	@Test
//	  public void testEditTextZone() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Edit text zones")).click();
//	    driver.findElement(By.cssSelector("img[alt=\"Preview\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*textzone_top\\.inc\\.html[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.xpath("(//img[@alt='Preview'])[5]")).click();
//	    driver.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
//	    driver.findElement(By.cssSelector("input.claroButton")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Hello !! Welcome to Clatoline\\.\\. :\\)[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }
	
//	@Test
//	  public void testExercise() throws Exception {
//	 
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Configuration")).click();
//	    driver.findElement(By.linkText("Exercises")).click();
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Properties for Exercises, \\(CLQWZ\\) are now effective on server\\.[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Automatically insert an event in the calendar at the end date[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.id("label_exercisesPerPage")).clear();
//	    driver.findElement(By.id("label_exercisesPerPage")).sendKeys("20");
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Powered by Claroline [\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }

//	  @Test
//	  public void testLoginLogout() throws Exception {
//	  
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Logout")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Authentication[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	  }

	
//	  @Test
//	  public void testManage() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Manage administrator email notifications")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*System mail : recipients list[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    //driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Logout")).click();
//	 
//	  }


//	  public void testMakeModuleVisible() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("nainy");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("nainy");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Modules")).click();
//	    driver.findElement(By.cssSelector("img[alt=\"Properties\"]")).click();
//	    acceptNextAlert = false;
//	    driver.findElement(By.linkText("Visible")).click();
//	    Assert.    assertTrue(closeAlertAndGetItsText().matches("^ Are you sure you want to make this module visible in all courses [\\s\\S]$"));
//	    driver.findElement(By.linkText("Local settings")).click();
//	    driver.findElement(By.linkText("About")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	Assert. assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Course description[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Activated")).click();
//	    driver.findElement(By.linkText("Deactivated")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	Assert. assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Module activation succeeded[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Automatic")).click();
//	    driver.findElement(By.linkText("Manual")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	     Assert. assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Module activation at course creation set to AUTOMATIC[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }


//	  @Test
//	  public void testManageUsers() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("nainy");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("nainy");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Manage user desktop")).click();
//	    driver.findElement(By.cssSelector("img[alt=\"visible\"]")).click();
//	    driver.findElement(By.cssSelector("img[alt=\"invisible\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My course list[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]* Claroline[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }



//	  @Test
//	  public void testSendMessage() throws Exception {
//	   
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Send a message to all users")).click();
//	    driver.findElement(By.id("message_subject")).clear();
//	    driver.findElement(By.id("message_subject")).sendKeys("Hello");
//	    driver.findElement(By.id("message_fontselect_open")).click();
//	    driver.findElement(By.cssSelector("#mce_18_aria > span.mceText")).click();
//	    driver.findElement(By.cssSelector("span.mceIcon.mce_bold")).click();
//	    driver.findElement(By.cssSelector("span.mceIcon.mce_italic")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Administrator[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.name("send")).click();
//	    driver.findElement(By.linkText("Logout")).click();
//	  }


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	  @Test
//	  public void testSupport() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Support forum")).click();
//	   
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*It is currently[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
////	    // Warning: verifyTextPresent may require manual changes
////	    try {
////	      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Who is online[\\s\\S]*$"));
////	    } catch (Error e) {
////	      verificationErrors.append(e.toString());
////	    }
//	  }

	


//	  @Test
//	  public void testVerifyAuthenticatedUser() throws Exception {
//		  driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Show/Hide")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*textzone_top\\.authenticated\\.inc\\.html[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("View all my messages")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	    	Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*My messages\r\n[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }

//	  @Test
//	  public void testUserList() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("User list")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Naman[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	     Assert. assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Administrator[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }


//	  @Test
//	  public void testViewProfile() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Right profile list")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Course member \\(the user is actually enrolled in the course\\)[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.xpath("(//img[@alt='Edit'])[6]")).click();
//	    Assert.assertEquals("Claroline", driver.getTitle());
//	    driver.findElement(By.cssSelector("a > span")).click();
//	    driver.findElement(By.cssSelector("a > span")).click();
//	    driver.findElement(By.cssSelector("a > span")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Access allowed Access allowed[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("View all right profile")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Agenda 	Access allowed Access allowed 	Access allowed Access allowed 	Access allowed Access allowed 	Edition allowed Edition allowed[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.linkText("Logout")).click();
//	  }

	


//	  @Test
//	  public void testWiki() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Modules")).click();
//	    driver.findElement(By.xpath("(//img[@alt='Properties'])[11]")).click();
//	    driver.findElement(By.linkText("Local settings")).click();
//	    driver.findElement(By.id("label_showWikiEditorToolbar_FALSE")).click();
//	    driver.findElement(By.id("label_forcePreviewBeforeSaving_TRUE")).click();
//	    driver.findElement(By.id("label_forcePreviewBeforeSaving_FALSE")).click();
//	    driver.findElement(By.id("label_showWikiEditorToolbar_TRUE")).click();
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Properties for Wiki, \\(CLWIKI\\) are now effective on server\\.[\\s\\S]*$"));
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("About")).click();
//	    driver.findElement(By.linkText("Logout")).click();
//	  }


	
//	
//	 @Test
//	  public void testAddCourseTestEvent() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("A7 - Computer Science")).click();
//	    driver.findElement(By.id("CLCAL")).click();
//	    driver.findElement(By.linkText("Add an event")).click();
//	    driver.findElement(By.id("title")).click();
//	    driver.findElement(By.id("title")).clear();
//	    driver.findElement(By.id("title")).sendKeys("Exam 001");
//	    driver.findElement(By.id("fday")).click();
//	    new Select(driver.findElement(By.id("fday"))).selectByVisibleText("26");
//	    driver.findElement(By.id("fmonth")).click();
//	    new Select(driver.findElement(By.id("fmonth"))).selectByVisibleText("December");
//	    driver.findElement(By.id("fyear")).click();
//	    new Select(driver.findElement(By.id("fyear"))).selectByVisibleText("2019");
//	    driver.findElement(By.name("submitEvent")).click();
//	    try {
//	      Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div")).getText(), "Event added to the agenda.");
//	    } catch (Error e) {
//	      verificationErrors.append(e.toString());
//	    }
//    driver.findElement(By.linkText("Logout")).click();
//	  }
	
	
//	
//	 @Test
//	  public void testAddCourseExcercise() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).click();
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("AAOC112 - Engineering Graphics")).click();
//	    driver.findElement(By.id("CLQWZ")).click();
//	    driver.findElement(By.linkText("New exercise")).click();
//	    driver.findElement(By.id("title")).click();
//	    driver.findElement(By.id("title")).clear();
//	    driver.findElement(By.id("title")).sendKeys("Excercise 001");
//	    driver.findElement(By.xpath("//input[@id='']")).click();
//	   Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"courseRightContent\"]/div[2]/div")).getText(), "Exercise added");
//    driver.findElement(By.linkText("Logout")).click();
//	  }
	
	
	
	
	
	
//	 @Test
//	  public void testAddEmptyCourse() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Create a course site")).click();
//	    driver.findElement(By.name("changeProperties")).click();
//	    String message= driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div/span[1]")).getText();
//	    Assert.assertTrue(message.contains("Course title needed"));
//	    String message2= driver.findElement(By.xpath("//*[@id='claroBody']/div[2]/div/span[2]")).getText();
//	    Assert.assertTrue(message2.contains("Course code needed"));
//    driver.findElement(By.linkText("Logout")).click();
//	  }
//
//	
	
//	 @Test
//	  public void testAddEmptyUsers() throws Exception {
//	    driver.findElement(By.id("login")).click();
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).click();
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//     driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Create user")).click();
//	    driver.findElement(By.id("lastname")).click();
//	    driver.findElement(By.id("lastname")).clear();
//	    driver.findElement(By.id("lastname")).sendKeys("john");
//	    driver.findElement(By.id("username")).click();
//	    driver.findElement(By.id("username")).clear();
//	    driver.findElement(By.id("username")).sendKeys("john");
//	    driver.findElement(By.id("password")).click();
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("123456");
//	    driver.findElement(By.id("applyChange")).click();
//        Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[1]")).getText(), "You left some required fields empty");
//        Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[2]")).getText(), "You typed two different passwords");
//    driver.findElement(By.linkText("Logout")).click();
//
//	 }

	  
	
	
//	  @Test
//	  public void testAddSameUserTwice() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Create user")).click();
//	    driver.findElement(By.id("lastname")).clear();
//	    driver.findElement(By.id("lastname")).sendKeys("Naman");
//	    driver.findElement(By.id("firstname")).clear();
//	    driver.findElement(By.id("firstname")).sendKeys("Agr");
//	    driver.findElement(By.id("officialCode")).clear();
//	    driver.findElement(By.id("officialCode")).sendKeys("a5");
//	    driver.findElement(By.id("username")).clear();
//	    driver.findElement(By.id("username")).sendKeys("nam");
//	    driver.findElement(By.id("username")).clear();
//	    driver.findElement(By.id("username")).sendKeys("naman");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("123456");
//	    driver.findElement(By.id("password_conf")).clear();
//	    driver.findElement(By.id("password_conf")).sendKeys("123456");
//	    driver.findElement(By.id("student")).click();
//	    driver.findElement(By.id("student")).click();
//	    driver.findElement(By.id("student")).click();
//	    // Warning: verifyTextPresent may require manual changes
//	    try {
//	      Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*\\(student\\)[\\s\\S]*$"));
//	    } catch (Error e) {
//	    	System.out.println (e);
//	    }
//	    driver.findElement(By.id("applyChange")).click();
//	    Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[2]")).getText(),"This username is already taken");
//	    Assert.assertEquals("Create a new user - Claroline", driver.getTitle());
//	   driver.findElement(By.linkText("Logout")).click();
//	  }
//	
//	
	
	
	
//	  @Test
//	  public void testAddWrongEmail() throws Exception {
//	    driver.findElement(By.id("login")).clear();
//	    driver.findElement(By.id("login")).sendKeys("admin");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("admin");
//	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//	    driver.findElement(By.linkText("Platform administration")).click();
//	    driver.findElement(By.linkText("Create user")).click();
//	    driver.findElement(By.id("lastname")).clear();
//	    driver.findElement(By.id("lastname")).sendKeys("Zainab");
//	    driver.findElement(By.id("firstname")).clear();
//	    driver.findElement(By.id("firstname")).sendKeys("ALi");
//	    driver.findElement(By.id("officialCode")).clear();
//	    driver.findElement(By.id("officialCode")).sendKeys("555");
//	    driver.findElement(By.id("username")).clear();
//	    driver.findElement(By.id("username")).sendKeys("Zainab");
//	    driver.findElement(By.id("password")).clear();
//	    driver.findElement(By.id("password")).sendKeys("123456");
//	    driver.findElement(By.id("password_conf")).clear();
//	    driver.findElement(By.id("password_conf")).sendKeys("123456");
//	    driver.findElement(By.id("email")).clear();
//	    driver.findElement(By.id("email")).sendKeys("email");
//	    driver.findElement(By.id("student")).click();
//	    driver.findElement(By.id("applyChange")).click();
//	    Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[1]")).getText(),"The email address is not valid");  
//	    driver.findElement(By.linkText("Logout")).click();
//	  }
	
	
	
	  @Test
	  public void testAddWrongPassword() throws Exception {
	    driver.findElement(By.id("login")).clear();
	    driver.findElement(By.id("login")).sendKeys("admin");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("Platform administration")).click();
	    driver.findElement(By.linkText("Create user")).click();
	    driver.findElement(By.id("lastname")).clear();
	    driver.findElement(By.id("lastname")).sendKeys("Zainab");
	    driver.findElement(By.id("firstname")).clear();
	    driver.findElement(By.id("firstname")).sendKeys("ALi");
	    driver.findElement(By.id("officialCode")).clear();
	    driver.findElement(By.id("officialCode")).sendKeys("555");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("Zainab");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.id("password_conf")).clear();
	    driver.findElement(By.id("password_conf")).sendKeys("1234567");
	    driver.findElement(By.id("student")).click();
	    driver.findElement(By.id("applyChange")).click();
	    Assert. assertEquals(driver.findElement(By.xpath("//*[@id=\"claroBody\"]/div[2]/div[1]")).getText(),"You typed two different passwords");  
	
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
