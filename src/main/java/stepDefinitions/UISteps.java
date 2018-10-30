package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.ToolBarPage;

import java.util.concurrent.TimeUnit;


public class UISteps {

    WebDriver driver = null;

    @Given("^user navigates to Login page$")

    public void userNavigatesToPage() {
        driver = new FirefoxDriver();
        driver.navigate().to("https://catp0wer150470290.wordpress.com/wp-admin/");
    }

    @When("^user logs in with '(.*)' username and '(.*)' password$")
    public void userLogsInWithUsername(String name, String password) {
        LoginPage lg=new LoginPage();
        PageFactory.initElements(driver, lg);
        lg.userLogin(name,password);
    }
//    @Given("^user opens wordpress$")
//
//    public void userNavigatesToPage() {
//        driver = new FirefoxDriver();
//        driver.navigate().to("https://catp0wer150470290.wordpress.com/wp-admin/");
//    }
//    @When("^user hover over Posts and clicks on Add$")
//    public void userClickAdd() {
//        System.out.println("user clicks on Add");
//    }
//    @And("^user enter title$")
//    public void userEnterTitle() {
//        System.out.println("user clicks on Add");
//    }
//    @And("^user click publish$")
//    public void userClicPublish() {
//        System.out.println("user clicks on Add");
//    }
//
//    @Then("^new post is added$")
//    public void newPostisAdded() {
//        System.out.println("new post is added");
//
//    }
}
