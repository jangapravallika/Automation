package flipkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Summarypage extends Baseclass{
	
	
	public Summarypage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")
	WebElement btncontinue;
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
	

}
