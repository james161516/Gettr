package Rahulshettyacademy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Ordering;

import Rahulshettyacademy.pageobjects.OrderHistory;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy (css="button[routerlink='/dashboard/myorders']")
	WebElement orderHistorybutton;
	
	
public void invisibilityOfElementLocated(By findBy)
{
	WebDriverWait m = new WebDriverWait(driver, Duration.ofSeconds(2));
	m.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
}

public void visibilityOfElementLocated(By findBy)
{
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));
	w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
}

public void visibilityOfElement (WebElement Findby)
{
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));
	w.until(ExpectedConditions.visibilityOf(Findby));
}
	
public OrderHistory clickOrderHistory()
{
	orderHistorybutton.click();
	OrderHistory orderhistory = new OrderHistory(driver);
	return  orderhistory;
}


}
