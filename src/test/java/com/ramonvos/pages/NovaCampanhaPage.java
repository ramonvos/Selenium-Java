package com.ramonvos.pages;
import com.ramonvos.selenium.SeleniumHelpers;
import com.ramonvos.selenium.WaitForElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NovaCampanhaPage extends PageObject {

    public NovaCampanhaPage(WebDriver driver){

        super(driver);
    }

    @FindBy(name = "name")
    public WebElement txtNomeCampanha;

    @FindBy(xpath = "//section[@id='new-campaign']/article/div[2]/form/div/div[2]/input")
    public WebElement inputFile;

    @FindBy(name = "urlClickThrough")
    public WebElement txtUrlDestino;

    @FindBy(name = "urlTracker")
    public WebElement txtUrlRastreamento;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement ckCategoria;

    @FindBy(id =   "publishDate")
    public WebElement txtDtInicio;

    @FindBy(name = "startTime")
    public WebElement ddlHoraInicio;

    @FindBy(id =   "unpublishDate")
    public WebElement txtDtFim;

    @FindBy(name = "endTime")
    public WebElement ddlHoraFim;

    @FindBy(name =   "target")
    public WebElement txtMeta;

    @FindBy(name = "grossValue")
    public WebElement txtPrecos;

    @FindBy(name = "isUniform")
    public WebElement ddlGarantiaEntrega;

    @FindBy(id = "mn-monetization")
    public WebElement menuMonetizacao;

    @FindBy(id = "create-campaign")
    public WebElement btnCriarCampanha;

    @FindBy(id = "send-feedback")
    public WebElement loadMidia;

    @FindBy(id = "create-campaign")
    public WebElement msgSucesso;

    @FindBy(xpath = "//ul[@id='list-errors']/li")
    public WebElement msgErro;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSalvarCampanha;

    public NovaCampanhaPage criarNovaCampanha(String nome, String anuncio, String urlDes, String urlRas, String datai, String horai, String dataf, String horaf, String meta, String preco){

        WaitForElement.waitForElementClickable(menuMonetizacao);
        SeleniumHelpers.clickButton(menuMonetizacao);


        WaitForElement.waitForElementClickable(btnCriarCampanha);
        SeleniumHelpers.clickButton(btnCriarCampanha);

        SeleniumHelpers.typeInTextBox(txtNomeCampanha,nome);
        if ( anuncio != ""   ){
        SeleniumHelpers.typeInTextBox(inputFile, anuncio);}
        SeleniumHelpers.typeInTextBox(txtUrlDestino, urlDes);
        SeleniumHelpers.typeInTextBox(txtUrlRastreamento, urlRas);
        SeleniumHelpers.clickButton(ckCategoria);

        SeleniumHelpers.typeInTextBox(txtDtInicio, datai);
        txtDtInicio.sendKeys(Keys.TAB);
        SeleniumHelpers.selectDropDownList(ddlHoraInicio, horai);
        SeleniumHelpers.typeInTextBox(txtDtFim, dataf);
        txtDtFim.sendKeys(Keys.TAB);
        SeleniumHelpers.selectDropDownList(ddlHoraFim, horaf);

        SeleniumHelpers.typeInTextBox(txtMeta, meta);
        SeleniumHelpers.typeInTextBox(txtPrecos, preco);
        txtPrecos.sendKeys(Keys.TAB);

        SeleniumHelpers.clickButton(btnSalvarCampanha);

        return new NovaCampanhaPage(driver);
    }
}
