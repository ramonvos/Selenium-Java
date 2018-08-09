package com.ramonvos.pages;
import com.ramonvos.selenium.SeleniumHelpers;
import com.ramonvos.selenium.WaitForElement;
import com.ramonvos.webdriver.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {


     public LoginPage(){

         PageFactory.initElements(TestBase.driver, this);
     }

    @FindBy(id ="inputEmail")
    public WebElement txtEmail;

    @FindBy(id = "inputPassword")
    public WebElement txtSenha;

    @FindBy(id = "login")
    public WebElement btnEntrar;

    @FindBy(linkText = "Sair")
    public WebElement linkSair;

    @FindBy(xpath ="(.//*[normalize-space(text()) and normalize-space(.)='Configurações'])[1]/following::span[1]")
    public WebElement menuUsuario;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Automação Samba - Teste QA'])[1]/b[1]")
    public WebElement btnMenuUsuario;

    @FindBy(xpath = "//form[@id='form-login']/div")
    public WebElement msgErro;


    public LoginPage LogIn(String email, String senha){

        SeleniumHelpers.TypeInTextBox(txtEmail,email);
        SeleniumHelpers.TypeInTextBox(txtSenha,senha);


        SeleniumHelpers.ClickButton(btnEntrar);




        return  new LoginPage();

    }

    public LoginPage LogOut(){

        WaitForElement.WaitForElementClickable(menuUsuario);
        Actions action = new Actions(TestBase.driver);

        action.moveToElement(btnMenuUsuario).moveToElement(btnMenuUsuario).click().build().perform();

        linkSair.click();

        WaitForElement.WaitForElementClickable(txtEmail);
        return  new LoginPage();

    }


//
//    public void Login(String email, String senha){
//
//        txtEmail.sendKeys(email);
//        txtSenha.sendKeys(senha);
//
//        btnEntrar.click();
//
//
//    }
}
