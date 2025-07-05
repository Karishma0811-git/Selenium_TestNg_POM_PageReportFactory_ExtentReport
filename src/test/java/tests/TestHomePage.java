package tests;

import listeners.ExtentTestNGITestListener;
import org.testng.annotations.Listeners;
import utils.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchItem;
import java.util.List;
@Listeners(ExtentTestNGITestListener.class)
public class TestHomePage {
    private WebDriver driver;
    private BaseClass baseClass = new BaseClass();

    @BeforeClass
    public void setBaseClass() {
        driver = baseClass.browserInitalize("chrome", "https://int.zigzag.lk/");
    }

    @Test(priority = 0)
    public void testLoginFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ClickCreateAccountButton();
        loginPage.getClickSignUp();
        loginPage.enterFirstName("abc").enterLastName("def").enterEmail("testinggroup35@gmail.com").enterPassword("Testing@123").getClickSignUp();
    }

    @Test(priority = 1)
    public void addTocartProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.getBlazerElement();
        homePage.getLinenBlazerElement();

        String actualNote = "Note: Product Colour May Slightly Vary Due To Photographic Lighting Sources Or Your Monitor Setting.";
        String expectedNote = homePage.getVisibleNote();
        Assert.assertEquals(actualNote, expectedNote);
    }

    @Test(priority = 2)
    public void testClickSearchButton() {
        SearchItem searchItem = new SearchItem(driver);
        searchItem.clickSearchButton();
        searchItem.enterTextInSearchBox("Dresses");
        List<WebElement> results = searchItem.getSearchResults();

        for (WebElement result : results) {
            System.out.println("Product Name: " + result.getText());
            Assert.assertTrue(result.getText().toLowerCase().contains("dress"));


        }

    }

    @AfterClass
    public void quit() {
        baseClass.tearDown();

    }


}
