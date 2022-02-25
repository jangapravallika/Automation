package flipkart;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Actionsclass;

public class Searchresultspage extends Baseclass {
	

	public Searchresultspage() {
		PageFactory.initElements(getdriver(), this);
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
			performactions(getdriver());
		}
		return flag;

	}
	public Orderpage selectproduct() throws InterruptedException {
		shproduct.click();
		Thread.sleep(2000);
		Actionsclass a=new Actionsclass();
		String cw=a.window();
		getdriver().switchTo().window(cw);
		/*
		 * WebDriverWait wait=new WebDriverWait(getdriver(),Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null))
		 */
		return new Orderpage();
	}
	

	private void performactions(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
}
