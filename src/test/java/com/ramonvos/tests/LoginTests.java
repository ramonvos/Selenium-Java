package com.ramonvos.tests;


import com.ramonvos.constants.Constants;
import com.ramonvos.pages.LoginPage;
import com.ramonvos.selenium.WaitForElement;
import com.ramonvos.webdriver.TestBase;

import org.testng.Assert;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    LoginPage objLogin;

    @Test
    public void RealizarLoginSucesso() {

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

        Assert.assertEquals(objLogin.msgErro.getText(), "Email ou senha incorretos. Saiba Mais");

    }

    @Test
    public void TEST_RealizarLoginSenhaInvalida() {

        objLogin = new LoginPage();

        objLogin.LogIn(Constants.USERNAME, "8888");

        Assert.assertEquals(objLogin.msgErro.getText(), "Email ou senha incorretos. Saiba Mais");

    }

    @Test
    public void TEST_RealizarLoginEmailESenhaInvalidos() throws InterruptedException {

        objLogin = new LoginPage();

        objLogin.LogIn("teste555555aa@teste.com", "123456");

        Thread.sleep(2000);
        Assert.assertEquals(objLogin.msgErro.getText(), "Email ou senha incorretos. Saiba Mais");

    }



    @Test
    public void RealizarLoginLogout() {

        objLogin = new LoginPage();

        objLogin.LogIn("avaliacao_qa_samba@sambatech.com.br","123456789").LogOut();


        Assert.assertEquals(objLogin.btnEntrar.isDisplayed(), true);

    }
}


