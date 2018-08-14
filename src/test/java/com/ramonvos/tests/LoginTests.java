package com.ramonvos.tests;
import com.ramonvos.constants.Constants;
import com.ramonvos.pages.LoginPage;
import com.ramonvos.selenium.ValidationResult;
import com.ramonvos.selenium.WaitForElement;
import com.ramonvos.webdriver.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    LoginPage objLogin;

    @Test
    public void TEST_realizarLoginSucesso() {

        objLogin = new LoginPage(driver);

        objLogin.logIn(Constants.USERNAME, Constants.PASSWORD);

        WaitForElement.waitForElementClickable(objLogin.menuDashboard);

        ValidationResult.assertTextInElement(objLogin.menuDashboard, "Painel");



    }

    @Test
    public void TEST_realizarLoginEmailNaoInformado() {

        objLogin = new LoginPage(driver);

        objLogin.logIn("", Constants.PASSWORD);

        ValidationResult.assertTextInElement(objLogin.msgErro,"Email ou senha incorretos. Saiba Mais");


    }

    @Test
    public void TEST_realizarLoginSenhaNaoInformada() {

        objLogin = new LoginPage(driver);

        objLogin.logIn(Constants.USERNAME, "");

        ValidationResult.assertTextInElement(objLogin.msgErro,"Email ou senha incorretos. Saiba Mais");

    }
    @Test
    public void TEST_realizarLoginEmailInvalido() {

        objLogin = new LoginPage(driver);

        objLogin.logIn("teste23342", Constants.PASSWORD);

        ValidationResult.assertTextInElement(objLogin.msgErro,"Email ou senha incorretos. Saiba Mais");

    }

    @Test
    public void TEST_realizarLoginSenhaInvalida() {

        objLogin = new LoginPage(driver);

        objLogin.logIn(Constants.USERNAME, "8888");

        ValidationResult.assertTextInElement(objLogin.msgErro,"Email ou senha incorretos. Saiba Mais");

    }

    @Test
    public void TEST_realizarLoginEmailESenhaInvalidos() {

        objLogin = new LoginPage(driver);

        objLogin.logIn("teste555555aa@teste.com", "123456");

        ValidationResult.assertTextInElement(objLogin.msgErro,"Email ou senha incorretos. Saiba Mais");

    }

    @Test
    public void TEST_realizarLoginLogout() {

        objLogin = new LoginPage(driver);

        objLogin.logIn("avaliacao_qa_samba@sambatech.com.br","123456789").logOut();

        ValidationResult.elementIsVisible(objLogin.btnEntrar);


    }
}


