package com.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.POM.CartPage;
import com.POM.OrderPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AbstractComponent {
	
	WebDriver driver;

	
	
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
  
	public void scrollPage() {
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,250)");
	}

	public void waitForElementToAppear(By findBy) {

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}

	
	public CartPage gotoCartPage() {
	
		WebElement cartHeader=driver.findElement(By.cssSelector("[routerlink*='cart']"));
		cartHeader.click();
		CartPage cp=new CartPage(driver);
		return cp;
			}
	
	public void waitForElementToDisappear()  {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));
	}
	public WebElement waitForElementToClickable(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		WebElement a=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(findBy)));
		return a;
	}
	public WebElement waitforElementtoInteractable(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		WebElement a=wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		return a;
		
	}
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orders;
public OrderPage goToOrderPage() {
	
	
	orders.click();
	OrderPage op= new OrderPage(driver);
	return op;
	
}
	
	
}
