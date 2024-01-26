package com.POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponent;

public class CheckOut extends AbstractComponent {

	
	WebDriver driver;
	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="(//button[contains(@class,'ta-item')])[2]")
	WebElement checkoutbtn;
	
	public void ClickCheckOut() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		checkoutbtn.click();
	}
	public ConfirmationPage Submit() {
		CartPage cp= new CartPage(driver);
		WebElement submitButton=cp.waitforElementtoInteractable(By.cssSelector(".action__submit"));
		
		submitButton.click();
		ConfirmationPage confirmpage=new ConfirmationPage(driver);
		return confirmpage;
	}
	
	
	
	
}
