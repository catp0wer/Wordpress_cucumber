package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.ToolBarPage;
import pages.PostPage;
import testDataUtils.DataKey;
import testDataUtils.ScenarioContext;


public class UISteps {
    WebDriver driver;
    LoginPage loginPage;
    ToolBarPage homePage;
    ConfigFileReader fileReader;
    PostPage postPage;
    ScenarioContext scenarioContext = new ScenarioContext();
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);

        homePage = new ToolBarPage(driver);
        PageFactory.initElements(driver, homePage);

        postPage = new PostPage(driver);
        PageFactory.initElements(driver, postPage);

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

    @And("^user clicks on Add new$")
    public void userClickOnAddNew(){
        homePage.newPostMenuItem.click();
    }

    @And("^user enters title$")
    public void userEnterTitle(){
        scenarioContext.saveTestData(DataKey.ADDED_POST, postPage.enterText());
    }

    @And("^user saves post")
    public void userClickPublishOrUpdate(){
        postPage.click(postPage.publishButton);
    }

    @Then("^new post is publish$")
    public void newPostIsPublished(){
        postPage.isElementPresent(driver, postPage.expectedPostPublishedText,postPage.postStatus);
    }

    @And("^user finds and clicks the post in All posts$")
        public void userFindPost(){
        postPage.AllPosts.click();
        postPage.findPost((String)scenarioContext.getTestData(DataKey.ADDED_POST));
    }

    @Then("^user is redirected to edit page$")
    public void userIsRedirectedToEditPage(){
        postPage.isElementPresent(driver,postPage.expectedEditPostPageTitle,postPage.editPostTitlePage);
    }

    @When("^user updates the title$")
    public void userUpdatesTitle(){
        postPage.clearField(postPage.postTitle);
        scenarioContext.saveTestData(DataKey.ADDED_POST, postPage.enterText());
    }

    @Then("^title is updated")
    public void verifyTitleUpdated(){
        postPage.click(postPage.viewPost);
        postPage.isElementPresent(driver,(String)scenarioContext.getTestData(DataKey.ADDED_POST),postPage.titleOnPublishedPage);
    }
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
