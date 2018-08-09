package com.ramonvos.tests;

import com.ramonvos.constants.Constants;
import com.ramonvos.pages.LoginPage;
import com.ramonvos.pages.NovoProjetoPage;
import com.ramonvos.selenium.ValidationResult;
import com.ramonvos.webdriver.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class NovoProjetoTests extends TestBase {
    LoginPage objLogin;
    NovoProjetoPage objProjeto;

    @Test
    public void TEST_CadastrarNovoProjetoSucesso(){

        // TestData
        String nomeProjeto = "teste 01" + UUID.randomUUID();
        String descricaoProjeto = "teste descricao";
        //Objetos
        objLogin = new LoginPage();
        objProjeto = new NovoProjetoPage();

        objLogin.LogIn(Constants.USERNAME,Constants.PASSWORD);

        objProjeto.AcessarNovoProjeto().PreencherNovoProjeto(nomeProjeto,descricaoProjeto);


        //Teste vai falhar pois não é exibido msg de sucesso
        ValidationResult.AssertTextInElement(objProjeto.msgSucesso,"Projeto cadastrado com sucesso");

    }

    @Test
    public void TEST_CadastrarNovoProjetoCampoNomeProjetoNaoInformado(){

        // TestData
        String nomeProjeto = "";
        String descricaoProjeto = "";
        //Objetos
        objLogin = new LoginPage();
        objProjeto = new NovoProjetoPage();

        objLogin.LogIn(Constants.USERNAME,Constants.PASSWORD);

        objProjeto.AcessarNovoProjeto().PreencherNovoProjeto(nomeProjeto,descricaoProjeto);

        ValidationResult.AssertTextInElement(objProjeto.msgErro,"Por favor insira um nome para o projeto");

    }
}
