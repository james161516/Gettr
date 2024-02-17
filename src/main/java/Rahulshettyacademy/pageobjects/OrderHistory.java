package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;

public class OrderHistory extends AbstractComponents {
	
WebDriver driver;
	
	public OrderHistory (WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy (xpath="//tr/td[2]")
	List<WebElement> orderlistname;
	
	
	public List<WebElement> getOrderslist()
	{
		return orderlistname;
	}
	
	public boolean itemsinorder(String cartItem)
	{
		boolean cart = getOrderslist().stream().anyMatch(products -> products.getText().equalsIgnoreCase(cartItem));
		return cart;
	}
}
