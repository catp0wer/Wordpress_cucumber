package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;

public class PostPage extends PageObject {

    private PageObject pageObject = new PageObject();
    private WebDriver driver;
    public PostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//input[@id='title']")
    public WebElement postTitle;

    @FindBy(xpath = "//input[@id='publish']")
    public WebElement publishButton;

    @FindBy(xpath = "//div[@id='message']/p")
    public WebElement postPublished;

    @FindBy(xpath = "//span[@id='post-status-display']")
    public WebElement postStatus;

    String randomTitle = RandomStringUtils.randomAlphabetic(8);
    public void enterTitle(){
        postTitle.sendKeys(randomTitle);
    }

    public String expectedPostPublishedText = "Published";

    public void isElementPresent(WebDriver driver, String expectedText, WebElement element){
        pageObject.onThePage(element,driver);
        assertEquals(expectedText, element.getText());
    }
}
