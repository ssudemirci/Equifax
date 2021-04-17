package com.equifax.pages.amazon;

import com.equifax.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{


    @FindBy(xpath = "(//span[@class='a-price'])[1]")
    private WebElement firstItemLink;

    public String price(String order){
        String xpath="(//span[@class='a-price'])["+order+"]";
        String getText=Driver.getDriver().findElement(By.xpath(xpath)).getText();
        return getText.substring(0,3)+"."+getText.substring(3).trim();

    }
    
    public void clickItem(String order){
        String xpath="(//span[@class='a-price'])["+order+"]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();

    }

   

}
