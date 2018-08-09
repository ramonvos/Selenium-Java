package com.ramonvos.selenium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ValidationResult {

    public static void AssertTextInElement(WebElement element ,String text){
        WaitForElement.WaitTextPresentInElement(element,text);
        Assert.assertEquals(element.getText(), text);
    }
    public static void AssertElementContainsText(WebElement element ,String textPart){

        Assert.assertTrue(element.getText().contains(textPart));
    }

    public static void ElementIsVisible(WebElement element ){

        Assert.assertTrue(element.isDisplayed());
    }


}
