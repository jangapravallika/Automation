package flipkart;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Baseclass{

;
	/*
	 * public WebDriver driver; public Homepage(WebDriver driver) {
	 * this.driver=driver; }
	 */
	public Homepage()
	{
		PageFactory.initElements(getdriver(), this);
	}
	
	@FindBy(css="div[class='_3qX0zy']")
	WebElement logo;
	
	@FindBy(name="q")
	WebElement search;
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	WebElement searchbtn;
	public WebElement textbo() {
		return search;
	}
	public Searchresultspage searchbtnclick(String item) throws InterruptedException
	{
		try {
		search.sendKeys(item);
		searchbtn.click();
		Thread.sleep(3000);
		
		}catch(StaleElementReferenceException e)
		{
			performactions(getdriver());
		}
		return new Searchresultspage();
	}
public boolean verifylogo() {
	 
	return logo.isDisplayed();
	
}
	private void performactions(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	
}
