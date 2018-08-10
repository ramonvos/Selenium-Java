package com.ramonvos.selenium;

import com.ramonvos.logger.Reporter;
import com.ramonvos.utilities.Utils;
import com.ramonvos.webdriver.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;


public class SeleniumHelpers extends TestBase {


    public static void navigateGoToUrl(String url){

       driver.navigate().to(url);

        Reporter.addStepsToPass(Utils.getCurrentMethodName());

    }

    public static void typeInTextBox(WebElement element, String value){

        WaitForElement.waitForElementClickable(element);
        element.sendKeys(value);

        Reporter.addStepsToPass(Utils.getCurrentMethodName());

    }
    public static void clickButton(WebElement element){

        // GETElment()
        //try catch

        WaitForElement.waitForElementClickable(element);
        element.click();

        Reporter.addStepsToPass(Utils.getCurrentMethodName());
    }

    public static void moteToElementAndClick(WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).click().perform();
        Reporter.addStepsToPass(Utils.getCurrentMethodName());

    }

    public static void executeJavaScript(String script)
    {
        JavascriptExecutor executor = ((JavascriptExecutor)driver);

        executor.executeScript(script);
    }

    public static String takeScreenshot(String status) {

        String fileName = "C:\\Selenium\\Screenshots\\screenshot-"+status+"-test "+Utils.getCurrentTimeStamp()+ ".png";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(fileName));

            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return fileName;
        }


    }
}
