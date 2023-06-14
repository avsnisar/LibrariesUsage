package rest.assured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specs {

    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://api.kucoin.com/")
            .setBasePath("api/v1/market/")
            .setContentType(ContentType.JSON)
            .build();

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectStatusLine("OK")
            .build();

    public Specs() {
    }
}
