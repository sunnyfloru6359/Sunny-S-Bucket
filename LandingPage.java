package com.POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userpass;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalogue loginApp(String email,String password) {
		
		userEmail.sendKeys(email);
		userpass.sendKeys(password);
		submit.click();
		
		ProductCatalogue product_catalogue= new ProductCatalogue(driver);
		return product_catalogue;
		
	}
	
	public void goTo(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		
	}

	
	
	
}
