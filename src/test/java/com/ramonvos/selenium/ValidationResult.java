package com.ramonvos.selenium;
import com.ramonvos.logger.Reporter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ValidationResult {

    //Metodo de asserção - verifica se a mensagem está presente no elemento
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
    //Metodo de asserção - verifica se o elemento possui parte do texto (Contém)
    public static void AssertElementContainsText(WebElement element ,String textPart) {
        try {
            Assert.assertTrue(element.getText().contains(textPart));

            Reporter.addStepsToPassMarkup("TEST PASSED");
        }catch (Exception ex){
            Reporter.addStepsToFailMarkup("FAILED TEST " + ex.getMessage());
            Reporter.addStepsToException(ex);
        }
    }
    //Metodo de asserção - verifica se o elemento está visivel
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
