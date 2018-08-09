package com.ramonvos.selenium;

import com.ramonvos.webdriver.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    private static WebDriverWait wait;

    public static void WaitForElementClickable(WebElement element){

        wait = new WebDriverWait(TestBase.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void WaitForElementClickable(By locator){
        try{
            wait = new WebDriverWait(TestBase.driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (NoSuchElementException ex){

        }

    }


    public static void WaitTextPresentInElement(WebElement element, String text){
        try{
            wait = new WebDriverWait(TestBase.driver, 30);
            wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        }catch (NoSuchElementException ex){

        }

    }

}
