package com.ramonvos.tests;

import com.ramonvos.constants.Constants;
import com.ramonvos.pages.LoginPage;
import com.ramonvos.pages.NovoProjetoPage;
import com.ramonvos.selenium.SeleniumHelpers;
import com.ramonvos.selenium.ValidationResult;
import com.ramonvos.webdriver.TestBase;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

import java.util.UUID;

public class NovoProjetoTests extends TestBase {
    LoginPage objLogin;
    NovoProjetoPage objProjeto;

    @Test
    public void TEST_cadastrarNovoProjetoSucesso(){

        // TestData
        String nomeProjeto = "teste 01" + UUID.randomUUID();
        String descricaoProjeto = "teste descricao";
        //Objetos
        objLogin = new LoginPage(driver);
        objProjeto = new NovoProjetoPage(driver);

        objLogin.logIn(Constants.USERNAME,Constants.PASSWORD);

        objProjeto.acessarNovoProjeto().preencherNovoProjeto(nomeProjeto,descricaoProjeto).salvarNovoProjeto();


        //Teste vai falhar pois não é exibido msg de sucesso
        ValidationResult.assertTextInElement(objProjeto.msgSucesso,"Projeto cadastrado com sucesso");

    }

    @Test
    public void TEST_cadastrarNovoProjetoCampoNomeProjetoNaoInformado(){

        // TestData
        String nomeProjeto = "";
        String descricaoProjeto = "";
        //Objetos
        objLogin = new LoginPage(driver);
        objProjeto = new NovoProjetoPage(driver);

        objLogin.logIn(Constants.USERNAME,Constants.PASSWORD);

        objProjeto.acessarNovoProjeto().preencherNovoProjeto(nomeProjeto,descricaoProjeto).salvarNovoProjeto();

        ValidationResult.assertTextInElement(objProjeto.msgErro,"Por favor insira um nome para o projeto");

    }
    @Test
    public void TEST_cadastrarNovoProjetoTamanhoNomeNaoPermitido(){

        objLogin = new LoginPage(driver);
        objProjeto = new NovoProjetoPage(driver);

        objLogin.logIn(Constants.USERNAME,Constants.PASSWORD);

        objProjeto.acessarNovoProjeto();

        SeleniumHelpers.executeJavaScript("document.getElementByName('name').setAttribute('value','Teste nome projeto com mais de 40 posicoes')");

        objProjeto.salvarNovoProjeto();

        ValidationResult.assertTextInElement(objProjeto.msgErro, "O nome do projeto deve ter no máximo 40 caracteres");


    }
}
