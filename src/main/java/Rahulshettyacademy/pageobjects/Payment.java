package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class Payment extends AbstractComponents {
WebDriver driver;
	
	public Payment (WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy (css="div[class='form-group'] input")
	WebElement country;
	
	@FindBy (css="section [class*='ta-results'] button")
	List<WebElement> countrylistdropdown;
	
	@FindBy (css="a[class='btnn action__submit ng-star-inserted']")
	WebElement placeorder;
	
	By countrylist = By.className("ta-results");
	By invisibleofcountrylist = By.className("ta-results");
	
	public void selectcountry(String countryname)
	{
		country.sendKeys(countryname);
		visibilityOfElementLocated(countrylist);
		
		for (WebElement option : countrylistdropdown) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
	}
	
	public OrderConfirmation Placeorderbtn()
	{
		
		invisibilityOfElementLocated(invisibleofcountrylist);
		placeorder.click();
		OrderConfirmation confirmation = new OrderConfirmation(driver);
		return confirmation;
	}
			

}
