package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

public class ToolBarPage extends PageObject{
    private PageObject pageObject = new PageObject();
    private WebDriver driver;
    public ToolBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'index.php')][@class='wp-first-item current']")
    private WebElement homeMenuItem;

    @FindBy(xpath = ("(//h1)[1]"))
    public WebElement dashboardTitle;

    @FindBy(xpath = "(//a[contains(@href,'edit.php')]/div[contains(@class,'wp-menu-name')])[1]")
    public WebElement posts;

    @FindBy(xpath = "(//a[contains(@href,'post-new.php')])[1]")
    public WebElement newPostMenuItem;



    public String expectedDashboardText = "Dashboard";

    public void isElementPresent(WebDriver driver, String expectedText, WebElement element){
        pageObject.onThePage(element,driver);
        assertEquals(expectedText, element.getText());
    }
}



