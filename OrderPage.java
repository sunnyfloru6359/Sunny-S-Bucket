package com.POM;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	
	public  OrderPage(WebDriver driver) {
		
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordertext;
	public Boolean orderHistoryCheck(String product) {
		
		
		Boolean match=ordertext.stream().anyMatch(a->a.getText().equalsIgnoreCase(product));
		return match;
		
	
	
}
}

