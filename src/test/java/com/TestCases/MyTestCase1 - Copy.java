package com.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObject.DashBoard;



public class MyTestCase1 extends BaseClass{
	@Test
	public void VerifyLogin() throws IOException {
		System.out.println("Ganesh");
		Assert.assertTrue(true);
		CaptureScreenShot(driver, "Login");
		
		DashBoard d=new DashBoard(driver);
		d.ClickonAdd();
		log.info("Click On Add Product");
		Assert.assertTrue(true);
		CaptureScreenShot(driver, "AddProduct");
		
		d.ClickonCheckOut();
		log.info("Click On CheckOut");
		Assert.assertTrue(true);
		CaptureScreenShot(driver, "Click on Checkout 1");
		
	}
}
