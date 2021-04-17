package com.equifax.pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProceedPage extends BasePage{

    @FindBy(xpath = "//div[@id='hlb-subcart']/div/span/span[2]")
    private WebElement cartSubtotalWebElement;

    public String cartSubtotal(){
        return wait.until(ExpectedConditions.visibilityOf(cartSubtotalWebElement)).getText();
    }

    @FindBy(id = "hlb-ptc-btn-native")
    private WebElement proceedToCheckoutLink;



    public void clickProceedToCheckout(){
        proceedToCheckoutLink.click();
    }
}

