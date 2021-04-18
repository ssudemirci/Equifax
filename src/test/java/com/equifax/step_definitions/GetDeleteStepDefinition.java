package com.equifax.step_definitions;


import com.equifax.base.BaseTest;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GetDeleteStepDefinition extends BaseTest {
    private Response response;
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private JsonPath jsonPath;


    @BeforeStep
    public void init() {
        setUp();
    }


    @Given("Request payload")
    public void request_payload() {
        requestSpec = requestSpecification();
    }

    @When("User Performs {string} HTTP methods with {string} a employee")
    public void user_performs_http_methods_with_a_employee(String method, String id) {
        response=performsMethod(method,id,requestSpec);
    }

    @Then("User should see the success status {string}")
    public void user_should_see_the_success_status(String statusCode) {
        Assert.assertEquals(response.statusCode(), Integer.parseInt(statusCode));
    }

    @Then("Payload {string} value is {string}")
    public void payload_value_is(String responseBody, String value) {
        jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString(responseBody), value + "");

    }


}
