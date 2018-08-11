package com.ramonvos.webdriver;
import com.ramonvos.constants.BrowserType;
import com.ramonvos.constants.Constants;
import com.ramonvos.logger.Reporter;
import com.ramonvos.selenium.SeleniumHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver driver;
    protected static int status;
    @BeforeSuite
    public static void setUp(){

        getBrowser(Constants.BROWSER);
        driver.navigate().to(Constants.URL_BASE);
        Reporter.createNewReport();
    }

    @BeforeTest
    public void beforeTest(){

    }

    @BeforeMethod
    public void beforeMethod(Method method, ITestContext context){

        String testName = method.getName();
        String className = getClass().getName().substring(19);
        Reporter.createTest(testName,className);
    }

    @AfterMethod
    public void afterMethod(ITestResult  result){
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                Reporter.addScreeshot(SeleniumHelpers.takeScreenshot());
            }else {
                Reporter.addScreeshot(SeleniumHelpers.takeScreenshot());
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @AfterTest
    public void afterTest() {
    }


    @AfterSuite
    public static void tearDown(){
        Reporter.generateReporter();
        driver.close();

    }


    public static void getBrowser(String browser){
        if(browser.equals(BrowserType.CHROME_DRIVER.toString())){
            driver = new ChromeDriver(getChromeOptions());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else if(browser.equals(BrowserType.FIREFOX_DRIVER.toString())){
            driver = new FirefoxDriver(getFirefoxOptions());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }


    public static ChromeOptions getChromeOptions(){

        System.setProperty("webdriver.chrome.driver", Constants.PATH_CHROME);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if (Constants.CHROME_HEADLESS == "true"){
            options.addArguments("headless");
        }

        return options;
    }

    public static FirefoxOptions getFirefoxOptions(){

        System.setProperty("webdriver.gecko.driver", Constants.PATH_FIREFOX);
        FirefoxOptions options = new FirefoxOptions();
        return options;
    }

}
