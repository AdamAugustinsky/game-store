package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class CreateCartTest {

    @Test
    public void createCart() {
        given()
        .when().post("/cart")
        .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("shipping_price", equalTo(0))
            .body("products", notNullValue());
    }

}
