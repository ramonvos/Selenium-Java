package com.ramonvos.tests;

import com.ramonvos.constants.Constants;
import com.ramonvos.pages.LoginPage;
import com.ramonvos.pages.NovaCampanhaPage;
import com.ramonvos.selenium.ValidationResult;
import com.ramonvos.utilities.Utils;
import com.ramonvos.webdriver.TestBase;
import org.testng.annotations.Test;

public class CriarNovaCampanhaTests extends TestBase {

    LoginPage objLogin;
    NovaCampanhaPage objCampanha;
    @Test
    public void TEST_criarNovaCampanhaSucesso(){

        String nome = "Campanha teste";
        String arquivo = Utils.getCurrentProjectPath()+ "\\src\\test\\java\\com\\ramonvos\\archives\\videoplayback.mp4";
        String url = "www.google.com.br";
        String data = "01/01/2019";
        String hora = "01:00";
        String meta = "4000";
        String preco = "6000";

        objLogin = new LoginPage(driver);
        objCampanha = new NovaCampanhaPage(driver);

        objLogin.logIn(Constants.USERNAME,Constants.PASSWORD);

        objCampanha.criarNovaCampanha(nome,arquivo,url,url,data,hora,data,hora, meta,preco);

        ValidationResult(objCampanha.msg)

    }
}
