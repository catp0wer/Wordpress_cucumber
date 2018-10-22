package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UISteps {

    @Given("^user opens wordpress$")
    public void userNavigatesToPage() {
        System.out.println("user opens wordpress");


    }

    @When("^user clicks on Add$")
    public void userLogsClickAdd() {
        System.out.println("user clicks on Add");

    }


    @Then("^new post is added$")
    public void newPostisAdded() {
        System.out.println("new post is added");

    }
}
