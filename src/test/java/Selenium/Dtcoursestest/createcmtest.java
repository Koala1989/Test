package Selenium.Dtcoursestest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import src.main.java.base.TestBase;
import Selenium.Dtcourses.createCM;



public class createcmtest extends TestBase  {


 

	public boolean nxt;
    public String CourseMode_CourseName;
    String courseTitle=new String("contemporary");
    String IAC= courseTitle+"_IAC";
    String Startname=courseTitle+" CM";
    String dispname_onselectiac= courseTitle+"_disp".trim();
    
    

	
	@BeforeSuite

	public void setup() throws IOException{
		initialize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("http://u-gateway.cengage.com/gwy_deploytool_uqa/login/login.html");
		getobjectbyid("userIdbox").sendKeys("gateway_inst06@qaittest.com");
		getobjectbyid("pass").sendKeys("password");
		getobjectbyid("login").click();
		
		
				

	}

	@Test
	public void testSSOfrontdoorlaunch() throws InterruptedException{
		createCM course=new createCM(driver);
		course.dropdown();
		WebElement frontdoorlink = getObjectbyxpath("SSOfrondoor");
//Assert SSO front Door link 
		Assert.assertEquals("SSO Front Door", frontdoorlink.getText());

//		frontdoorlink.click();
//		Thread.sleep(25000);
//		String windowhandle;
//        windowhandle = driver.getWindowHandle();
//        System.out.println("name of the window is "+windowhandle);
//        driver.switchTo().window("FSR_CENGAGECOMPOOL_BEGIN_OBJ{'v':1}FSR_CENGAGECOMPOOL_END_OBJFSR_CENGAGECOMPOOL_BEGIN_BLOBFSR_CENGAGECOMPOOL_END_BLOB");
//        Assert.assertEquals(getObjectbyxpath("sso_launchlink"), "Instructor Resource Center");
//        driver.close();
//        driver.switchTo().window(windowhandle);
        

//Assert Next button state
        Assert.assertFalse("Failing at next button check", getobjectbyid("nxtbtn").isEnabled());
        Assert.assertTrue("Failing_checking prescence of Cancel button", getObjectbyxpath("cnclbutton_choose").isDisplayed());
        Assert.assertTrue("Failing_checking prescence of the Refresh button", getObjectbyxpath("refresh").isDisplayed());
        Assert.assertEquals("Failing at checking the name of modal window", "Course Wizard: Select Title", getObjectbyxpath("modal_selecttitle").getText());
        
	}

	@Test(dependsOnMethods="testSSOfrontdoorlaunch")	
	public void testChooseTitle() throws InterruptedException{
		createCM course=new createCM(driver);
		course.choosetitle(courseTitle);
		Thread.sleep(3000);
//Assert next button state after selecting a title
		nxt = getobjectbyid("nxtbtn").isEnabled();
		Assert.assertTrue(nxt);
		course.selectiac(IAC);
		Thread.sleep(1000);
//Assert Title name and IAC on select IAC screen
//		some  test
		
//		String crsname= Title.getProperty(dispname_onselectiac)+")";
//        String crsnameapr = getObjectbyxpath("titlename").getText();
//		System.out.println(crsnameapr);
//		Assert.assertEquals(crsname,crsnameapr);
//		Assert.assertEquals("IACexpected", "IACactual");
		getObjectbyxpath("backbtn_selectiac").click();
		Thread.sleep(1000);
		course.choosetitle(courseTitle);
		course.selectiac(IAC);
		

	}

	@Test(dependsOnMethods="testChooseTitle")
	public void testSelectIAC(){
		createCM course=new createCM(driver);
		 course.choosecoursetype();
		 boolean chkbox =getobjectbyid("ssochkbox").isEnabled();
		 String disp_name=getObjectbyxpath("disp_name").getText();
         System.out.println(disp_name);
//		 Assert.assertEquals("failed_name comparing_choose course type screen", Title.getProperty(courseTitle), disp_name);
		 Assert.assertFalse("Failed at asserting SSO checkbox state", chkbox);
		 String check=getobjectbyid("ssochkbox").getAttribute("checked");
		 Assert.assertEquals("Failed at checking the checkbox check/uncheck", "true", check);
		}
	
@Test(dependsOnMethods="testSelectIAC")
public void testNameTheCourse(){
	 createCM course =new createCM(driver);
	 course.NameTheCourse();
	 Assert.assertTrue("check book cover image icon", getObjectbyxpath("bookcover").isDisplayed());
	 course.generateCoursename(Startname);
	 course.NametheCourse();
	 CourseMode_CourseName= course.namethecourse;
	 
	
	 	 
}

@Test(dependsOnMethods="testNameTheCourse")
public void testSelectComponentsScreen() throws InterruptedException {
	 createCM course =new createCM(driver);
	 course.SelectComponentScreen();
	 Assert.assertEquals("Test the modal window name", "Course Wizard: Select Components for Course Mode", getObjectbyxpath("modal_sc").getText());
     getObjectbyxpath("pencilicon").click();
     getObjectbyxpath("input_comp").clear();
     getObjectbyxpath("input_comp").sendKeys("rsrc cntr");
     Thread.sleep(1000);
     getObjectbyxpath("click_nything").click();
     Thread.sleep(1000);
// Asserting Re-ordering     
     Point position= getObjectbyxpath("comp").getLocation();
     Thread.sleep(1000);
     getObjectbyxpath("muvbtn").click();
     Point position_moved = getObjectbyxpath("comp1").getLocation();
     Thread.sleep(2000);
     Assert.assertTrue(position.equals(position_moved));
     Point position_aftr=getObjectbyxpath("comp").getLocation();
     Assert.assertFalse("checking the postion after moving the component", position.equals(position_aftr));
     Assert.assertEquals("asserting name change in select component screen", "rsrc cntr", getObjectbyxpath("compname").getText());
	 
}

@Test(dependsOnMethods="testSelectComponentsScreen")

public void testConfirmationWindow() throws InterruptedException{
	createCM course =new createCM(driver);
	course.done();
	Thread.sleep(2000);
//	Assert.assertEquals("Assert the confiramtion window title name", "Course Wizard: Complete", getobjectbycss("completed_win").getText());
	Assert.assertEquals("Assert success message", "Course has been imported successfully.", getObjectbyxpath("suc_msg").getText());
	Thread.sleep(2000);
	System.out.println(CourseMode_CourseName+" [test class] has been successfully created,, don't get too cheesey, this is just the start ! there is a lot of work still remaining TODO");
	Thread.sleep(1000);
	getObjectbyxpath("cls_btn_cm").click();
	Thread.sleep(2000);
//	driver.close();
	
	
	
}


}




