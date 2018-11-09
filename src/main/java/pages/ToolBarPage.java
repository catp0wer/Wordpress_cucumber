package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class ToolBarPage extends PageObject{
    private PageObject pageObject = new PageObject();
    private WebDriver driver;
    public ToolBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[contains(@href,'post-new.php')][@class='current']")
    private WebElement newPostMenuItem;

    @FindBy(xpath = "//a[contains(@href,'index.php')][@class='wp-first-item current']")
    private WebElement homeMenuItem;

    @FindBy(xpath = ("(//h1)[1]"))
    public WebElement dashboardTitle;

    public String expectedDashboardText = "Dashboard";

    public void isElementPresent(WebDriver driver, String expectedText, WebElement element){
        pageObject.onThePage(element,driver);
        assertEquals(expectedText, element.getText());
    }
}



