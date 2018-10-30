package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolBarPage {

    @FindBy(xpath = "//a[contains(@href,'post-new.php')][@class='current']")
    private WebElement newPost;


    public WebElement newPost() {
        return newPost;
    }
}