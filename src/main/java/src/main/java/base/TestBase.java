package src.main.java.base;

	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import junit.framework.Assert;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import base.TestUtils;

	//import reader.Read;


	public class TestBase 
	{
		
		
		public static Properties CONFIG=null;
		public static Properties Title=null;
		public static Properties OR=null;
		public static FirefoxProfile profile = null;

		public static WebDriver driver=null;
		
		public static EventFiringWebDriver dr =null;
		public static boolean isLoggedIn=false;

		
		
		public void initialize() throws IOException
		{
			if(driver==null)
			{
				// Initialize Config properties
				CONFIG = new Properties();
				FileInputStream FIS = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
				CONFIG.load(FIS);
			
				// Initialize OR properties
				OR = new Properties();
				FIS = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\OR.properties");
				OR.load(FIS);
			
				//Initialize Title properties
				Title = new Properties();
				FIS = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\Title.properties");
				Title.load(FIS);
				//System.setProperty("webdriver.firefox.bin","PATH TO FIREFOX EXE");
				
//				profile = new FirefoxProfile();

				// Initialize WebDriver
				if(CONFIG.getProperty("Browser").equals("Firefox"))
				{
//					System.setProperty("webdriver.firefox.bin", "C:\\Users\\priyadarshibharat\\AppData\\Local\\Mozilla Firefox\\FF20\\firefox.exe");
					System.setProperty("webdriver.firefox.bin", "C:\\Users\\priyadarshibharat\\AppData\\Local\\Mozilla Firefox\\FF21\\firefox.exe");
					driver = new FirefoxDriver();
//					driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Users\\priyadarshibharat\\AppData\\Local\\Mozilla Firefox\\FF20\\firefox.exe")), profile);
					
				}
				else if(CONFIG.getProperty("Browser").equals("IE"))
				{
					driver = new InternetExplorerDriver();
				}
			
				// Initialize EventFiringWebDriver
				dr = new EventFiringWebDriver(driver);
				
				// Initialize Implicit Wait
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			} //closing if(driver=null)	
		} //closing initialize()

		
		
		public static WebElement getObjectbyxpath(String XpathKey)
		{
			try
			{
				return driver.findElement(By.xpath(OR.getProperty(XpathKey)));
			}
			catch(Throwable t)
			{
				TestUtils.takesscreenshot(XpathKey);
				Assert.assertTrue(t.getMessage(), false);
				return null;
			}
		}
		public static WebElement getobjectbyid(String id){
			try{
				return driver.findElement(By.id(OR.getProperty(id)));
			}
			catch (Throwable e)
			{
				TestUtils.takesscreenshot(id);
				Assert.assertTrue(e.getMessage(), false);
				return null;
			}
		}
		public static WebElement getobjectbycss(String css){
			try{
				return driver.findElement(By.cssSelector(OR.getProperty(css)));
			}
			catch (Throwable f)
			{
				TestUtils.takesscreenshot(css);
				Assert.assertTrue(f.getMessage(), false);
				return null;
			}
		}
		
	}



