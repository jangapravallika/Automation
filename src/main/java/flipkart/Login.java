package flipkart;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login extends Baseclass {
	Homepage home = new Homepage();

	public Login() {

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Please enter Password']")
	WebElement errorpwd;

	@FindBy(css = "input[class=\"_2IX_2- VJZDxU\"]")
	WebElement username;

	@FindBy(css = "input[type=\"password\"]")
	WebElement password;

	@FindBy(xpath = "//button[@type=\"submit\"]//span")
	WebElement login;

	@FindBy(xpath = "//span[text()='Your username or password is incorrect']")
	WebElement Error;

	@FindBy(css="span[class='_2YULOR']")
	WebElement er;
	/*
	 * public Boolean userverification(String name, String pwd) throws
	 * InterruptedException {
	 * 
	 * Boolean flag = Error.isDisplayed(); if (!flag) { loginclick(); } return flag;
	 * 
	 * }
	 */

	public Homepage loginclick(String name, String pwd, String register) throws InterruptedException {
		boolean flag;
		username.sendKeys(name);
		password.sendKeys(pwd);
		
		try
		{
		login.click();
		}catch(StaleElementReferenceException e)
		{
			performactions(driver);
		}
		if (register.contentEquals("registered user")) {
			flag = home.textbo().isDisplayed();
			Assert.assertTrue(flag);
		} else if(register.contentEquals("unregistered user")) {
		
			try
			{
			Assert.assertEquals(Error.getText(), "Your username or password is incorrect");
			}catch(NoSuchElementException e)
			{
				login.click();
			}
		}
		else if(register.contentEquals("bothwrong"))
		{
	
		
			Assert.assertEquals(er.getText(), "Please enter valid Email ID/Mobile number");
		}
		else if(register.contentEquals("nill "))
		{
			Assert.assertEquals(errorpwd.getText(), "Please enter Password");
		}
		Thread.sleep(5000);
		return new Homepage();

	}
	private void performactions(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

}
