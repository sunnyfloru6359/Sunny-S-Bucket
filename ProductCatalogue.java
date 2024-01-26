package com.POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(By.cssSelector(".mb-3"));
		return products;
		
	}
	public WebElement getproductByName(String productName) {
		

		WebElement prod=products.stream().filter(product->product.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div/h5/b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		return prod;

	}
	
	
	public void addProducttoCart(String productName) throws InterruptedException {
		
		WebElement prod=getproductByName(productName);
		prod.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
		Thread.sleep(1000);
		waitForElementToAppear(By.cssSelector("#toast-container"));
		Thread.sleep(2000);
		
		
	
	
	}
	

	
	

	
	
	
}
