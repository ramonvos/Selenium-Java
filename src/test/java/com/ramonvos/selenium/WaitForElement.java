package com.ramonvos.selenium;

import com.ramonvos.constants.Constants;
import com.ramonvos.logger.Reporter;
import com.ramonvos.webdriver.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement extends TestBase {

    private static WebDriverWait wait;

    public static void waitForElementClickable(WebElement element){
    try {
        wait = new WebDriverWait(TestBase.driver, Constants.DEFAULT_TIME_OUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));}
        catch (Exception ex)
        {
            Reporter.addStepsToException(ex);
        }
    }
    public static void waitForElementClickable(By locator){
        try{
            wait = new WebDriverWait(TestBase.driver, Constants.DEFAULT_TIME_OUT);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception ex){
            Reporter.addStepsToException(ex);
        }

    }


    public static void waitTextPresentInElement(WebElement element, String text){
        try{
            wait = new WebDriverWait(TestBase.driver, Constants.DEFAULT_TIME_OUT);
            wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        }catch (Exception ex){
            Reporter.addStepsToException(ex);
        }

    }

}
