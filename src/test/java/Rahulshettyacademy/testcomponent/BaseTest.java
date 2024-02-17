package Rahulshettyacademy.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Rahulshettyacademy\\Resources\\Globaldata.properties");
		prop.load(fis);
		
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
		if(browsername.contains("chrome"))
				{
			ChromeOptions options = new ChromeOptions();
			if(browsername.contains("headless"))
			{
				options.addArguments("headless");
			}
	    driver = new ChromeDriver(options);
	    driver.manage().window().setSize(new Dimension (1440,900));
		
	}
		else if(browsername.equalsIgnoreCase("edge"))
		{
		 driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsontoHashmap(String Filepath) throws IOException
	{
		//Read Json to String
		String jsoncontent = FileUtils.readFileToString(new File (Filepath), StandardCharsets.UTF_8);
		//String to Hashmap using Jackson databind dependency
		
		ObjectMapper mapper = new ObjectMapper();
		List <HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	}
	
	public String getSCreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return (System.getProperty("user.dir")+ testCaseName + ".png");
	}
	
	@BeforeMethod (alwaysRun = true)
	public LandingPage launchapplication() throws IOException
	{
		driver = initializeDriver();
		 landingpage = new LandingPage(driver);
		landingpage.Goto();
		return landingpage;
	}
@AfterMethod (alwaysRun = true)
public void closedriver()
{
	driver.close();
}
}
