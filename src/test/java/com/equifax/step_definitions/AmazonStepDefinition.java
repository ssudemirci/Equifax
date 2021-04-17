package com.equifax.step_definitions;

import com.equifax.pages.amazon.AddToCardPage;
import com.equifax.pages.amazon.HomePage;
import com.equifax.pages.amazon.ProceedPage;
import com.equifax.pages.amazon.SearchResultPage;
import com.equifax.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class AmazonStepDefinition {
    private static final Logger logger = Logger.getLogger(AmazonStepDefinition.class);

    HomePage home=new HomePage();
    SearchResultPage searchResult=new SearchResultPage();
    AddToCardPage addToCard=new AddToCardPage();
    ProceedPage proceed=new ProceedPage();
    static String searchResultPrice;

    @Given("I visit amazon.com page")
    public void i_visit_amazon_com_page() {
        home.setUp();

    }

    @When("I search  a {string}")
    public void i_search_a(String item) {
        home.search(item);

    }

    @When("I click on {string}  item on the listed results.")
    public void i_click_on_item_on_the_listed_results(String order) {
        searchResultPrice=searchResult.price(order);
        searchResult.clickItem(order);


    }

    @Then("Add to Card  item price  should the same with  Search Result Price")
    public void add_to_card_item_price_should_the_same_with_search_result_price() {

        String actualPrice=addToCard.adToCardPrice();
        String expectedPrice=searchResultPrice;
        Assert.assertTrue(actualPrice.contains(expectedPrice));

    }
    @And("I click on Add to Cart")
    public void i_click_on_add_to_cart() {
      addToCard.clickAddToCard();
    }

    @Then("Proceed to Checkout price should the same with Search Result Price")
    public void proceed_to_checkout_price_should_the_same_with_search_result_price() {
        String expectedPrice=searchResultPrice;
        String actualPrice=proceed.cartSubtotal();
        Assert.assertTrue(actualPrice.contains(expectedPrice));

    }
    @When("I click on Proceed to checkout")
    public void i_click_on_proceed_to_checkout() {
        proceed.clickProceedToCheckout();


    }

    @Then("I verifies that page title is {string}")
    public void i_verifies_that_page_title_is(String expectedTitle) {

        String actualTitle= BrowserUtils.getTitle();
        //Assert.assertEquals(expectedTitle,actualTitle,actualTitle+" is not the same with "+expectedTitle);
        Assert.assertEquals(actualTitle+" is not the same with "+expectedTitle,actualTitle, expectedTitle);


    }



}
