package Sunny;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.AbstractComponents.AbstractComponent;
import com.POM.CartPage;
import com.POM.CheckOut;
import com.POM.ConfirmationPage;
import com.POM.LandingPage;
import com.POM.OrderPage;
import com.POM.ProductCatalogue;

import tests.BaseTest;

import static org.testng.Assert.assertEquals;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
public class StandAloneTest extends BaseTest {


	String productName="ZARA COAT 3";
	@Test(dataProvider="getData")
	public void Practice(HashMap<String,String> map) throws InterruptedException, IOException  {
		
		ProductCatalogue product_catalogue=lp.loginApp(map.get("email"),map.get("password"));
		product_catalogue.getProductList();
		product_catalogue.addProducttoCart(map.get("productname"));
		CartPage cp=product_catalogue.gotoCartPage();
		Boolean match=cp.verifyProduct(map.get("productname"));
		Assert.assertTrue(match);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,100)");	
		cp.myCartCheckout();		
		CheckOut co=cp.placeOrder();
		cp.waitForElementToAppear(By.cssSelector(".ta-results"));
		Thread.sleep(500);
		cp.scrollPage();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(500);
		ConfirmationPage confirmpage=co.Submit();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String confirmMessage =confirmpage.getMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}
	
	@Test(dependsOnMethods= {"Practice"})
	//@Test(alwaysRun=true,dataProvider="getData")
	public void OrderHistory(HashMap<String,String> map) throws InterruptedException {
		
		ProductCatalogue product_catalogue=lp.loginApp(map.get("email"), map.get("password"));
		
		OrderPage op=product_catalogue.goToOrderPage();
		Boolean match=op.orderHistoryCheck(map.get("productname"));
		
	Assert.assertTrue(match);
		
		
	}
	@DataProvider
	public Object getData() {
		HashMap<String,String> map= new HashMap<>();
		map.put("email", "sunnysolanki6359@gmail.com");
		map.put("password", "Sunny@123");
		map.put("productname", "ZARA COAT 3");
		
		HashMap<String,String> map1= new HashMap<>();
		map1.put("email", "test@gmail.com");
		map1.put("password", "test123");
		map1.put("productname", "ADIDAS ORIGINAL");
	
		return new Object[][] {{map},{map1}};
		
	}

}
