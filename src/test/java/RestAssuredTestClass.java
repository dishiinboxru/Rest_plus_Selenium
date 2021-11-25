import io.restassured.builder.RequestSpecBuilder;

import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTestClass {


    final static String petstoreUrlHardcoded="https://petstore.swagger.io/v2/pet/777";

    protected static RequestSpecification requestSpec;


    @Test(priority = 1)
    public void getPet(){
        given().
                when()
                .get(petstoreUrlHardcoded) //TODO - remove hardcoded into builder or variables
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @BeforeTest
    public void postPet(){

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Content-type", "application/json");
        requestSpec = builder.build();


        given().spec(requestSpec).and().body("{\n" +
                "  \"id\": 777,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"lucky\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test(priority = 2)
    public void removePet(){
        given().
                when()
                .delete(petstoreUrlHardcoded) //TODO - remove hardcoded into builder or variables
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

        given().
                when()
                .get(petstoreUrlHardcoded) //TODO - remove hardcoded into builder or variables
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    }
