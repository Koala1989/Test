package Selenium.Dtcoursestest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Selenium.Dtcourses.createAM;
import src.main.java.base.TestBase;


public class createAMtest extends TestBase {
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

public void createAsgnmntMode(){
	
createAM course =new createAM(driver);
course.createcourse();
driver.close();

}

	
	
	
	
	
	
}
