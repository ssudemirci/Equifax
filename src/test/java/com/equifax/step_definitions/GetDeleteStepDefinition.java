package com.equifax.step_definitions;

import com.equifax.base.BaseTest;
import com.equifax.utilities.ConfigurationReader;
import com.equifax.utilities.EndPointResources;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;

public class GetDeleteStepDefinition {
    private Response response;
   private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private JsonPath jsonPath;


    @BeforeStep
    public void setUp() {
        RestAssured.baseURI = ConfigurationReader.getProperty("baseURI");
        RestAssured.basePath = ConfigurationReader.getProperty("basePath");
    }


    @Given("Request payload")
    public void request_payload() {
        requestSpec = new RequestSpecBuilder().build().
                contentType(ContentType.JSON).log().all();
    }

    @When("User Performs {string} HTTP methods with {string} a employee")
    public void user_performs_http_methods_with_a_employee(String method, String id) {
        method = method.trim();
        if (method.equalsIgnoreCase("Get")) {
            response = given().spec(requestSpec).when()
                    .get(ConfigurationReader.getProperty("getEndPoint"), id).prettyPeek();
        }
        if (method.equalsIgnoreCase("Delete")) {
            response = given().spec(requestSpec).when()
                    .delete(ConfigurationReader.getProperty("deleteEndPoint"), id).prettyPeek();
        }
    }

    @Then("User should see the success status {string}")
    public void user_should_see_the_success_status(String statusCode) {
        Assert.assertEquals(response.statusCode(),Integer.parseInt(statusCode));
    }

    @Then("Payload {string} value is {string}")
    public void payload_value_is(String responseBody, String value) {
        jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.getString(responseBody), value+"");

    }
}
