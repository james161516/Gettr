package Rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Rahulshettyacademy.pageobjects.LandingPage;
import Rahulshettyacademy.pageobjects.Mycart;
import Rahulshettyacademy.pageobjects.OrderConfirmation;
import Rahulshettyacademy.pageobjects.Payment;
import Rahulshettyacademy.pageobjects.ProductsCatelog;
import Rahulshettyacademy.testcomponent.BaseTest;
import junit.framework.Assert;

public class SubmitOrder extends BaseTest {
	String product = "IPHONE 13 PRO";
	@Test(dataProvider="getData")
	public void submitorder(HashMap<String,String> input) throws IOException
	{
		ProductsCatelog productscatelog =landingpage.loginpage(input.get("email"), input.get("password"));
		List<WebElement> lists = productscatelog.getProductslist();
		productscatelog.addtocart(input.get("product"));
		Mycart mycart =productscatelog.clickcartbutton();
		List<WebElement> cartitemlist = mycart.getProductslist();
		Payment payment = mycart.checkout();
		payment.selectcountry("Ind");
		OrderConfirmation confirmation=	payment.Placeorderbtn();
		String  confirmationmessage = confirmation.Confirmationtext();
		Assert.assertTrue(confirmationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
	
@Test(dependsOnMethods = {"submitorder"})
	
	public void Orderlist()
	{
		ProductsCatelog productscatelog =landingpage.loginpage("manojmgowda47@gmail.com", "Indium@123");
		Rahulshettyacademy.pageobjects.OrderHistory orderhistory =productscatelog.clickOrderHistory();
		Assert.assertTrue(orderhistory.itemsinorder(product)); 
	}


	

	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String, String>> data =getJsontoHashmap(System.getProperty("user.dir")+"\\src\\test\\java\\Rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}
	
}
	
	
	
	//public Object[][] getData()
	//{
	//	return new Object[][] {{"manojmgowda47@gmail.com","Indium@123","ZARA COAT 3"}, {"manojmgowda43@gmail.com","Indium@123","IPHONE 13 PRO"}};
	//}
	//}


//HashMap<String,String> map = new HashMap<String,String>();
//map.put("email", "manojmgowda47@gmail.com");
//map.put("password", "Indium@123");
//map.put("product", "IPHONE 13 PRO");
//HashMap<String,String> map1 = new HashMap<String,String>();
//map1.put("email", "manojmgowda43@gmail.com");
//map1.put("password", "Indium@123");
//map1.put("product", "ZARA COAT 3");
	
