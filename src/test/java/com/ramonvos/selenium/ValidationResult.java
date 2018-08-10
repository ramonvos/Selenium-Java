package com.ramonvos.selenium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ValidationResult {

    public static void assertTextInElement(WebElement element, String text)  {

        try {
        WaitForElement.waitTextPresentInElement(element,text);
        Assert.assertEquals(element.getText(), text);

        SeleniumHelpers.takeScreenshot("SUCCESS");
    }catch (Exception ex){
        SeleniumHelpers.takeScreenshot("FAIL");
    }

    }
    public static void AssertElementContainsText(WebElement element ,String textPart) {
        try {
            Assert.assertTrue(element.getText().contains(textPart));

            SeleniumHelpers.takeScreenshot("SUCCESS");
        } catch (Exception ex) {
            SeleniumHelpers.takeScreenshot("FAIL");
        }
    }

    public static void elementIsVisible(WebElement element ){
        try {
            Assert.assertTrue(element.isDisplayed());

            SeleniumHelpers.takeScreenshot("SUCCESS");
        }catch (Exception ex){
            SeleniumHelpers.takeScreenshot("FAIL");
        }

    }


}
