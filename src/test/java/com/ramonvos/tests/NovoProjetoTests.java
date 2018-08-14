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



    @Test @Description("Issue #1 GitHub: https://github.com/ramonvos/Selenium-Java/issues/1")
    public void TEST_cadastrarNovoProjetoCampoNomeProjetoNaoInformado(){

        // Dados para teste
        String nomeProjeto = "";
        String descricaoProjeto = "";

        //Instanciando objetos da página
        objLogin = new LoginPage(driver);
        objProjeto = new NovoProjetoPage(driver);

        //Acionando o metodo de realizar login
        objLogin.logIn(Constants.USERNAME,Constants.PASSWORD);

        //Acessando a tela de novo projeto e clicando em salvar sem informar os campos
        objProjeto.acessarNovoProjeto().preencherNovoProjeto(nomeProjeto,descricaoProjeto).salvarNovoProjeto();

        // Validando que o sistema apresenta mensagem de obrigatoriedade
        ValidationResult.assertTextInElement(objProjeto.msgErro,"Por favor insira um nome para o projeto");

    }
    @Test @Description("Issue #2 GitHub: https://github.com/ramonvos/Selenium-Java/issues/2")
    public void TEST_cadastrarNovoProjetoTamanhoNomeNaoPermitido(){

        // Instância dos objetos
        objLogin = new LoginPage(driver);
        objProjeto = new NovoProjetoPage(driver);

        // Realizando Login
        objLogin.logIn(Constants.USERNAME,Constants.PASSWORD); // Login e senha validos

        // Acionando o menu novo projeto
        objProjeto.acessarNovoProjeto();

        //Injetando javascript na tela de novo projeto com valor maior que o permitido ()
        SeleniumHelpers.executeJavaScript("document.getElementByName('name').setAttribute('value','Teste nome projeto com mais de 40 posicoes')");

        //Clicar em Criar projeto
        objProjeto.salvarNovoProjeto();

        //Validando que o sistema apresenta mensagem de no máximo 40 posições
        ValidationResult.assertTextInElement(objProjeto.msgErro, "O nome do projeto deve ter no máximo 40 caracteres");
    }

    @Test @Description("Issue #3 GitHub: https://github.com/ramonvos/Selenium-Java/issues/3")
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
}
