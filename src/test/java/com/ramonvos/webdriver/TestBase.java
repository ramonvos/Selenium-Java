package com.ramonvos.webdriver;

import com.ramonvos.constants.BrowserType;
import com.ramonvos.constants.Constants;
import com.ramonvos.logger.Reporter;
import com.ramonvos.selenium.SeleniumHelpers;

import com.ramonvos.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {


    protected static WebDriver driver;
    protected static int status;
    @BeforeSuite
    public static void setUp(){

        getBrowser(Constants.BROWSER);
        driver.navigate().to(Constants.URL_BASE);
        //Reporter.createNewReport();


    }

    @BeforeTest
    public void beforeTest(ITestContext  context){



    }

    @BeforeMethod
    public void beforeMethod(ITestContext context){

        //ITestNGMethod[] tests = context.getAllTestMethods();
        //String testName = tests[0].getMethodName();
        //Reporter.createTest(testName);
    }

    @AfterMethod
    public void afterMethod(ITestContext context,ITestResult  result){
        //ITestNGMethod[] tests = context.getAllTestMethods();
        //String testName = tests[0].getMethodName();


        try {
            if (result.getStatus() == ITestResult.SUCCESS) {

                //Do something here
                //Reporter.addStepsToPass(result.getStatus()+" - passed **********");
                status = result.getStatus();

            } //else //SeleniumHelpers.takeScreenshot("FAIL");
            //Reporter.addStepsToFail(result.getStatus()+" - FAIL **********");
            status = result.getStatus();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @AfterTest
    public void afterTest() {
        if (status == 1) {
            //Reporter.addScreeshot(SeleniumHelpers.takeScreenshot("SUCCESS"));
        }//else {
        //Reporter.addScreeshot(SeleniumHelpers.takeScreenshot("FAIL"));
          //  }
    }


    @AfterSuite
    public static void tearDown(){
        //Reporter.generateReporter();
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
