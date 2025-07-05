package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@data-js-popup-button=\"account\"]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//a[@data-js-trigger-id=\"popup-button-sign-up\"]")
    private WebElement clickSignUp;

    @FindBy(xpath = "//*[@id=\"PopupFirstName\"]")
    private WebElement textBox_firstName;

    @FindBy(xpath = "//*[@id=\"PopupLastName\"]")
    private WebElement textBox_lastName;

    @FindBy(xpath = "//*[@id=\"PopupEmail\"]")
    private WebElement textBox_email;

    @FindBy(xpath = "//*[@id=\"PopupCreatePassword\"]")
    private WebElement textBox_password;

   /* @FindBy(xpath = "//*[@id=\"popup_customer_login\"]/input[3]")
    private WebElement loginButton;*/

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public LoginPage ClickCreateAccountButton() {
        createAccountButton.click();
        return this;
    }

    public LoginPage enterFirstName(String username) {
        textBox_firstName.sendKeys(username);
        return this;
    }

    public LoginPage enterLastName(String lastname) {
        textBox_lastName.sendKeys(lastname);
        return this;
    }
    /*public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }*/

    public LoginPage getClickSignUp() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickSignUp);
        return this;
    }

    public LoginPage enterEmail(String email) {
        textBox_email.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        textBox_password.sendKeys(password);
        return this;
    }
}
