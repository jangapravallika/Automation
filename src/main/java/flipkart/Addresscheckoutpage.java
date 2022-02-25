package flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addresscheckoutpage extends Baseclass{
	
	public Addresscheckoutpage()
	{
		PageFactory.initElements(getdriver(), this);
	}


	@FindBy(xpath="//button[text()='Deliver Here']")
	WebElement address;
	
	
	
	public Summarypage selectaddress() throws InterruptedException
	{
		address.click();
			Thread.sleep(3000);
			
		
		
		return new Summarypage();
	}
}
