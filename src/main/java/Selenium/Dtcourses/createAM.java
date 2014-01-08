package Selenium.Dtcourses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import src.main.java.base.TestBase;

public class createAM extends TestBase {


	private static int noofassignments =4; 
	public  static String coursename_AM;
	public  static String coursename_filter;
	WebDriver driver=null;
	
	public createAM (WebDriver driver){
		  this.driver=driver;
	  }
	

	 
	  public void createcourse (){ 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript("this.blur();if(justDateValidation()){createCourse('SCORM_1_2');}");
//		((JavascriptExecutor)driver).executeScript("this.blur();if(justDateValidation()){createCourse('SCORM_1_2');}");

		
	//click on the dropdown menu and choose a title--------------------------------------------------------------------

		
		Select select=new Select(driver.findElement(By.id("titleisbn10")));
		select.selectByVisibleText("Contemporary Marketing 2009 Update, 13th Edition(0-324-58021-5/978-0-324-58021-1)");

		driver.findElement(By.xpath("//*[@id='courseWizardNext']")).click();
		System.out.print("clicked");

		driver.findElement(By.xpath("//div[@id='courseWizardPage2']/parent::div//span[text()='Next']")).click();
		driver.findElement(By.id("assignmentMode")).click();
		driver.findElement(By.xpath("//div[@id='courseWizardPage3']/parent::div//span[text()='Next']")).click();
	   
		//Name the course screen----------------------------------------------------------------------------------------------
		   String timeStamp = new SimpleDateFormat("yyyyMMdd HHmmss").format(Calendar.getInstance().getTime());
		   coursename_AM= "Contemporary AM " + timeStamp + " priyadarshi";
		
		   driver.findElement(By.id("courseName")).sendKeys(coursename_AM);
	       driver.findElement(By.cssSelector(".matrix >tbody>tr:nth-child(3) >td >input")).sendKeys(coursename_AM);	
     	   driver.findElement(By.id("version")).sendKeys("123");
		   driver.findElement(By.xpath("//div[@id='courseWizardPage4']/parent::div//span[text()='Next']")).click();
		   driver.findElement(By.xpath("//*[@id='parent']/tbody/tr[1]/td[3]")).click();
		   driver.findElement(By.id("addFolder")).click();
		   
		   try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		   driver.findElement(By.xpath("//*[@id='child']/tbody/tr[1]/td[3]")).click();
		   try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   driver.findElement(By.id("addAssignment")).click();
		   try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           driver.findElement(By.xpath("//*[@id='chapters']/table/tbody/tr[2]/td")).click();
			
		for (int j = 1; j < noofassignments; j++) {
			
			driver.findElement(By.cssSelector(".matrix >tbody >tr:nth-child(2) >td > div >table >tbody >tr:nth-child(2) >td >table >tbody >tr >td >table:nth-child("+j+") >tbody >tr >td:nth-child(2) >input")).click();
		}
		driver.findElement(By.xpath("//div[@id='courseCreateAssignment']//parent::div//span[text()='OK']")).click();
		
		System.out.println("kick");
		
		
//		new WebDriverWait(DT, 30).until(ExpectedConditions.visibilityOf(DT.findElement(By.xpath("//div[@id='courseWizardPage4']/parent::div//span[text()='Done']"))));
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@id='courseWizardPage4']/parent::div//span[text()='Done']")).click();
		
		System.out.println("done");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
driver.findElement(By.xpath("//span[@id='ui-id-3']/parent::div/a")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		
		}
//		driver.findElement(By.id("displayName")).sendKeys(coursename_AM);
//		driver.findElement(By.id("submitFilterbtn")).click();
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	
//			coursename_filter = driver.findElement(By.cssSelector(".dataTables_wrapper >table >tbody >tr >td:nth-child(2) >a")).getText();
//			System.out.println(coursename_filter);
		
}
		
	}


