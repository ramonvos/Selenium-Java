package com.ramonvos.webdriver;

import com.ramonvos.constants.BrowserType;
import com.ramonvos.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

public class TestBase {


    public static WebDriver driver;
    @BeforeClass
    public void InitializeDriver(){

        if(driver == null){

            GetBrowser(Constants.BROWSER);

            TestBase.driver.navigate().to(Constants.URL_BASE);
        }

    }

    public void GetBrowser(String browser){
        if(browser.equals(BrowserType.CHROME_DRIVER.toString())){
            driver = new ChromeDriver(GetChromeOptions());
        }
        else if(browser.equals(BrowserType.FIREFOX_DRIVER.toString())){
            driver = new FirefoxDriver(GetFirefoxOptions());
        }

    }


    public ChromeOptions GetChromeOptions(){

        System.setProperty("webdriver.chrome.driver", Constants.PATH_CHROME);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if (Constants.CHROME_HEADLESS == "true"){
            options.addArguments("headless");
        }

        return options;
    }

    public FirefoxOptions GetFirefoxOptions(){

        System.setProperty("webdriver.gecko.driver", Constants.PATH_FIREFOX);
        FirefoxOptions options = new FirefoxOptions();
        return options;
    }

    @AfterClass
    public void CloseDriver(){
        driver.close();
    }

}
