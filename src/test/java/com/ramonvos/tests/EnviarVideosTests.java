package com.ramonvos.tests;

import com.ramonvos.constants.Constants;
import com.ramonvos.pages.EnviarVideosPage;
import com.ramonvos.pages.LoginPage;
import com.ramonvos.selenium.ValidationResult;
import com.ramonvos.utilities.Utils;
import com.ramonvos.webdriver.TestBase;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

public class EnviarVideosTests extends TestBase {

    EnviarVideosPage objEnviarVideos;
    LoginPage objLogin;

    @Test @Description("Testa funcionalidade de envio de arquivo com sucesso")
    public void TEST_enviarVideosSucesso(){
        //Massa de teste
        String caminhoArquivo = Utils.getCurrentProjectPath() +"\\src\\test\\java\\com\\ramonvos\\archives\\natureza.jpg";

        //Instanciando objetos
        objLogin  = new LoginPage(driver);
        objEnviarVideos = new EnviarVideosPage(driver);
        //Realizando login no sistema
        objLogin.logIn(Constants.USERNAME,Constants.PASSWORD);
        //Acessando a tela de envio de arquivo e selecionado o arquivo
        objEnviarVideos.enviarArquivo(caminhoArquivo);

        //Verificando se a mensamge de sucesso foi exibida
        ValidationResult.assertTextInElement(objEnviarVideos.loadingArquivo, "O conteúdo está pronto! Editar informações");
    }
}
