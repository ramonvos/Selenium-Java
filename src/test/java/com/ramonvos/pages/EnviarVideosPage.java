package com.ramonvos.pages;
import com.ramonvos.selenium.SeleniumHelpers;
import com.ramonvos.selenium.WaitForElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnviarVideosPage extends PageObject {

    public EnviarVideosPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="mn-upload")
    public WebElement menuEnviar;

    @FindBy(xpath="//input[@type='file']")
    public WebElement btnUpload;

    @FindBy(id="uploader-large")
    public  WebElement upload;

    @FindBy(xpath = "//section[@id='upload-process']/table/tbody/tr/td/div/div/p")
    public WebElement loadingArquivo;


    public EnviarVideosPage enviarArquivo(String arquivo){

        SeleniumHelpers.clickButton(menuEnviar);

        WaitForElement.waitForElementClickable(upload);

        SeleniumHelpers.typeInTextBox(btnUpload,arquivo);

        WaitForElement.waitTextPresentInElement(loadingArquivo,"O conteúdo está pronto! Editar informações");

        return new EnviarVideosPage(driver);

    }
}
