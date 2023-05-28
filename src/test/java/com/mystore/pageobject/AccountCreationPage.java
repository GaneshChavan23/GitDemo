package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {
	WebDriver driver;

	public AccountCreationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_gender1")
	WebElement Gender;
	
	@FindBy(id = "customer_firstname")
	WebElement custFname;
	
	@FindBy(id = "customer_lastname")
	WebElement custLname;
	
	@FindBy(id = "email")
	WebElement custEmail;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "submitAccount")
	WebElement submitButton;
	
	public void SelectCustGender()
	{
		Gender.click();
	}
	
	public void CustFirstName(String custfname)
	{
		custFname.sendKeys(custfname);
	}
	
	public void CustLastName(String custlname)
	{
		custLname.sendKeys(custlname);
	}
	public void CustEmail(String custemail)
	{
		custEmail.clear();
		custEmail.sendKeys(custemail);
	}
	public void Custpassword(String custpassword)
	{
		password.sendKeys(custpassword);
	}
	
	public void SubmitButton()
	{
		submitButton.click();
	}
	
}
