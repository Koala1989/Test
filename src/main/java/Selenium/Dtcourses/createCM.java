package Selenium.Dtcourses;

import java.text.SimpleDateFormat;

import src.main.java.base.TestBase;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;


public class createCM extends TestBase {
  
   public static WebDriver driver;
   public static String Titlename;
  @SuppressWarnings("static-access")
public createCM (WebDriver driver){
	  this.driver=driver;
	    }
   
 public String namethecourse;
 
  public void  dropdown() throws InterruptedException {


		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript("this.blur();if(justDateValidation()){createCourse('SCORM_1_2');}");
		Thread.sleep(5000);

  }
		
  public void selectLTI() throws InterruptedException{
	  ((JavascriptExecutor)driver).executeScript("this.blur();if(justDateValidation()){createCourse('MINDLINK_1_0');}");
	  Thread.sleep(5000);
  }
  
  public void selectInline() throws InterruptedException{
	  ((JavascriptExecutor)driver).executeScript("this.blur();if(justDateValidation()){createCourse('INLINE_CONTENT_1_0');}");
	  Thread.sleep(5000);
  }
	//click on the dropdown menu and choose a title--------------------------------------------------------------------

	    public void choosetitle(String Titlename){
		
			Select select=new Select(driver.findElement(By.id("titleisbn10")));
			select.selectByVisibleText(Title.getProperty(Titlename));

	    }

	    public void selectiac(String IAC){
		

	// Select IAC---------------------------------------------------------------------------------------------------------
	      driver.findElement(By.id("courseWizardNext")).click();
		  try{  Thread.sleep(3000);
		  }catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	      
		  System.out.println(".//*[@value='"+Title.getProperty(IAC)+"']");
		   driver.findElement(By.xpath(".//*[@value='"+Title.getProperty(IAC)+"']")).click();
	      
	    }
	    
	    public void choosecoursetype () {
	    	
	    	driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	  
	// Select Course type/Mode--------------------------------------------------------------------------------------------
	      try{  Thread.sleep(3000);
		  }catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    }
	    public void NameTheCourse(){ 
	      driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	      try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    }
	    
	    public String generateCoursename(String Startname){
		
	    	String timeStamp = new SimpleDateFormat("yyyyMMdd HHmmss").format(Calendar.getInstance().getTime());
	   namethecourse= Startname+" "+timeStamp+" Priyadarshi";
	   return namethecourse;
	    
	    }
	    	
	    public void NametheCourse(){
	   driver.findElement(By.id("courseName")).sendKeys(namethecourse);
	   driver.findElement(By.name("displayName")).sendKeys(namethecourse);
	   driver.findElement(By.id("version")).sendKeys("123");
	  
	    }
	    public void SelectComponentScreen(){
	    	 driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	  	   try{  Thread.sleep(3000);
	  		  }catch (Exception e) {
	  			
	  		}
	   
	    }
	    public void done(){
	    	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	 	   
			   try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   String crs=namethecourse;
	   System.out.print(crs+" has been successfully created,, don't get too cheesey, this is just the start ! there is a lot of work still remaining TODO");

		}

}
