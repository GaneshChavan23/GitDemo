package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps
{
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("inside speps--> user is on login page");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("inside steps--> user enter usrname and password");
	}

	@And("user click on login button")
	public void user_click_on_login_button() {
		System.out.println("inside speps--> user clicks on login button");

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("inside speps--> user should navigated on home page");

	}
}
