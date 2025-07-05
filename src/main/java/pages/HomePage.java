package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/main/div[3]/div/builder-section/div/div/div[4]/div/a/div/div[1]/img")
    private WebElement blazerElement;

    @FindBy(xpath = "//*[@id=\"CollectionProductGrid\"]/div[1]/product-item/div/form/div[1]/a/div/img")
    private WebElement linenBlazerElement;

    @FindBy(xpath = "//div[@class=\"WordSection1\"][2]/p[6]/span")
    private WebElement visibleNote;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public HomePage getBlazerElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", blazerElement);
        return this;
    }

    public HomePage getLinenBlazerElement() {
        linenBlazerElement.click();
        return this;
    }

    public String getVisibleNote() {
        return visibleNote.getText();
    }
}
