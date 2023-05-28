package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyMyAccountPageTitle {
	WebDriver driver;

	public VerifyMyAccountPageTitle(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='header_user_info'] [1]")
	WebElement usernameTitle;
	
	@FindBy(css = "a[title='Log me out']")
	WebElement logout;
	
	
	
	public String VerifyCustTitle()
	{
		String text=usernameTitle.getText();
		return text;
	
	}
	
	public void Logout()
	{
		logout.click();
	}
}
