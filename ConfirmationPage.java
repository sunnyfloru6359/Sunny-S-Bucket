package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(css=".hero-primary")
WebElement textmsg;
	
	public String getMessage() {
		
		String txt=textmsg.getText();
		return txt;
	}
	
	
	
	
}
