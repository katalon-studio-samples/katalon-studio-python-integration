import cucumber.api.cli.Main
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

public class Test {

	@Given("today is {iso-date}")
	public void today_is(Date date) {
	    System.out.println(date)
	}
	
	@When("I ask if {date} is in the past")
	public void I_ask_if_date_is_in_the_past(Date date) {
		System.out.println(date)
	}
	
	@Then("the result should be (.+)")
	public void the_result_should_be(String expectedResult) {
		System.out.println(date)
	}

}

//Main.main("-g", "", "C:\\data\\katalon-projects\\python-test\\Features")
Test.class
String[] argv = [ "-g", "", "C:\\data\\katalon-projects\\python-test\\Features" ].toArray();
ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
Main.run(argv, contextClassLoader);