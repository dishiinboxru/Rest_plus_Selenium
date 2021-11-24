import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTestClass {

    final static String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";
    final static String petstoreUrl="http://petstore.swagger.io/";
    final static String petstoreUrlHardcoded="https://petstore.swagger.io/v2/pet/777";

    protected static RequestSpecification requestSpec;


    @Test
    public void getPet(){
        given().
                when()
//                .get(petstoreUrl + "/v2/pet/777")
                .get(petstoreUrlHardcoded) //TODO - remove hardcoded into builder or variables
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
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


    @Test
    public void basisTest() {

        getResponseBody();
        getResponseStatus();

        ; }

    //This will fetch the response body as is and log it. given and when are optional here
    public void getResponseBody(){

        given().when().get(url).then().log()
                .all();

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
    }

    public void getResponseStatus(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }

}