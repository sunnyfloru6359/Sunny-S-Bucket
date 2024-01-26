package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.POM.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver initilizeBrowser() throws IOException {
		
		Properties prop= new Properties();
    	FileInputStream fis= new FileInputStream("C:\\Users\\Sunny\\eclipse-workspace\\Seleniumdemo1\\src\\resources\\GlobalData.properties");
		
		
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("firefox")) {
			
		System.setProperty("webdriver.firefox.driver", "C:\\Selenium webdriver\\FireFoxDriver\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		 driver= new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome")){
			ChromeOptions options= new ChromeOptions();
			options.addArguments("headless");
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			 driver= new ChromeDriver(options);
		}
		
		
		
		return driver;
	}
	@BeforeMethod
	public LandingPage launchApp() throws IOException {
		
		driver=initilizeBrowser();
		 lp= new LandingPage(driver);
		lp.goTo("https://rahulshettyacademy.com/client");
		return lp;
	}
	
	
	@AfterMethod
	public void closeApp() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
}
