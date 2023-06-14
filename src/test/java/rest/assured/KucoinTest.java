package rest.assured;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static rest.assured.Specs.*;

public class KucoinTest {

    List<TickersData> gotTickers = given()
            .auth().none()
            .spec(requestSpec)
//            .with().param("param","2")
            .get("/allTickers")
            .then().log().body()
            .extract().jsonPath().getList("data.ticker", TickersData.class);

//    List<TickersData> news = Stream.of("","").sorted().limit(1);

    @Test
    void checkCrypto(){
        List<TickersData> USDTickers = gotTickers.stream().filter(x->x.getSymbolName().contains("USD")).collect(Collectors.toList());
        Assertions.assertTrue(USDTickers.stream().allMatch(x->x.getSymbolName().contains("USD")));
        ResponseOptions<Response> fromResponse = given()
                .spec(requestSpec)
                .get("/allTickers");
    }
}
