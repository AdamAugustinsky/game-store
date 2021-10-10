package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class CreateCartTest {

    @Test
    public void createCart() {
        given()
        .when().post("/carts")
        .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("products", notNullValue());
    }

}
