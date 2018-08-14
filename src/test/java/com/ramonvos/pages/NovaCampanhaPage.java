package com.ramonvos.pages;

import com.ramonvos.constants.Constants;
import com.ramonvos.selenium.SeleniumHelpers;
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

    @FindBy(name =   "start")
    public WebElement txtDtInicio;

    @FindBy(name = "startTime")
    public WebElement txtHoraInicio;

    @FindBy(name =   "unpublishDate")
    public WebElement txtDtFim;

    @FindBy(name = "endTime")
    public WebElement txtHoraFim;

    @FindBy(name =   "target")
    public WebElement txtMeta;

    @FindBy(name = "grossValue")
    public WebElement txtPrecos;

    @FindBy(name = "//button[@type='submit']")
    public WebElement btnCriarCampanha;

    @FindBy(name = "")
    public WebElement msgSucesso;

    public NovaCampanhaPage criarNovaCampanha(String nome, String anuncio, String urlDes, String urlRas, String datai, String horai, String dataf, String horaf, String meta, String preco){

        SeleniumHelpers.navigateGoToUrl(Constants.URL_BASE+Constants.URL_CAMPANHA);
        SeleniumHelpers.typeInTextBox(txtNomeCampanha,nome);
        //SeleniumHelpers.typeInTextBox(inputFile, anuncio);
        SeleniumHelpers.typeInTextBox(txtUrlDestino, urlDes);
        SeleniumHelpers.typeInTextBox(txtUrlRastreamento, urlRas);
        SeleniumHelpers.clickButton(ckCategoria);
        SeleniumHelpers.typeInTextBox(txtDtInicio, datai);
        SeleniumHelpers.typeInTextBox(txtHoraInicio, horai);
        SeleniumHelpers.typeInTextBox(txtDtFim, dataf);
        SeleniumHelpers.typeInTextBox(txtHoraFim, horaf);

        SeleniumHelpers.typeInTextBox(txtMeta, meta);
        SeleniumHelpers.typeInTextBox(txtPrecos, preco);

        SeleniumHelpers.clickButton(btnCriarCampanha);
        return new NovaCampanhaPage(driver);
    }
}
