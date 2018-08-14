package com.ramonvos.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonitizacaoPage extends PageObject{

    public MonitizacaoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "mediaId")
    public WebElement statusEnvio;



}
