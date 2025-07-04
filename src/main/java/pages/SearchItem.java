package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.time.Duration;
import java.util.List;

public class SearchItem {
    private WebDriver driver;

    @FindBy(xpath = "//a[@data-js-popup-button=\"navigation\"]")
    private WebElement searchButton;

    @FindBy(id = "Search")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"zigzag-global\"]/div[7]/div[2]/div/div[2]/div/div[2]")
    private List<WebElement> searchResults;

    public SearchItem(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public SearchItem clickSearchButton() {
        searchButton.click();
        return this;
    }

    public SearchItem enterTextInSearchBox(String searchbox) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        searchBox.sendKeys(searchbox);
        Actions action = new Actions(driver);
        action.keyDown(Keys.ENTER);
        action.build().perform();
        return this;
    }


    public List<WebElement> getSearchResults() {
        return searchResults;
    }

}
