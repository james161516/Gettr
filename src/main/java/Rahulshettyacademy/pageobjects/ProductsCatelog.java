package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductsCatelog extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductsCatelog (WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy (css=".offset-sm-1")
List<WebElement> products;
	
	@FindBy (css="button[routerlink='/dashboard/cart\']")
	WebElement cartbutton;
	
By productby = By.cssSelector("toast-container");
By list = By.cssSelector(".card-body button:last-of-type");
By toastmsg= By.id("toast-container");

	public List<WebElement> getProductslist()
	{
		invisibilityOfElementLocated(productby);
		return products;
	}
	
	public WebElement listofitems(String itemname)
	{
		WebElement item = getProductslist().stream().filter(products->products.
				findElement(By.cssSelector("b")).getText().equals(itemname)).findFirst().orElse(null);
		return item;
	}

	public void addtocart(String itemname)
	{
		WebElement item = listofitems(itemname);
		item.findElement(list).click();
		visibilityOfElementLocated(toastmsg);
	}
	public Mycart clickcartbutton()
	{
		cartbutton.click();
		Mycart mycart = new Mycart(driver);
		return mycart;
	}
}
