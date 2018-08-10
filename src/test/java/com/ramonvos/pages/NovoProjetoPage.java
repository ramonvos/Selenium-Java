package com.ramonvos.pages;

import com.ramonvos.selenium.SeleniumHelpers;
import com.ramonvos.selenium.WaitForElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NovoProjetoPage extends PageObject {

    public NovoProjetoPage(WebDriver driver){

        super(driver);
    }

    @FindBy(xpath = "//a[@id='navbar-project-name']/b")
    public WebElement menuProject;

    @FindBy(id = "new_project")
    public WebElement linkNovoProjeto;

    @FindBy(name =  "name")
    public WebElement txtNomeProjeto;

    @FindBy(name =  "description")
    public WebElement txtDescricaoProjeto;

    @FindBy(xpath =  "//div[@id='modalContainer']/div/div[3]/button")
    public WebElement btnCriarProjeto;

    @FindBy(xpath =  "//div[@id='modalContainer']/div/div[2]/form/div/span")
    public WebElement msgErro;

    @FindBy(xpath =  "")
    public WebElement msgSucesso;// Não existe na tela


    public NovoProjetoPage acessarNovoProjeto() {

        WaitForElement.waitForElementClickable(menuProject);

        SeleniumHelpers.moteToElementAndClick(menuProject);
        SeleniumHelpers.clickButton(linkNovoProjeto);

        WaitForElement.waitForElementClickable(btnCriarProjeto);

        return new NovoProjetoPage(driver);

    }

    public NovoProjetoPage preencherNovoProjeto(String nome, String descricao){

        SeleniumHelpers.typeInTextBox(txtNomeProjeto,nome);
        SeleniumHelpers.typeInTextBox(txtDescricaoProjeto,descricao);

        return new NovoProjetoPage(driver);
    }

    public NovoProjetoPage salvarNovoProjeto(){
        SeleniumHelpers.clickButton(btnCriarProjeto);

        return new NovoProjetoPage(driver);
    }

}
