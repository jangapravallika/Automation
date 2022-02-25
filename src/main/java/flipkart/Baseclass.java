package flipkart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	@BeforeSuite(groups={"Regression","smoke"})
	public void setreports()
	{
		DOMConfigurator.configure("log4j2.xml");
		ExtentManager.setExtent();
	}
	
	public static  WebDriver getdriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	public void launch() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\resources\\flipkart\\config.properties";		
		FileInputStream fp=new FileInputStream(path);
		prop=new Properties();
		prop.load(fp);
		//String Browsername=prop.getProperty("browser");
		String Browsername=System.getProperty("browser");
		if(Browsername.contains("Chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			
			if(Browsername.contains("headless"))
			{
				options.addArguments("--headless");
			}
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\chromedriver.exe");
			
			options.addArguments("window-size=1920,1080");
			 driver.set(new ChromeDriver(options));
		}else if(Browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Public\\Documents\\geckodriver.exe");
			driver.set(new FirefoxDriver());
			
		}else if(Browsername.equals("Microsoftedge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Public\\Documents\\msedgedriver.exe");
			driver.set( new EdgeDriver());

		}
		prop.getProperty("url");
		getdriver().manage().window().maximize();
		getdriver().get(prop.getProperty("url"));
		
		getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	@AfterSuite(groups={"Regression","smoke"})
	public void later()
	{
		ExtentManager.endReport();
	}
	
	
	
	
	
	
}
