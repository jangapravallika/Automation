package flipkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderpage extends Baseclass{

	public Orderpage()
	{
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(linkText="8")
	WebElement size;
	
	@FindBy(css="[class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
	WebElement order;
	
	public void selectsize()
	{
		size.click();
	}
	
	public Addresscheckoutpage orderclick() throws InterruptedException
	{
		Thread.sleep(10);
		order.click();
		return new Addresscheckoutpage();
	}
}
