package seleniumcollabtive;

import java.awt.Dimension;
import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FINALTEST {

	WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeClass
	void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pc\\eclipse-workspace\\AI_EF_Journal\\driver\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--headless");
		driver = new ChromeDriver();
		driver.get("http://localhost/collabtive/");
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();

	}

	@Test(priority = 0)
	void LoginUserTest() {
		driver.get("http://localhost/collabtive/");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[4]/button")).click();
		Assert.assertEquals(driver.getTitle(), ("Desktop @ Collabtive"));
		System.out.println("Asserted0");

	}

	@Test(priority = 1)
	void AddProjectTest() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"add_butn_myprojects\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("huzaim");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("final ride");
		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[7]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"budget\"]")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@id=\"3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"form_addmyproject\"]/div/form/fieldset/div[9]/button[1]")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green")).getText(), ("Project was added"));
		System.out.println("Asserted1");
	}

	@Test(priority = 2)
	void EditProjectTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"proj_1\"]/tr[1]/td[5]/a[1]")).click();

		
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("changed ride edited");
		driver.findElement(By.xpath("//*[@id=\"content-left-in\"]/div/div[2]/form/fieldset/div[5]/button[1]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_yellow")).getText(), ("Project was edited"));
		System.out.println("Asserted2");
	}

	@Test(priority = 3)
	void Addmilestonetest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Mile stone");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("Dcription");
		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_miles\"]/table/tbody/tr[7]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_miles\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addstone\"]/div/form/fieldset/div[5]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add_butn\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Mile stone1");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("Dcription");
		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_miles\"]/table/tbody/tr[7]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_miles\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addstone\"]/div/form/fieldset/div[5]/button[1]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green")).getText(), ("Milestone was added"));System.out.println("Asserted3");
	}

	@Test(priority = 4)
	void EditMilestoneTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"miles_1\"]/tr[1]/td[5]/a[1]")).click();

		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("changed milstone ride edited");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content-left-in\"]/div/div[2]/form/fieldset/div[5]/button")).click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_yellow")).getText(), ("Milestone was edited"));
		System.out.println("Asserted4");}

	@Test(priority = 5)
	void CloseMilestoneTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"miles_1\"]/tr[1]/td[1]/a")).click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_red")).getText(), ("Milestone was closed"));
		System.out.println("Asserted5");}

	@Test(priority = 6)
	void OpenMilestoneTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"donebutn\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"miles_1\"]/tr[1]/td[1]/a")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green")).getText(), ("Milestone was opened"));
		System.out.println("Asserted6");}

	@Test(priority = 7)
	void RemoveMilestoneTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"miles_2\"]/tr[1]/td[5]/a[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_red")).getText(), ("Milestone was deleted"));
		System.out.println("Asserted7");}

	@Test(priority = 8)
	void Addtasklttest() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"addtasklists\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Tasklt");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("Taskltdescription");
        driver.findElement(By.xpath("//*[@id=\"milestone\"]")).click();
		//*[@id="milestone"]
        
        
        
		driver.findElement(By.xpath("//*[@id=\"milestone\"]")).click();
		{
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"milestone\"]"));
			dropdown.findElement(By.xpath("//option[. = 'Mile stone']")).click();
		}
      
        driver.findElement(By.xpath("//*[@id=\"milestone\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"addlist\"]/div[1]/form/fieldset/div[4]/button[1]")).click();
		//*[@id="addlist"]/div[1]/form/fieldset/div[4]/button[1]
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green:nth-child(1)")).getText(),
				("Tasklist was added"));

		System.out.println("Asserted8");}

	@Test(priority = 9)
	void Addtasktest() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"add_butn_1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("Taskautomation");
		driver.findElement(By.xpath("//*[@id=\"text_ifr\"]")).sendKeys("taskdcription");
		driver.findElement(By.xpath("//*[@id=\"end1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_task1\"]/table/tbody/tr[7]/td[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_task1\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"assigned\"]/option[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"assigned\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"addtaskform1\"]/fieldset/div[6]/button[1]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green:nth-child(1)")).getText(),
				("Task was added"));

		System.out.println("Asserted9");}

	@Test(priority = 10)
	void CloseTaskTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"task_1\"]/tr[1]/td[1]/a")).click();
		Thread.sleep(4000);
		driver.navigate().refresh();
		System.out.println("Asserted10");}

	@Test(priority = 11)
	void OpenTaskTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"donebutn_1\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"task_1\"]/tr[1]/td[1]/a")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("Asserted11");}

	@Test(priority = 12)
	void RemoveTaskTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"task_1\"]/tr[1]/td[5]/a[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Asserted12");}

	@Test(priority = 13)
	void CloseTaskltTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content-left-in\"]/div/div[4]/div/a[1]")).click();
		Thread.sleep(1000);
		System.out.println("Asserted13");}

	@Test(priority = 14)
	void OpenTaskltTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"task_1\"]/tr[1]/td[1]/a")).click();
		Thread.sleep(2000);
		System.out.println("Asserted14");}

	@Test(priority = 15)
	void RemoveTaskltTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"content-left-in\"]/div/div[4]/div/a[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Asserted15");}

	@Test(priority = 16)
	void AssignUserToProjectTest() throws InterruptedException {
		//driver.get("http://localhost/collabtive/managetask.php?action=showproject&id=2&mode=listdeleted");
		driver.findElement(By.xpath("//*[@id=\"proj_1\"]/tr[1]/td[5]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[6]/a")).click();
		//*[@id=\"contentwrapper\"]/div[1]/ul/li[3]/a
		driver.findElement(By.xpath("//*[@id=\"add_butn_member\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addtheuser\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"addtheuser\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"form_member\"]/div/form/fieldset/div[2]/button[1]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_yellow")).getText(),
				("User was assigned"));
		Thread.sleep(2000);
		System.out.println("Asserted16");}

	@Test(priority = 17)
	void DeassignUserToProjectTest() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"iw_\"]/table/tbody/tr[1]/td[2]/a/img")))
				.clickAndHold().build().perform();
		driver.findElement(By.xpath("//*[@id=\"iw_\"]/table/tbody/tr[1]/td[3]/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content-left-in\"]/div/div[1]/h2[2]/form/fieldset/div[3]/button[1]"))
				.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_yellow")).getText(),("User was deassigned"));
	   // assertThat(driver.findElement(By.cssSelector(".info_in_red")).getText(), is("User was deassigned"));

		System.out.println("Asserted17");
		}
	

	@Test(priority = 18)
	void CloseProjectTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"closetoggle\"]/a")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_red")).getText(),
				("User was deassigned"));

		System.out.println("Asserted19");}

	@Test(priority = 19)
	void OpenProjectTest() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"closetoggle\"]/a")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green:nth-child(1)")).getText(),
				("Task was added"));
		System.out.println("Asserted19");}

	@Test(priority = 20)
	void RemoveProjectest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"mainmenue\"]/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"proj_1\"]/tr[1]/td[5]/a[2]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.id("deleted")).getText(), ("Project was deleted"));
		System.out.println("Asserted20");}

	@Test(priority = 21)
	public void Useralreadypresent() throws InterruptedException {
		Thread.sleep(1000);
		driver.get("http://localhost/collabtive/admin.php?action=users");
		driver.findElement(By.id("addmember")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("Umer");
		driver.findElement(By.id("pass")).click();
		driver.findElement(By.id("pass")).sendKeys("asd");
		driver.findElement(By.id("roleselect")).click();
		{
			WebElement dropdown = driver.findElement(By.id("roleselect"));
			dropdown.findElement(By.xpath("//option[. = 'User']")).click();
		}
		driver.findElement(By.id("roleselect")).click();
		driver.findElement(By.cssSelector("button:nth-child(1)")).click();
		driver.findElement(By.id("sitebody")).click();
		System.out.println("Asserted21");}
	
	
	
	
	
	
	
	

	@Test(priority = 22)
	public void Adduseremptyvalue() throws InterruptedException {
		driver.get("http://localhost/collabtive/admin.php?action=users");
		driver.findElement(By.id("addmember")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button:nth-child(1)")).click();
		Thread.sleep(1000);

		System.out.println("Asserted22");}

	@Test(priority = 23)
	public void AddusertestTest() throws InterruptedException {
		Thread.sleep(1000);
		driver.get("http://localhost/collabtive/admin.php?action=users");
		driver.findElement(By.id("addmember")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("kama");
		driver.findElement(By.id("pass")).click();
		driver.findElement(By.id("pass")).sendKeys("aws");
		driver.findElement(By.id("roleselect")).click();
		{
			WebElement dropdown = driver.findElement(By.id("roleselect"));
			dropdown.findElement(By.xpath("//option[. = 'User']")).click();
		}
		driver.findElement(By.id("roleselect")).click();
		driver.findElement(By.cssSelector("button:nth-child(1)")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green")).getText(), ("User was added"));
		System.out.println("Asserted23");}

	@Test(priority = 24)
	public void addroletestt() throws InterruptedException {
		driver.get("http://localhost/collabtive/admin.php?action=users&mode=added");
		driver.findElement(By.id("addrolelink")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".main:nth-child(2) #name")).click();
		driver.findElement(By.cssSelector(".main:nth-child(2) #name")).sendKeys("farhan");
		driver.findElement(By.name("permsions_projects[add]")).click();
		driver.findElement(By.name("permsions_tasks[add]")).click();
		driver.findElement(By.cssSelector(".main:nth-child(2) button:nth-child(2)")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green")).getText(), ("Role was added"));
		System.out.println("Asserted24");}

	@Test(priority = 25)
	public void editrole() throws InterruptedException {
		driver.get("http://localhost/collabtive/admin.php?action=users");
		driver.findElement(By.cssSelector("#role_4 .acc-toggle")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#role_4 .row:nth-child(3) > .checkbox")).click();
		driver.findElement(By.cssSelector("#role_4 .row:nth-child(8) > .checkbox")).click();
		driver.findElement(By.cssSelector("#role_4 .row:nth-child(13) > .checkbox")).click();
		driver.findElement(By.cssSelector("#role_4 button:nth-child(2)")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_yellow")).getText(), ("Role was edited"));
		System.out.println("Asserted25");}

	@Test(priority = 26)
	public void RemoveRole() throws InterruptedException {
		driver.get("http://localhost/collabtive/admin.php?action=users");
		driver.findElement(By.cssSelector("#role_4 .tool_del")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(),
				("Really delete th item?\nDeleting cannot be undone."));

		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		System.out.println("Asserted26");}

	@Test(priority = 27)
	public void EditUserRoleTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.get("http://localhost/collabtive/admin.php?action=users&mode=added");
		driver.findElement(By.cssSelector("#iw_4 img")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("huzaimumer@gmail.com");
		driver.findElement(By.name("role")).click();
		{
			WebElement dropdown = driver.findElement(By.name("role"));
			dropdown.findElement(By.xpath("//option[. = 'User']")).click();
		}
		driver.findElement(By.name("role")).click();
		driver.findElement(By.cssSelector(".right > button")).click();
		System.out.println("Asserted27");}

	@Test(priority = 28)
	public void removeuser() throws InterruptedException {
		driver.get("http://localhost/collabtive/admin.php?action=users");
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"iw_4\"]/table/tbody/tr[1]/td[2]/a/img"));
		builder.clickAndHold(element).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#iw_4 .del")).click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_red")).getText(), ("User was deleted"));

		System.out.println("Asserted28");}

	@Test(priority = 29)
	void performquery() throws InterruptedException {
// driver = new ChromeDriver();
		driver.get("http://localhost/phpmyadmin/db_structure.php?server=1&db=collabtive");

		driver.findElement(By.xpath("//*[@id=\"topmenu\"]/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"id_bookmark\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"id_bookmark\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"button_submit_bookmark\"]")).click();
	}

	@Test(priority = 30)
	void AddMultipleProjectsTest() throws InterruptedException {

		driver.get("http://localhost/collabtive/index.php");

		driver.findElement(By.xpath("//*[@id=\"add_butn_myprojects\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("huzaim");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("final ride");
		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[7]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"budget\"]")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@id=\"3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"form_addmyproject\"]/div/form/fieldset/div[9]/button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"add_butn_myprojects\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("other huzaim");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("one last ride");
		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[7]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"budget\"]")).sendKeys("2000");
		driver.findElement(By.xpath("//*[@id=\"3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"form_addmyproject\"]/div/form/fieldset/div[9]/button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"add_butn_myprojects\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("another huzaim");
		driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("someone stop th ride");
		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[7]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"budget\"]")).sendKeys("3000");
		driver.findElement(By.xpath("//*[@id=\"3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"form_addmyproject\"]/div/form/fieldset/div[9]/button[1]")).click();
		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green")).getText(), ("Project was added"));

	}

	@Test(priority = 31)
	void Addtaskdesktop() throws InterruptedException {
		driver.get("http://localhost/collabtive/admin.php?action=projects&mode=added");

		driver.findElement(By.cssSelector(".tool_edit")).click();

		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addtasklts")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("taskname");
		driver.findElement(By.id("milestone")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button:nth-child(2)")).click();
		driver.findElement(By.id("add_butn_1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).sendKeys("tasksss");

		{
			WebElement dropdown = driver.findElement(By.name("assigned[]"));
			dropdown.findElement(By.xpath("//option[. = 'admin']")).click();
		}
		driver.findElement(By.xpath(" //*[@id=\"addtaskform1\"]/fieldset/div[6]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mainmenue\"]/li[1]/a")).click();
		Assert.assertEquals(driver.findElement(By.linkText("My tasks")).getText(), ("My tasks"));

	}

	@Test(priority = 32)
	public void RemoveTaskDesktopNotPresentTest() {
		driver.findElement(By.cssSelector(".marker-today .tool_del")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(),
				("Really delete th item?\nDeleting cannot be undone."));
		driver.switchTo().alert().accept();
	}

	@Test(priority = 33)
	public void addandremovelatemil() throws InterruptedException {

		driver.findElement(By.cssSelector("#proj_1 .tool_edit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //*[@id=\"contentwrapper\"]/div[1]/ul/li[2]/a")).click();

		driver.findElement(By.id("add_butn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("latemilestone");

		driver.findElement(By.xpath("//*[@id=\"end\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"datepicker_miles\"]/table/tbody/tr[4]/td[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"datepicker_miles\"]/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"addstone\"]/div/form/fieldset/div[5]/button[1]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green")).getText(), ("Milestone was added"));
		driver.findElement(By.cssSelector(".tool_del")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(),
				("Really delete th item?\nDeleting cannot be undone."));
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_red")).getText(), ("Milestone was deleted"));
		// driver.navigate().refresh();

	}

	@Test(priority = 34)
	public void AddAndRemoveMultipleTasksTest() throws InterruptedException {

		driver.get("http://localhost/collabtive/managemilestone.php?action=showproject&id=1&mode=deleted");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn_1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).sendKeys("tasksss");
		{
			WebElement dropdown = driver.findElement(By.name("assigned[]"));
			dropdown.findElement(By.xpath("//option[. = 'admin']")).click();
		}
		driver.findElement(By.xpath(" //*[@id=\"addtaskform1\"]/fieldset/div[6]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mainmenue\"]/li[1]/a")).click();

		driver.get("http://localhost/collabtive/managemilestone.php?action=showproject&id=1&mode=deleted");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn_1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).sendKeys("sss");
		{
			WebElement dropdown = driver.findElement(By.name("assigned[]"));
			dropdown.findElement(By.xpath("//option[. = 'admin']")).click();
		}
		driver.findElement(By.xpath(" //*[@id=\"addtaskform1\"]/fieldset/div[6]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mainmenue\"]/li[1]/a")).click();
		driver.get("http://localhost/collabtive/managemilestone.php?action=showproject&id=1&mode=deleted");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"add_butn_1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).sendKeys("kkkk");
		{
			WebElement dropdown = driver.findElement(By.name("assigned[]"));
			dropdown.findElement(By.xpath("//option[. = 'admin']")).click();
		}
		driver.findElement(By.xpath(" //*[@id=\"addtaskform1\"]/fieldset/div[6]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mainmenue\"]/li[1]/a")).click();

		Assert.assertEquals(driver.findElement(By.linkText("My tasks")).getText(), ("My tasks"));

	}

	@Test(priority = 35)
	public void CloseTasksProjectPercentageTest() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"task_2\"]/tr[1]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"proj_1\"]/tr[1]/td[2]/div/a")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".status")).getText(), ("33%"));

		Thread.sleep(4000);
		// Assert

	}

	@Test(priority = 36)
	public void OpenTasksProjectPercentageTest() throws InterruptedException {
		// *[@id="closetoggle"]/a
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"donebutn_1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"task_2\"]/tr[1]/td[1]/a")).click();

		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[1]/a")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".status")).getText(), ("0%"));

		// assert

	}

	@Test(priority = 37)
	public void SearchProjectTest() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"query\"]")).sendKeys("huzaim");
		driver.findElement(By.xpath("//*[@id=\"search\"]/fieldset/button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("tr:nth-child(2) > td")).getText(), ("huzaim"));

		// assert 3

	}

	@Test(priority = 38)
	public void SearchMultipleProjectsTest() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"query\"]")).sendKeys("other huzaim");
		driver.findElement(By.xpath("//*[@id=\"search\"]/fieldset/button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("tr:nth-child(2) > td")).getText(), ("other huzaim"));

		// assert 2
		driver.findElement(By.xpath("//*[@id=\"query\"]")).sendKeys("another huzaim");
		driver.findElement(By.xpath("//*[@id=\"search\"]/fieldset/button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("tr:nth-child(2) > td")).getText(), ("another huzaim"));

		// assert 1

	}

	@Test(priority = 39)
	public void SearchClosedProjectTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"proj_3\"]/tr[1]/td[1]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"query\"]")).sendKeys("another huzaim");
		driver.findElement(By.xpath("//*[@id=\"search\"]/fieldset/button")).click();
		//Assert.assertEquals(driver.findElement(By.cssSelector("h2:nth-child(2)")).getText(), ("Results (0)"));


	}

	@Test(priority = 40)
	public void RemoveMultipleProjectsTest() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"contentwrapper\"]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"proj_2\"]/tr[1]/td[5]/a[2]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"proj_1\"]/tr[1]/td[5]/a[2]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("deleted")).getText(), ("Project was deleted"));

	}

	@Test(priority = 40)
	void performquery1() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://localhost/phpmyadmin/db_structure.php?server=1&db=collabtive");

		driver.findElement(By.xpath("//*[@id=\"topmenu\"]/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"id_bookmark\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"id_bookmark\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"button_submit_bookmark\"]")).click();

	}
}
