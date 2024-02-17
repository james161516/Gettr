package Rahulshettyacademy.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Registration {

	public static void main(String[] args) {
	 WebDriver driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 driver.get("https://rahulshettyacademy.com/client");
	 driver.manage().window().maximize();
	 driver.findElement(By.cssSelector("a[href='/client/auth/register']")).click();
	 driver.findElement(By.id("firstName")).sendKeys("Manoja");
	 driver.findElement(By.id("lastName")).sendKeys("MHH");
	 driver.findElement(By.id("userEmail")).sendKeys("manojmgowda471@gmail.com");
	 //userMobile
	 driver.findElement(By.id("userMobile")).sendKeys("7353092951");
	 driver.findElement(By.xpath("//select[@formcontrolname='occupation']/option[3]")).click();
	 driver.findElement(By.cssSelector("input[value='Male']")).click();
	 driver.findElement(By.id("userPassword")).sendKeys("Indium@123");
	 driver.findElement(By.id("confirmPassword")).sendKeys("Indium@123");
	 driver.findElement(By.cssSelector("input[formcontrolname='required']")).click();
	 driver.findElement(By.cssSelector("input[value='Register']")).click();
	String text= driver.findElement(By.cssSelector("h1[class='headcolor']")).getText();
	Assert.assertEquals("Account Created Successfully", text);

	}

}
