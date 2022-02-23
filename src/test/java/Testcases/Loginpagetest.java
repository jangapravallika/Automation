package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Log4j.log;
import flipkart.Baseclass;
import flipkart.Homepage;
import flipkart.Login;
import resources.Dataprovider;

public class Loginpagetest extends Baseclass {
	public Login l;
	public Homepage hp;

	@BeforeMethod(groups={"Regression","smoke"})
	public void initialization() throws IOException {
		launch();
	}

	@Test(dataProvider="getdata",dataProviderClass=Dataprovider.class,groups={"Regression","smoke"})
	public void loginpage(String name,String password,String authentication) throws InterruptedException {
		log.startTestCase("loginpage");
		log.info("userlogin");
		l = new Login();
		hp=l.loginclick(name, password,authentication);
		log.endTestCase("loginpage");
	}

	@AfterMethod(groups={"Regression","smoke"})
	public void closur() {
		driver.quit();
	}

}
