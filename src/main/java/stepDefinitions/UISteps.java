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
import pages.PostPage;



public class UISteps {
    WebDriver driver;
    LoginPage loginPage;
    ToolBarPage homePage;
    ConfigFileReader fileReader;
    PostPage newPostPage;
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);

        homePage = new ToolBarPage(driver);
        PageFactory.initElements(driver, homePage);

        newPostPage = new PostPage(driver);
        PageFactory.initElements(driver, newPostPage);

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

    @When("^user clicks on Posts$")
    public void userClickOnPosts(){
        homePage.posts.click();
    }
    @And("^user click on Add new$")
    public void userClickOnAddNew(){
        homePage.newPostMenuItem.click();
    }
    @And("^user enter title$")
    public void userEnterTitle(){
        newPostPage.enterTitle();
    }

    @And("^user click publish$")
    public void userClickPublish(){
        newPostPage.publishButton.click();
    }

    @Then("^new post is publish$")
    public void newPostIsPublished(){
        newPostPage.isElementPresent(driver, newPostPage.expectedPostPublishedText,newPostPage.postStatus);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
