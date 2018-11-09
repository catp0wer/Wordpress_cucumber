package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.ToolBarPage;

import java.io.IOException;


public class UISteps {
    WebDriver driver;
    LoginPage loginPage;
    ToolBarPage homePage;
    ConfigFileReader fileReader;
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);

        homePage = new ToolBarPage(driver);
        PageFactory.initElements(driver, homePage);

        fileReader = new ConfigFileReader();
    }


    @Given("^user navigates to Login page$")
    public void userNavigatesToPage() {
        loginPage.open();
    }

    @When("^user logs in with '(.*)' username and '(.*)' password$")
    public void userLogsInWithUsername(String name, String password) {
        loginPage.userLogin(name,password,driver);
    }

    @Then("^user is redirected to HomePage$")
    public void homeElementIsPresent(){
        homePage.isElementPresent(driver,homePage.expectedDashboardText,homePage.dashboardTitle);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
