package flipkart;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Orderpage extends Baseclass{
	

	public Orderpage()
	{
		PageFactory.initElements(getdriver(), this);
	}

	
	
	@FindBy(linkText="8")
	WebElement size;
	
	@FindBy(css="[class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
	WebElement order;
	
	public void selectsize() throws InterruptedException
	{
		Thread.sleep(1000);
		try {
		size.click();
		}catch(StaleElementReferenceException e)
		{
			performactions(getdriver());
		}
	}
	
	private void performactions(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public Addresscheckoutpage orderclick() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(getdriver(),Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(order));
		order.click();
		Thread.sleep(2000);
		return new Addresscheckoutpage();
	}
}
