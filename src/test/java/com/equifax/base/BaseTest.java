package com.equifax.base;

import com.equifax.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseTest {
    public static RequestSpecification requestSpec;
    public ResponseSpecification responseSpec;
    Response response;

    public void setUp() {
        RestAssured.baseURI = ConfigurationReader.getProperty("baseURI");
        RestAssured.basePath = ConfigurationReader.getProperty("basePath");

    }

    public RequestSpecification requestSpecification(){
        return new RequestSpecBuilder().build().
                contentType(ContentType.JSON).log().all();
    }

    public Response performsMethod(String method,String id,RequestSpecification requestSpec ){
        method = method.trim();
        if (method.equalsIgnoreCase("Get")) {
            response = given().spec(requestSpec).when()
                    .get(ConfigurationReader.getProperty("getEndPoint"), id).prettyPeek();
        }
        if (method.equalsIgnoreCase("Delete")) {
            response = given().spec(requestSpec).when()
                    .delete(ConfigurationReader.getProperty("deleteEndPoint"), id).prettyPeek();
        }
        return response;
    }


}
