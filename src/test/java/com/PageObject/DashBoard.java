package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {

	WebDriver driver;
	public DashBoard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//button[@id='add-to-cart-sauce-labs-backpack'])[1]")
	WebElement addproduct;
	
	@FindBy(xpath = "(//a[@class='shopping_cart_link'])[1]")
	WebElement clickonchekout;
	
	
			
	public void ClickonAdd() {
		addproduct.click();
	}
	public void ClickonCheckOut() {
		clickonchekout.click();
	}
}
