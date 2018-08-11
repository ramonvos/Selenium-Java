package com.ramonvos.pages;
import com.ramonvos.constants.Constants;
import com.ramonvos.selenium.SeleniumHelpers;
import com.ramonvos.selenium.WaitForElement;
import com.ramonvos.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="inputEmail")
    public WebElement txtEmail;

    @FindBy(id = "inputPassword")
    public WebElement txtSenha;

    @FindBy(id = "login")
    public WebElement btnEntrar;

    @FindBy(linkText = "Sair")
    public WebElement linkSair;

    @FindBy(id ="mn-dashboard")
    public WebElement menuDashboard;

    @FindBy(xpath = "//div[@id='wrap']/div/div[2]/form/ul[2]/li/a/span/b")
    public WebElement btnMenuUsuario;

    @FindBy(xpath = "//form[@id='form-login']/div")
    public WebElement msgErro;

    public LoginPage navigateGoToLogin(){

        SeleniumHelpers.navigateGoToUrl(Constants.URL_BASE+Constants.URL_LOGIN);

        return new LoginPage(driver);
    }

    public LoginPage logIn(String email, String senha){

        navigateGoToLogin();

        SeleniumHelpers.typeInTextBox(txtEmail,email);
        SeleniumHelpers.typeInTextBox(txtSenha,senha);

        SeleniumHelpers.clickButton(btnEntrar);

        return  new LoginPage(driver);
    }

    public LoginPage logOut(){

        WaitForElement.waitForElementClickable(menuDashboard);

        SeleniumHelpers.moveToElementAndClick(btnMenuUsuario);
        SeleniumHelpers.moveToElementAndClick(linkSair);

        WaitForElement.waitForElementClickable(txtEmail);
        return  new LoginPage(driver);

    }

}
