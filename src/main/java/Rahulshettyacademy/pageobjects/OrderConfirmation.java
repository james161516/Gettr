package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class OrderConfirmation extends AbstractComponents {
WebDriver driver;
	
	public OrderConfirmation  (WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className="hero-primary")
	WebElement confirmation;
	
	
	public String Confirmationtext()
	{
		String thanks= confirmation.getText();
		return thanks;
	}
	
	
}
