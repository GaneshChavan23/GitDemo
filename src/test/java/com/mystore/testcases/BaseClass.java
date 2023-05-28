package com.mystore.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfigProp;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfigProp readconf=new ReadConfigProp();
	String url=readconf.geturl();
	String broswer=readconf.getBrowser();
	public static WebDriver driver;
	@BeforeClass
	public void SetUp()
	{
		switch (broswer.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;

		default:
			driver=null;
			break;
		}
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.close();
	}
}
