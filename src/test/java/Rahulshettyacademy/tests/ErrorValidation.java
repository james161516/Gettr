package Rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Rahulshettyacademy.pageobjects.LandingPage;
import Rahulshettyacademy.pageobjects.Mycart;
import Rahulshettyacademy.pageobjects.OrderConfirmation;
import Rahulshettyacademy.pageobjects.Payment;
import Rahulshettyacademy.pageobjects.ProductsCatelog;
import Rahulshettyacademy.testcomponent.BaseTest;
import junit.framework.Assert;

public class ErrorValidation extends BaseTest {

	@Test (groups = {"Errorvalidation"}, retryAnalyzer=Rahulshettyacademy.testcomponent.Retry.class)
	public void LoginError() throws IOException {
		landingpage.loginpage("manojmgowda47@gmail.com", "Indium@1234");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());

	}
	
	@Test(groups = {"Errorvalidation"})
	public void Itemexists()
	{
		String product = "IPHONE 13 PRO";
		ProductsCatelog productscatelog =landingpage.loginpage("manojmgowda47@gmail.com", "Indium@123");
		List<WebElement> lists = productscatelog.getProductslist();
		productscatelog.addtocart(product);
		Mycart mycart =productscatelog.clickcartbutton();
	boolean match = mycart.itemsincart("IPHONE 14 PRO");
	Assert.assertFalse(match);
	
		
	}
}
