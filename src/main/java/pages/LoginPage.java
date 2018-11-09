package pages;

import dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class LoginPage extends PageObject{
    private PageObject pageObject = new PageObject();
    private ConfigFileReader fileReader= new ConfigFileReader();
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[contains(@class,'button form-button is-primary')]")
    private WebElement continue_login;

    @FindBy(xpath = "//input[@id='usernameOrEmail']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPassword;

    public void open(){
        try {
            driver.navigate().to(fileReader.getProp("URL"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userLogin(String username, String password,WebDriver driver) {
        //wait until the element is visible
        pageObject.onThePage(userName,driver);
        userName.sendKeys(username);
        continue_login.click();
        //wait until the element is visible
        pageObject.onThePage(userPassword,driver);
        userPassword.sendKeys(password);
        continue_login.click();
    }
}

