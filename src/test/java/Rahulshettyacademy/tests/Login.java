package Rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Login {

	public static void main(String[] args) {
		String email = "manojmgowda47@gmail.com";
		String password = "Indium@123";
		String product = "IPHONE 13 PRO";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		WebDriverWait m = new WebDriverWait(driver, Duration.ofSeconds(2));
		m.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		List<WebElement> prod = driver.findElements(By.cssSelector(".offset-sm-1"));
		WebElement item = prod.stream()
				.filter(products -> products.findElement(By.cssSelector("b")).getText().equals(product)).findFirst()
				.orElse(null);
		item.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));

		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart\']")).click();
		
		List<WebElement> itemslist = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean cart = itemslist.stream().anyMatch(products -> products.getText().equalsIgnoreCase(product));
		Assert.assertTrue(cart);
		driver.findElement(By.cssSelector("ul[style='list-style-type: none;'] button")).click();
		driver.findElement(By.cssSelector("div[class='form-group'] input")).sendKeys("Ind");
		List<WebElement> countr = driver.findElements(By.cssSelector("section [class*='ta-results'] button"));
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(2));
		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ta-results")));
		for (WebElement option : countr) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(3));
		w2.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ta-results")));
		driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']")).click();

		String thanks = driver.findElement(By.className("hero-primary")).getText();
		Assert.assertTrue(thanks.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	//	.assertEquals("THANKYOU FOR THE ORDER.", thanks);
		driver.close();

	}
}
