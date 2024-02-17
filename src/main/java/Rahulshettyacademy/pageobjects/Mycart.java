package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;

public class Mycart extends AbstractComponents {
	
WebDriver driver;
	
	public Mycart (WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy (css=".cartSection h3")
	List<WebElement> cartlist;
	
	@FindBy (css="ul[style='list-style-type: none;'] button")
	WebElement checkoutbutton;
	
	public List<WebElement> getProductslist()
	{
		return cartlist;
	}
	
	public boolean itemsincart(String cartItem)
	{
		boolean cart = getProductslist().stream().anyMatch(products -> products.getText().equalsIgnoreCase(cartItem));
		return cart;
	}
	
	public Payment checkout()
	{
		checkoutbutton.click();
		Payment payment = new Payment(driver);
		return payment;
	}
}
