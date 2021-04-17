package com.equifax.base;

import com.equifax.utilities.EndPointResources;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BaseTest {
    public static RequestSpecification requestSpec;
    public ResponseSpecification responseSpec;
    Response response;

@BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        RestAssured.basePath = "/api/v1/";
        requestSpec=new RequestSpecBuilder().build().
                contentType(ContentType.JSON).log().all();

        ResponseSpecBuilder resSpecBuilder = new ResponseSpecBuilder() ;
        responseSpec = resSpecBuilder
                .expectContentType(ContentType.JSON).expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();

    }


}
