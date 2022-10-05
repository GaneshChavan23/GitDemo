package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
 
public class GoogleSearchSteps 
{
	WebDriver driver=null;
	@SuppressWarnings("deprecation")
	@Given("browser is open")
	public void browser_is_open()
	{
String projectPath=System.getProperty("user.dir");
System.out.println("ProjectPath is:"+projectPath);
		System.out.println("inside steps--> browser is open");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/driver/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() throws InterruptedException
	{
	driver.navigate().to("https://www.google.com/");
	Thread.sleep(3000);
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException 
	{
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("toolsqa");	
	Thread.sleep(3000);
	}

	@And("hits enter button")
	public void hits_enter_button() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

	}

	@Then("user is navigated to search rsults")
	public void user_is_navigated_to_search_rsults() throws InterruptedException 
	{
		System.out.println("inside here-->user should navigated on search results");
		driver.getPageSource().contains("Tools QA");
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
