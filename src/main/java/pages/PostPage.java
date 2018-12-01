package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "(//a[contains(@href,'edit.php')])[2]")
    public WebElement AllPosts;

    @FindBy(xpath = "//h1[@class='wp-heading-inline']")
    public WebElement editPostTitlePage;

    @FindBy(xpath="//a[text()='View post']")
    public WebElement viewPost;

    @FindBy(xpath="//h1[@class='entry-title']")
    public WebElement titleOnPublishedPage;

    public String expectedEditPostPageTitle = "Edit Post";

    private WebElement xpathPath(String title){
        return driver.findElement(By.xpath("(//a[@class='row-title' and contains(@aria-label,'"+ title+"')])"));
    }
    public void findPost(String title){
        this.xpathPath(title).click();
    }

    public String enterText(){
        String randomText = RandomStringUtils.randomAlphabetic(15).toLowerCase();
        postTitle.sendKeys(randomText);
        return randomText;
    }

    public String expectedPostPublishedText = "Published";

    public void isElementPresent(WebDriver driver, String expectedText, WebElement element){
        pageObject.onThePage(element,driver);
        assertEquals(expectedText, element.getText());
    }

    public void click(WebElement element){
        element.click();
    }

    public void clearField(WebElement element){
        element.clear();
    }
}
