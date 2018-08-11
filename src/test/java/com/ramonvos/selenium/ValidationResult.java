package com.ramonvos.selenium;

import com.aventstack.extentreports.markuputils.Markup;
import com.ramonvos.logger.Reporter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ValidationResult {



    public static void assertTextInElement(WebElement element, String text)  {

        try {
        WaitForElement.waitTextPresentInElement(element,text);
        Assert.assertEquals(element.getText(), text);

        Reporter.addStepsToPassMarkup("TEST PASSED");
        }catch (Exception ex){
            Reporter.addStepsToFailMarkup("FAILED TEST " + ex.getMessage());
            Reporter.addStepsToException(ex);
        }

    }
    public static void AssertElementContainsText(WebElement element ,String textPart) {
        try {
            Assert.assertTrue(element.getText().contains(textPart));

            Reporter.addStepsToPassMarkup("TEST PASSED");
        }catch (Exception ex){
            Reporter.addStepsToFailMarkup("FAILED TEST " + ex.getMessage());
            Reporter.addStepsToException(ex);
        }
    }

    public static void elementIsVisible(WebElement element ){
        try {
            Assert.assertTrue(element.isDisplayed());

            Reporter.addStepsToPassMarkup("TEST PASSED");
        }catch (Exception ex){
            Reporter.addStepsToFail("FAILED TEST " + ex.getMessage());
            Reporter.addStepsToException(ex);
        }

    }


}
