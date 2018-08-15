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
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


public class SeleniumHelpers extends TestBase {

    public static String elementName;
    public static void navigateGoToUrl(String url){

       driver.navigate().to(url);

        Reporter.addStepsToPass("navigateGoToUrl => "+ url);

    }

    public static void typeInTextBox(WebElement element, String value){
        try {

            if (Utils.hasValue(value)){
            WaitForElement.waitForElementClickable(element);
            element.sendKeys(value);
            }else value = Utils.replaceEmptyValue(value);

            Reporter.addStepsToPass("Method => typeInTextBox - Element =>  " + Utils.getAttributeElement(element) +" - Value => " + value);
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


            Reporter.addStepsToPass("Method => moveToElementAndClick - Element =>  " + Utils.getAttributeElement(element));
    }catch (Exception ex){
            Reporter.addStepsToFail("FAIL " + ex.getMessage());
            Reporter.addStepsToException(ex);
    }


    }

    public static void selectDropDownList(WebElement element, String value){
        try {

            if (Utils.hasValue(value)){
                WaitForElement.waitForElementClickable(element);

                new Select(element).selectByVisibleText(value);

            }else value = Utils.replaceEmptyValue(value);

            Reporter.addStepsToPass("Method => selectDropDownList - Element =>  " + Utils.getAttributeElement(element) +" - Value => " + value);
        }catch (Exception ex){
            Reporter.addStepsToFail("FAIL " + ex.getMessage());
            Reporter.addStepsToException(ex);
        }

    }

    public static void executeJavaScript(String script)
    {
        try {
        JavascriptExecutor executor = ((JavascriptExecutor)driver);
        executor.executeScript(script);

        Reporter.addStepsToPass("Method => executeJavaScript - Script =>  " + script);

    }catch (Exception ex){
        Reporter.addStepsToFail("FAIL " + ex.getMessage());
        Reporter.addStepsToException(ex);
    }

}

    public static String takeScreenshot() {
        String pathProject = Utils.getCurrentProjectPath();
        String fileName = pathProject+"\\output\\screenshots\\screenshot-test "+Utils.getCurrentTimeStamp()+ ".png";
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
