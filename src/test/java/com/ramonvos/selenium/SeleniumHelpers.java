package com.ramonvos.selenium;

import com.ramonvos.webdriver.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class SeleniumHelpers {

    public static void TypeInTextBox(WebElement element, String value){

        WaitForElement.WaitForElementClickable(element);
        element.sendKeys(value);

    }
    public static void ClickButton(WebElement element){

        // GETElment()
        //try catch

        WaitForElement.WaitForElementClickable(element);
        element.click();

        //Logerr
    }

    public static void MoteToElementAndClick(WebElement element){
        Actions act = new Actions(TestBase.driver);
        act.moveToElement(element).click().perform();

    }
}
