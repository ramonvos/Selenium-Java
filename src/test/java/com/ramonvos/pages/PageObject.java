package com.ramonvos.pages;

import com.ramonvos.logger.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver;

    //Construtor responsável por iniciar os elementos das paginas
    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
}
