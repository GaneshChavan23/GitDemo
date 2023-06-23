package com.TestCases;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.Utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	public static Logger log;
	
	ReadConfig r=new ReadConfig();
	
	String url=r.GetUrl();
	String uname=r.GrtUnmae();
	String pass=r.Password();
	@BeforeClass
	public void Setup()
	{
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 log=LogManager.getLogger("GitProjectDemoX Person");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 driver.get(url);
	 log.info("Browser Open");
	 
	 driver.findElement(By.id("user-name")).sendKeys(uname);
	 log.info("Enter uname");
	 
	 driver.findElement(By.id("password")).sendKeys(pass);
	 log.info("Enter password");
	 
	 driver.findElement(By.id("login-button")).click();
	 log.info("click on Submit");
	
	}
	@AfterClass
	public void TearDown()
	{
		driver.close();
	}
	
	public void CaptureScreenShot(WebDriver driver,String testName) throws IOException {
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir") + "//Screenshot//" + testName + ".png");
		FileUtils.copyFile(src, dest);
	}
}
