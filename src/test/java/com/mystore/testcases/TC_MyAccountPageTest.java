package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.VerifyMyAccountPageTitle;
import com.mystore.pageobject.indexPage;

public class TC_MyAccountPageTest extends BaseClass{
	@Test(priority = 1)
	public void VerifyRegistrationAndLogin(){
		//open url
		
		
		indexPage index=new indexPage(driver);
		index.ClickOnSignIn();
		
		MyAccount pg=new MyAccount(driver);
		pg.CreateEmailid("abc15@gmail.com");
		pg.ClickSubmitEmailid();
		
		AccountCreationPage acp=new AccountCreationPage(driver);
		acp.SelectCustGender();
		acp.CustFirstName("Ganesh");
		acp.CustLastName("Chavan");
		acp.CustEmail("ganesh23@gmail.com");
		acp.Custpassword("ganesh@123");
		acp.SubmitButton();
		
		VerifyMyAccountPageTitle vpt =new VerifyMyAccountPageTitle(driver);
		String username=vpt.VerifyCustTitle();
		Assert.assertEquals("Ganesh Chavan", username);
		vpt.Logout();
		
		
		
	}
	@Test(priority = 2)
	public void VerifyLogin()
	{
		indexPage index=new indexPage(driver);
		index.ClickOnSignIn();
		
		MyAccount pg=new MyAccount(driver);
		pg.Username("ganesh15@gmail.com");
		pg.Password("ganesh@123");
		pg.Submit();
		VerifyMyAccountPageTitle vpt =new VerifyMyAccountPageTitle(driver);
		String username=vpt.VerifyCustTitle();
		if(username.equals("Ganesh Chavan"))
		{
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
}
