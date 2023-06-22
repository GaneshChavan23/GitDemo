package com.mystore.testcases;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public static Logger logger;
	@BeforeClass
	public void OpenBrowser() throws FileNotFoundException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger = LogManager.getLogger("MyStore1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		logger.info("Browser Open");
	}

	@AfterClass
	public void tearDown() {
		// driver.close();
		// driver.quit();
		logger.info("Browser close");
	}
}
