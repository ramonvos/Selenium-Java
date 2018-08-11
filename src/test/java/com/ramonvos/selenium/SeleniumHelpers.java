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
import java.lang.reflect.Method;


public class SeleniumHelpers extends TestBase {

    public static String elementName;
    public static void navigateGoToUrl(String url){

       driver.navigate().to(url);

        Reporter.addStepsToPass("navigateGoToUrl");

    }

    public static void typeInTextBox(WebElement element, String value){
        try {

            if (Utils.hasValue(value)){
            WaitForElement.waitForElementClickable(element);
            element.sendKeys(value);
            }else value = Utils.replaceEmptyValue(value);

            Reporter.addStepsToPass("Method => typeInTextBox - Element =>  " + Utils.getAttributeElement(element) +" - Valor => " + value);
        }catch (Exception ex){
            Reporter.addStepsToFail("FAIL " + ex.getMessage());
            Reporter.addStepsToException(ex);
        }

    }
    public static void clickButton(WebElement element){
    try {
            WaitForElement.waitForElementClickable(element);
            element.click();


            Reporter.addStepsToPass("Method => typeInTextBox - Element =>  " + Utils.getAttributeElement(element));
        }catch (Exception ex){
        Reporter.addStepsToFail("FAIL " + ex.getMessage());
        Reporter.addStepsToException(ex);
        }
    }

    public static void moveToElementAndClick(WebElement element){
        try {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().perform();


            Reporter.addStepsToPass("Method => moteToElementAndClick - Element =>  " + Utils.getAttributeElement(element));
    }catch (Exception ex){
            Reporter.addStepsToFail("FAIL " + ex.getMessage());
            Reporter.addStepsToException(ex);
    }


    }

    public static void executeJavaScript(String script)
    {try {
        JavascriptExecutor executor = ((JavascriptExecutor)driver);

        executor.executeScript(script);
        Reporter.addStepsToPass("Method => executeJavaScript - Script =>  " + script);
    }catch (Exception ex){
        Reporter.addStepsToFail("FAIL " + ex.getMessage());
        Reporter.addStepsToException(ex);
    }

}

    public static String takeScreenshot() {

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
