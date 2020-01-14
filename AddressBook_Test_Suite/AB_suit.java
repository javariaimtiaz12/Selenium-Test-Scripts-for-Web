import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.runner.RunWith;

public class AB_suit {

	WebDriver driver;
	Random random = new Random();
	int rand_number = random.nextInt(1520000);
	static int expected_row_count=0;
	private static String downloadPath = "C:\\Users\\A653\\Downloads";


	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\A653\\Documents\\Eclipse Workspace Jav\\AddressBookTestSuite\\driver2\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		driver.get("http://localhost:8080/addressbookv6.1/");
		expected_row_count= driver.findElements(By.cssSelector("table#maintable.sortcompletecallback-applyZebra>tbody>tr")).size();
		System.out.println(expected_row_count);
	}

	@Test(priority = 0)
	public void testGroups() {
		driver.findElement(By.xpath("//A[@href='group.php'][text()='groups']/self::A")).click();
	}

//	@Test(priority = 1)
//	public void testAddNewGroup() {
//
//		driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/input")).click();
//		driver.findElement(By.xpath("//INPUT[@type='text']/self::INPUT")).sendKeys("Suleman Group Demo");
//		driver.findElement(By.xpath("//TEXTAREA[@name='group_header']/self::TEXTAREA")).sendKeys("Suleman Group Header ");
//		driver.findElement(By.xpath("//TEXTAREA[@name='group_footer']/self::TEXTAREA")).sendKeys("Suleman Group Footer");
//		driver.findElement(By.xpath("//INPUT[@type='submit']/self::INPUT")).click();
//		String message= driver.findElement(By.className("msgbox")).getText();
//	 	assertTrue(message.contains("A new group has been entered into the address book."));
//	}



//	@Test(priority = 2)
//	public void testeditGroup() {
//
//		driver.findElement(By.xpath("//A[@href='group.php'][text()='groups']/..")).click();
//		try {
//			driver.findElement(By.xpath("(//INPUT[@type='checkbox'])[2]")).click();
//		} catch (Exception e) {
//			driver.findElement(By.xpath("(//INPUT[@type='checkbox'])[1]")).click();
//		}
//
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[3]")).click();
//
//		// Edit Group
//		driver.findElement(By.xpath("//INPUT[@type='text']/self::INPUT"))
//				.sendKeys("Suleman Group Demo Edit " + rand_number);
//
//		driver.findElement(By.xpath("//TEXTAREA[@name='group_header']/self::TEXTAREA"))
//				.sendKeys("Suleman Group Header Edit");
//
//		driver.findElement(By.xpath("//TEXTAREA[@name='group_footer']/self::TEXTAREA"))
//				.sendKeys("Suleman Group Footer Edit");
//
//		driver.findElement(By.xpath("//INPUT[@type='submit']/self::INPUT")).click();
//
//	}

	@Test(priority = 4)
	public void testaddNewPage() {
		driver.findElement(By.xpath("//A[@href='edit.php'][text()='add new']/self::A")).click();

	}
//
//	@Test(priority = 5)
//	public void testaddNewContact() throws InterruptedException {
//		
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[1]")).sendKeys("Muhammad");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[2]")).sendKeys("Suleman");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[3]")).sendKeys("Quest Lab");
//		driver.findElement(By.xpath("//TEXTAREA[@name='address']")).sendKeys("Rothas Road G9/4 lamabad");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[4]")).sendKeys("03165282707");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[5]")).sendKeys("03341006096");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[6]")).sendKeys("-----");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[7]")).sendKeys("----");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[8]")).sendKeys("msuleman526@gmail.com");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[9]")).sendKeys("msuleman526@gmail.com");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[10]")).sendKeys("-------");
//		new Select(driver.findElement(By.xpath("//SELECT[@name='bday']"))).selectByValue("13");
//		new Select(driver.findElement(By.xpath("//SELECT[@name='bmonth']"))).selectByValue("November");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[11]")).sendKeys("1995");
//		driver.findElement(By.xpath("//TEXTAREA[@name='address2']")).sendKeys("Rothas Road G9/4 lamabad");
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[12]")).sendKeys("");
//		driver.findElement(By.xpath("//TEXTAREA[@name='notes']")).sendKeys("");
//		driver.findElement(By.xpath("//INPUT[@type='submit']")).click();
//		String message= driver.findElement(By.className("msgbox")).getText();
//	 	assertTrue(message.contains("Information entered into address book."));
//		Thread.sleep(100);
//		driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a")).click();
//	    int	actual_row_count= driver.findElements(By.cssSelector("table#maintable.sortcompletecallback-applyZebra>tbody>tr")).size();
//        System.out.println("now after add="+actual_row_count);
//	    Assert.assertTrue(actual_row_count>expected_row_count); // In case of addition of new entry, table size should be upgraded with 1
//	 }
//	
//	@Test(priority = 7)
//	public void testAssignGroup() throws InterruptedException {	
//	
//		driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a")).click();
//		Thread.sleep(100);	
//		driver.findElement(By.cssSelector("[title*='Suleman']")).click(); 
//	    Select grp = new Select(driver.findElement(By.name("to_group")));
//	    grp.selectByVisibleText("Suleman Group Demo");
//	    driver.findElement(By.xpath("//*[@id=\"content\"]/form[2]/div[4]/input")).click();
//	    String message= driver.findElement(By.className("msgbox")).getText();
//	    System.out.println (message);
//	 	assertTrue(message.contains("Users added."));
//	}
//	
//	@Test(priority = 6)
//	public void testdeleteItem() {
//		try {
//			driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a")).click();
//			Thread.sleep(100);			
//			driver.findElement(By.cssSelector("[title*='Suleman']")).click();  // select certain value from table and click
//			driver.findElement(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input")).click();
//			driver.switchTo().alert().accept();
//			Thread.sleep(1000);
//			String message= driver.findElement(By.className("msgbox")).getText();
//            System.out.println(message);
//			Assert.assertEquals("Record successful deleted", message);   
//        driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a")).click();
//        int afterDelete_row_count= driver.findElements(By.cssSelector("table#maintable.sortcompletecallback-applyZebra>tbody>tr")).size();  //Check the size of the table
//         System.out.println("now after delete="+afterDelete_row_count);
//             Assert.assertTrue(afterDelete_row_count==expected_row_count);
//		}
//		catch (Exception e)
//		{
//			System.out.println (e);
//		}
//		}

//	@Test(priority = 7)
//	public void testprintAll() {
//		driver.findElement(By.xpath("//A[@href='view.php?all&print'][text()='print all']/self::A")).click();
//		driver.get("http://localhost:8080/addressbookv6.1/");
//	}
//
//	@Test(priority = 8)
//	public void testprintPhones() {
//		driver.findElement(By.xpath("//A[@href='view.php?all&print&phones'][text()='print phones']/self::A")).click();
//		driver.get("http://localhost:8080/addressbookv6.1/");
//	}

//	@Test(priority = 9)
//	public void testExportAllRecordCSVFile() {
//		
//		driver.findElement(By.xpath("//*[@id='nav']/ul/li[7]/a")).click(); //back to home 
//		driver.findElement(By.xpath("//*[@id=\"content\"]/form[3]/input")).click();
//		File file = getLatestFilefromDir(downloadPath);
//		String csvFileName = file.getName();
//		System.out.println("CSV File Downloaded is :- "+csvFileName);
//		Assert.assertEquals(expected_row_count, getRecordsCountInCSV(downloadPath,csvFileName)); // To verify that number of rows are same in both HTML Table and CSV file
//
//		
//	}

//	@Test(priority = 10)
//	public void testnextBirthdays() {
//		driver.findElement(By.xpath("//*[@id='nav']/ul/li[7]/a")).click(); //back to home 
//		driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[4]/a")).click();
//		 		Assert.assertEquals(true, driver.getPageSource().contains("13."));
//		 		Assert.assertEquals(true, driver.getPageSource().contains("Suleman"));	 	 
//	}
	
//	@Test(priority = 11)
//	public void testdeleteGroup() {
//
//		driver.findElement(By.xpath("//A[@href='group.php'][text()='groups']/..")).click();
//
//		try {
//			driver.findElement(By.xpath("(//INPUT[@type='checkbox'])[2]")).click();
//		} catch (Exception e) {
//			driver.findElement(By.xpath("(//INPUT[@type='checkbox'])[1]")).click();
//		}
//
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[2]")).click();
//
//	}
//	
	
//
//	@Test(priority = 1)
//	public void testnextBirthdayModify() {
//
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[1]")).click();
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[1]")).sendKeys("Muhammad Modify");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[2]")).sendKeys("Suleman");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[3]")).sendKeys("Quest Lab");
//
//		driver.findElement(By.xpath("//TEXTAREA[@name='address']")).sendKeys("Rothas Road G9/4 lamabad");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[4]")).sendKeys("03165282707");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[5]")).sendKeys("03341006096");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[6]")).sendKeys("-----");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[7]")).sendKeys("----");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[8]")).sendKeys("");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[9]")).sendKeys("");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[10]")).sendKeys("-------");
//
//		new Select(driver.findElement(By.xpath("//SELECT[@name='bday']"))).selectByValue("13");
//
//		new Select(driver.findElement(By.xpath("//SELECT[@name='bmonth']"))).selectByValue("December");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[11]")).sendKeys("1996");
//
//		driver.findElement(By.xpath("//TEXTAREA[@name='address2']")).sendKeys("Rothas Road G9/4 lamabad");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[12]")).sendKeys("");
//
//		driver.findElement(By.xpath("//TEXTAREA[@name='notes']")).sendKeys("");
//
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[1]")).click();
//
//		driver.get("http://localhost/addressbook/birthdays.php");
//
//		driver.findElement(By.xpath("(//IMG[@src='icons/status_online.png'])[1]")).click();
//	}
//
//	@Test(priority = 11)
//	public void testnextBirthdayPrint() {
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[2]")).click();
//		driver.get("http://localhost/addressbook/birthdays.php");
//		driver.findElement(By.xpath("(//IMG[@src='icons/status_online.png'])[1]")).click();
//
//	}
//
//	@Test(priority = 13)
//	public void testnextBirthdayModifyDelete() {
//
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[1]")).click();
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[2]")).click();
//		driver.get("http://localhost/addressbook/birthdays.php");
//
//	}
//
//	@Test(priority = 14)
//	public void testnextBirthdayEdit() {
//
//		driver.findElement(By.xpath("(//IMG[@src='icons/pencil.png'])[1]")).click();
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[1]")).sendKeys("Muhammad Edit");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[2]")).sendKeys("Suleman");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[3]")).sendKeys("Quest Lab");
//
//		driver.findElement(By.xpath("//TEXTAREA[@name='address']")).sendKeys("Rothas Road G9/4 lamabad");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[4]")).sendKeys("03165282707");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[5]")).sendKeys("03341006096");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[6]")).sendKeys("-----");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[7]")).sendKeys("----");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[8]")).sendKeys("");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[9]")).sendKeys("");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[10]")).sendKeys("-------");
//
//		new Select(driver.findElement(By.xpath("//SELECT[@name='bday']"))).selectByValue("13");
//
//		new Select(driver.findElement(By.xpath("//SELECT[@name='bmonth']"))).selectByValue("December");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[11]")).sendKeys("1996");
//
//		driver.findElement(By.xpath("//TEXTAREA[@name='address2']")).sendKeys("Rothas Road G9/4 lamabad");
//
//		driver.findElement(By.xpath("(//INPUT[@type='text'])[12]")).sendKeys("");
//
//		driver.findElement(By.xpath("//TEXTAREA[@name='notes']")).sendKeys("");
//
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[1]")).click();
//
//		driver.get("http://localhost/addressbook/birthdays.php");
//
//		driver.findElement(By.xpath("(//IMG[@src='icons/pencil.png'])[1]")).click();
//
//	}
//
//	@Test(priority = 15)
//	public void testnextBirthdayDelete() {
//
//		driver.findElement(By.xpath("(//INPUT[@type='submit'])[2]")).click();
//		driver.get("http://localhost/addressbook/birthdays.php");
//	}
//

//
//	@Test(priority = 17)
//	public void testhomeSearch() {
//
//		driver.findElement(By.xpath("//INPUT[@type='text']")).sendKeys("Zeeshan");
//
//	}
//
//	@Test(priority = 18)
//	public void testhomeAddToSpecific() {
//
//		driver.findElement(By.xpath("//INPUT[@id='id1']")).click();
//		driver.findElement(By.xpath("//INPUT[@type='submit']")).click();
//		driver.get("http://localhost/addressbook/");
//	}
//
//	@Test(priority = 19)
//	public void testhomesendMailToSpecific() {
//
//		driver.findElement(By.xpath("//INPUT[@type='text']")).sendKeys("Zeeshan");
//		driver.findElement(By.xpath("//INPUT[@id='id1']")).click();
//		driver.findElement(By.xpath("//INPUT[@type='button']")).click();
//		driver.get("http://localhost/addressbook/");
//	}
//
//	@Test(priority = 20)
//	public void testhomeAddToAll() {
//		driver.findElement(By.xpath("//INPUT[@id='MassCB']")).click();
//		driver.findElement(By.xpath("//INPUT[@type='submit']")).click();
//		driver.get("http://localhost/addressbook/");
//	}
	
//	@Test(priority = 20)
//	public void	CheckPhonesTest()
//	{
//		driver.findElement(By.xpath("//*[@id='nav']/ul/li[6]/a")).click();
//	Assert.assertEquals(true, driver.getPageSource().contains("Muhammad Suleman"));	
//	Assert.assertEquals(true, driver.getPageSource().contains("03165282707"));
//	Assert.assertEquals(true, driver.getPageSource().contains("03341006096"));
//	driver.navigate().to("http://localhost:8080/addressbookv6.1/");
//
//	}
//	
//	@Test(priority = 21)
//	public void	SearchEntryTest() throws InterruptedException
//	{
//		driver.findElement(By.xpath("//*[@id='nav']/ul/li[1]/a")).click();
//	    Thread.sleep(100);			
//	    driver.findElement(By.name("searchstring")).sendKeys("Suleman");
//	    driver.findElement(By.name("searchstring")).click();
//	    Assert.assertEquals(true, driver.getPageSource().contains("Muhammad Suleman"));	
//		Assert.assertEquals(true, driver.getPageSource().contains("03165282707"));
//	}
//
//	@Test(priority = 21)
//	public void SearchEntryByGroupTest () throws InterruptedException {
//		driver.findElement(By.xpath("//*[@id='nav']/ul/li[1]/a")).click();
//	    Thread.sleep(100);	
//		 driver.findElement(By.xpath("//img[@alt='Details']")).click();
//		 Assert.assertEquals(true, driver.getPageSource().contains("Muhammad Suleman"));
//		 driver.findElement(By.xpath("//*[@id='content']/i/a")).click();
//		 Assert.assertEquals(true, driver.getPageSource().contains("Suleman Group Header"));
//		 String oneRecord = driver.findElement(By.xpath("/html/body/div/div[4]/label/strong/span")).getText();
//		    Assert.assertEquals("1", oneRecord);
//		 
//	}
//	
//	@Test(priority = 22)
//	void testVerifyWrongEntry() throws InterruptedException
//	{
//		driver.findElement(By.xpath("//*[@id='nav']/ul/li[1]/a")).click();
//	    Thread.sleep(100);			
//	    driver.findElement(By.name("searchstring")).sendKeys("sulemana");
//	    driver.findElement(By.name("searchstring")).click();
//	    Assert.assertEquals(true, driver.getPageSource().contains("Number of results:"));
//	    String noRecord = driver.findElement(By.xpath("/html/body/div/div[4]/label/strong/span")).getText();
//	    Assert.assertEquals("0", noRecord);
//	    
//	}
	
//	@Test(priority = 22)
//	void testAddMultipleContactEnteries() throws InterruptedException
//	{
//		Contact cnt= new Contact(null, null, null, null, null, null, null, null, null);
//		ArrayList<Contact> list = cnt.readContactData();
//		for(int i=0;i<list.size();i++)
//		{
//			driver.findElement(By.xpath("//*[@id='nav']/ul/li[2]/a")).click();
//			driver.findElement(By.xpath("(//INPUT[@type='text'])[1]")).sendKeys(list.get(i).getFirst_name());
//			driver.findElement(By.xpath("(//INPUT[@type='text'])[2]")).sendKeys(list.get(i).getLast_name());
//			driver.findElement(By.xpath("(//INPUT[@type='text'])[3]")).sendKeys(list.get(i).getCompany());
//			driver.findElement(By.xpath("//TEXTAREA[@name='address']")).sendKeys(list.get(i).getAddress());
//			driver.findElement(By.xpath("(//INPUT[@type='text'])[4]")).sendKeys(list.get(i).getPhone());
//			driver.findElement(By.xpath("(//INPUT[@type='text'])[8]")).clear();
//			driver.findElement(By.xpath("(//INPUT[@type='text'])[8]")).sendKeys(list.get(i).getEmail());
//			new Select(driver.findElement(By.xpath("//SELECT[@name='bday']"))).selectByValue(list.get(i).getDay());
//			new Select(driver.findElement(By.xpath("//SELECT[@name='bmonth']"))).selectByValue(list.get(i).getMonth());
//			driver.findElement(By.xpath("(//INPUT[@type='text'])[11]")).sendKeys(list.get(i).getYear());
//			driver.findElement(By.xpath("//INPUT[@type='submit']")).click();
//			String message= driver.findElement(By.className("msgbox")).getText();
//		 	assertTrue(message.contains("Information entered into address book."));
//			Thread.sleep(100);
//		}
//		
//	}
	
	@Test(priority = 22)
	void testAddMultipleMultipleGroups() throws InterruptedException
	{
	Group grp = new Group(null, null, null);	
	ArrayList<Group> list = grp.readGroupData();
	for(int i=0;i<list.size();i++)
	{
		driver.findElement(By.xpath("//*[@id='nav']/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/input")).click();
		driver.findElement(By.xpath("//INPUT[@type='text']/self::INPUT")).sendKeys(list.get(i).getGroup_name());
		driver.findElement(By.xpath("//TEXTAREA[@name='group_header']/self::TEXTAREA")).sendKeys(list.get(i).getGroup_header());
		driver.findElement(By.xpath("//TEXTAREA[@name='group_footer']/self::TEXTAREA")).sendKeys(list.get(i).getGroup_footer());
		driver.findElement(By.xpath("//INPUT[@type='submit']/self::INPUT")).click();
		String message= driver.findElement(By.className("msgbox")).getText();
	 	assertTrue(message.contains("A new group has been entered into the address book."));
		
	}
	}
	

	

	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	public int getRecordsCountInCSV(String downloadPath, String csvFileName) {
		int lineNumberCount = 0;
		try {
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath =	downloadPath + System.getProperty("file.separator") + csvFileName;
				System.out.println(filePath);
				File file = new File(filePath);
				if (file.exists()) {
					System.out.println("File found :" +csvFileName);
					FileReader fr = new FileReader(file);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					//To remove the header
					lineNumberCount=lineNumberCount-1;
					System.out.println("Total number of lines found in csv : " + (lineNumberCount));
					linenumberreader.close();
				} else {
					System.out.println("File does not exists");
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return lineNumberCount;
	}

}
