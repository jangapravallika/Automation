package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Log4j.log;
import flipkart.Addresscheckoutpage;
import flipkart.Baseclass;
import flipkart.Homepage;
import flipkart.Login;
import flipkart.Orderpage;
import flipkart.Searchresultspage;
import flipkart.Summarypage;
import resources.Dataprovider;

public class Productavailability extends Baseclass {

	public Homepage hp;
	public Searchresultspage sp;
	public Orderpage op;
	public Addresscheckoutpage acp;
	public Summarypage sumpage;
	
	
	@BeforeMethod(groups={"Regression","smoke"})
	public void initialization() throws IOException 
	{
	launch();
	}
	
//@Parameters({"product"})
	@Test(groups="Regression",dataProvider="getrdata",dataProviderClass=Dataprovider.class)
	public void product(String name,String password,String authen ) throws InterruptedException {
		
		
	log.startTestCase("end to end ");
	log.info("userlogin");
		Login l = new Login();
		hp = l.loginclick(name,password,authen);
		log.info("search btn click ");
		sp = hp.searchbtnclick("shoes");
		op=sp.selectproduct();
		
		log.info("select size");
		op.selectsize();
		log.info("place order");
		acp=op.orderclick();
		log.info("adress select");
		sumpage=acp.selectaddress();
		sumpage.clickcontinue();
		log.endTestCase("end to end test case end");
		
	
		
	}
	@AfterMethod(groups={"Regression","smoke"})
	public void closur() 
	{
		getdriver().quit();
	}
}
