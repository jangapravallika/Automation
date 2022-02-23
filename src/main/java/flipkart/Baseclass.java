package flipkart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.ExtentManager;

/**
 * @author Administrator
 *
 */

public class Baseclass {


	public Properties prop;
	public static WebDriver driver;
	
	
	@BeforeSuite(groups={"Regression","smoke"})
	public void setreports()
	{
		DOMConfigurator.configure("log4j2.xml");
		ExtentManager.setExtent();
	}
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver;
	}
	
	public void launch() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\resources\\flipkart\\config.properties";		
		FileInputStream fp=new FileInputStream(path);
		prop=new Properties();
		prop.load(fp);
		String Browsername=prop.getProperty("browser");
		if(Browsername.contains("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		prop.getProperty("url");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterSuite(groups={"Regression","smoke"})
	public void later()
	{
		ExtentManager.endReport();
	}
	
	
	
	
	
	
}
