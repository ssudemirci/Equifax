package com.equifax.pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToCardPage extends BasePage {


    @FindBy(id = "newBuyBoxPrice")
    private WebElement adToCardPriceElement;


    public String adToCardPrice(){
        return wait.until(ExpectedConditions.visibilityOf(adToCardPriceElement)).getText();
    }

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;


    public void clickAddToCard(){
        wait.until(ExpectedConditions.visibilityOf(addToCartButton)).click();
    }















}
