package com.ramonvos.tests;


import com.ramonvos.constants.Constants;
import com.ramonvos.pages.LoginPage;
import com.ramonvos.selenium.ValidationResult;
import com.ramonvos.selenium.WaitForElement;
import com.ramonvos.webdriver.TestBase;

import org.testng.Assert;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    LoginPage objLogin;

    @Test
    public void TEST_RealizarLoginSucesso() {

        objLogin = new LoginPage();

        objLogin.LogIn(Constants.USERNAME, Constants.PASSWORD);

        WaitForElement.WaitForElementClickable(objLogin.menuUsuario);

        Assert.assertEquals(objLogin.menuUsuario.getText(), "Automação Samba - Teste QA");

    }

    @Test
    public void TEST_RealizarLoginEmailNaoInformado() {

        objLogin = new LoginPage();

        objLogin.LogIn("", Constants.PASSWORD);

        Assert.assertEquals(objLogin.msgErro.getText(), "Email ou senha incorretos. Saiba Mais");

    }

    @Test
    public void TEST_RealizarLoginSenhaNaoInformada() {

        objLogin = new LoginPage();

        objLogin.LogIn(Constants.USERNAME, "");

        Assert.assertEquals(objLogin.msgErro.getText(), "Email ou senha incorretos. Saiba Mais");

    }
    @Test
    public void TEST_RealizarLoginEmailInvalido() {

        objLogin = new LoginPage();

        objLogin.LogIn("teste23342@teste.com", Constants.PASSWORD);

        ValidationResult.AssertTextInElement(objLogin.msgErro, "Email ou senha incorretos. Saiba Mais");

    }

    @Test
    public void TEST_RealizarLoginSenhaInvalida() {

        objLogin = new LoginPage();

        objLogin.LogIn(Constants.USERNAME, "8888");

        ValidationResult.AssertTextInElement(objLogin.msgErro, "Email ou senha incorretos. Saiba Mais");

    }

    @Test
    public void TEST_RealizarLoginEmailESenhaInvalidos() throws InterruptedException {

        objLogin = new LoginPage();

        objLogin.LogIn("teste555555aa@teste.com", "123456");


        ValidationResult.AssertTextInElement(objLogin.msgErro, "Email ou senha incorretos. Saiba Mais");

    }



    @Test
    public void TEST_RealizarLoginLogout() {

        objLogin = new LoginPage();

        objLogin.LogIn("avaliacao_qa_samba@sambatech.com.br","123456789").LogOut();


        ValidationResult.ElementIsVisible(objLogin.btnEntrar);

    }
}


