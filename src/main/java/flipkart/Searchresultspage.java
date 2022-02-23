package flipkart;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Actionsclass;

public class Searchresultspage extends Baseclass {

	public Searchresultspage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="a[title='Running Shoes For Men']")
	WebElement shproduct;

	@FindBy(css = "img[alt='ACCEPT ORGANIC Organic Yellow Toor/Arhar Dal (Split)']")
	WebElement product;

	public void selectshoe() throws InterruptedException {
		shproduct.click();
		
	}

	public boolean verifyproductavailability() {
		 Boolean flag=false;
		try {
		 flag=shproduct.isDisplayed();
		}catch(NoSuchElementException e)
		{
			performactions(driver);
		}
		return flag;

	}
	public Orderpage selectproduct() throws InterruptedException {
		shproduct.click();
		Thread.sleep(3000);
		Actionsclass a=new Actionsclass();
		String cw=a.window();
		driver.switchTo().window(cw);
		return new Orderpage();
	}
	public Orderpage product() throws InterruptedException {
		try
		{
		Thread.sleep(5000);
		product.click();
		}catch(NoSuchElementException e)
		{
			performactions(driver);
		}
		
		return new Orderpage();
	}

	private void performactions(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
}
