package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	
	public LandingPage (WebDriver driver)
	{
		super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement userpassword;
		
		@FindBy(id="login")
		WebElement loginbutton;
		
		@FindBy (css="div[aria-label='Incorrect email or password.']")
		WebElement errormessage;

		public ProductsCatelog loginpage(String email, String password)
{
	userEmail.sendKeys(email);
	userpassword.sendKeys(password);
	loginbutton.click();
	ProductsCatelog productscatelog = new ProductsCatelog(driver);
	return productscatelog;
	
}
public void Goto()
{
	driver.get("https://rahulshettyacademy.com/client");
	
}

public String getErrorMessage()
{
	visibilityOfElement(errormessage);
	return errormessage.getText();
}

}

