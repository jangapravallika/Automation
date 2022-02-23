package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Log4j.log;
import flipkart.Baseclass;
import flipkart.Homepage;
import flipkart.Login;
import flipkart.Orderpage;
import flipkart.Searchresultspage;
import resources.Dataprovider;

public class VerifyProduct extends Baseclass {

	public Homepage hp;
	public Searchresultspage sp;
	public Orderpage op;

	@BeforeMethod(groups={"Regression","smoke"})
	public void initialization() throws IOException {
		launch();
	}
	//@Parameters({"product"})
	@Test(dataProvider="getrdata",dataProviderClass=Dataprovider.class,groups="smoke")
	public void availabilityofproduct(String name,String password,String authentic) throws InterruptedException {
		log.startTestCase("availabilityofproductTest ");
		log.info("userlogin");
		Login l = new Login();
		hp = l.loginclick(name,password,authentic);
		log.info("search btn click ");
		sp = hp.searchbtnclick("shoes");
		log.info("product selected");
		Boolean flag = sp.verifyproductavailability();
		op = sp.selectproduct();
		log.info("productverified");
		Assert.assertTrue(flag);
		log.endTestCase("availabilityofproduct");

	}

	@AfterMethod(groups={"Regression","smoke"})
	public void closur() {
		driver.quit();
	}

}
