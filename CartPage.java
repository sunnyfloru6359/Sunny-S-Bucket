package com.POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponent;



public class CartPage extends AbstractComponent {
	
	
	WebDriver driver;
	
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public boolean verifyProduct(String productName) {

		List<WebElement> items=driver.findElements(By.cssSelector(".cart h3"));
	Boolean match=items.stream().anyMatch(a->a.getText().equalsIgnoreCase(productName));
	
	return match;
	}
	
	public void myCartCheckout() throws InterruptedException {
		Thread.sleep(1000);
		AbstractComponent ac= new AbstractComponent(driver);
		WebElement abc=ac.waitForElementToClickable(By.cssSelector(".totalRow button"));
		abc.click();
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	public CheckOut placeOrder()  {
		
		country.sendKeys("india");
		
		
		CheckOut co= new CheckOut(driver);
		return co;
	}
	
	
	
	
	
}
