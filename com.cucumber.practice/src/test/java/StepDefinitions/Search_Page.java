package StepDefinitions;

import org.openqa.selenium.By;

import CumcuberPOM.POMBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search_Page extends POMBase {
	
	@Given("I press pages option")
	public void i_press_pages_option() {
	    click(By.xpath("//a[@href=\"edit.php?post_type=page\" and @class=\"wp-has-submenu wp-has-current-submenu wp-menu-open menu-top menu-icon-page\"]"));
	}

	@And("I make sure Pages page is displayed")
	public void i_make_sure_pages_page_is_displayed() {
	    isDisplayed(By.xpath("//input[@id=\"post-search-input\"]"));
	}

	@When("I type a page on the serch pages field")
	public void i_type_a_page_on_the_serch_pages_field() {
	    type("Startseite",By.xpath("//input[@id=\"post-search-input\"]"));
	}

	@And("I press search pages buttom")
	public void i_press_search_pages_buttom() {
	    click(By.xpath("//input[@id=\"search-submit\"]"));
	}

	@Then("I see the results")
	public void i_see_the_results() {
		isDisplayed(By.xpath("//input[@id=\"post-search-input\"]"));
	}
	
}
