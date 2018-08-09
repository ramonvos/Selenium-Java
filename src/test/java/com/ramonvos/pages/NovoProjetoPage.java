package com.ramonvos.pages;

import com.ramonvos.selenium.SeleniumHelpers;
import com.ramonvos.selenium.WaitForElement;
import com.ramonvos.webdriver.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NovoProjetoPage {

    public NovoProjetoPage(){

        PageFactory.initElements(TestBase.driver, this);
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


    public NovoProjetoPage AcessarNovoProjeto() {

        WaitForElement.WaitForElementClickable(menuProject);

        SeleniumHelpers.MoteToElementAndClick(menuProject);
        SeleniumHelpers.ClickButton(linkNovoProjeto);

        return new NovoProjetoPage();

    }

    public NovoProjetoPage PreencherNovoProjeto(String nome, String descricao){

        SeleniumHelpers.TypeInTextBox(txtNomeProjeto,nome);
        SeleniumHelpers.TypeInTextBox(txtDescricaoProjeto,descricao);

        SeleniumHelpers.ClickButton(btnCriarProjeto);

        return new NovoProjetoPage();
    }

}
