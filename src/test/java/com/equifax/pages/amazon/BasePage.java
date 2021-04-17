package com.equifax.pages.amazon;

import com.equifax.utilities.ConfigurationReader;
import com.equifax.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInput;

    public void search(String itemName){
        searchInput.sendKeys(itemName+ Keys.ENTER);
    }



}
