package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BaseClass {

    private WebDriver driver;

    public WebDriver browserInitalize(String browser, String url){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "iexplorer":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

        }
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
    public void tearDown(){
        driver.quit();
    }
}
