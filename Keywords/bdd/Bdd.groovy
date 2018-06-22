package bdd

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

public class Bdd {

	@Given("today is 2011-01-20")
    public void today_is() {
        System.out.println("given")
    }
	
	@When("I ask if Jan 19, 2011 is in the past")
	public void I_ask_if_date_is_in_the_past() {
		System.out.println("when")
	}

	@Then("the result should be yes")
	public void the_result_should_be() {
		System.out.println("then")
	}
}
