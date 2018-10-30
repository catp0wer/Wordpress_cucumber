package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//button[contains(@class,'button form-button is-primary')]")
    private WebElement continue_login;

    @FindBy(xpath = "//input[@id='usernameOrEmail']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPassword;

//    public WebElement continue_login() {
//        return continue_login;
//    }

    // toolbarpage?
    public void userLogin(String username, String password) {
        userName.sendKeys(username);
        continue_login.click();
        userPassword.sendKeys(password);
        continue_login.click();
        //return new ToolBarPage();
    }
}

