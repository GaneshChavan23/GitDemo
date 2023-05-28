package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	WebDriver driver;

	public MyAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email_create")
	WebElement createemailid;
	

	@FindBy(id = "SubmitCreate")
	WebElement Submitemailid;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement Submit;
	

	public void CreateEmailid(String email)
	{
		createemailid.sendKeys(email);
	}
	
	public void ClickSubmitEmailid()
	{
		Submitemailid.click();
	}
	
	public void Username(String username)
	{
		email.sendKeys(username);
	}
	public void Password(String Password)
	{
		password.sendKeys(Password);
	}
	public void Submit()
	{
		Submit.click();
	}

}
