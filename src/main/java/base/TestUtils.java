package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import src.main.java.base.TestBase;



public class TestUtils extends TestBase {
	
	
	
	public static void takesscreenshot(String filename)
	{
		File srcFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+".jpg"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	

}
