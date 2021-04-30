package StepDefinitions;

import org.openqa.selenium.By;

import CumcuberPOM.POMBase;
import CumcuberPOM.variables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Page extends POMBase {


	@Given("I want to open login page")
	public void i_want_to_open_login_page() {
	    Connection();
	    visit(variables.GLOBAL_URL);
	}

	@And("I make sure login page is displayed")
	public void i_make_sure_login_page_is_displayed() {
		asserTrue(By.xpath("//a[@href=\"https://wordpress.org/\"]"));
	}

	@When("I type my username and password on login page")
	public void i_type_my_username_and_password_on_login_page() {
	    type("opensourcecms", By.xpath("//input[@id=\"user_login\"]"));
	    type("opensourcecms", By.xpath("//input[@id=\"user_pass\"]"));
	}

	@And("I press login buttom")
	public void i_press_login_buttom() {
	    click(By.xpath("//input[@id=\"wp-submit\"]"));
	}

	@Then("I assert I get the form successfully")
	public void i_assert_i_get_the_form_successfully() {
	    isDisplayed(By.xpath("//img[@class=\"avatar avatar-26 photo\"]"));
	}

	@And("I press logout buttom")
	public void i_press_logout_buttom() {
	    click(By.xpath("//a[@href=\"index.php\" and @class=\"wp-first-item current\"]"));
	}
	
}
