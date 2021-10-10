package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class RemoveProductTest {

    @Test
    public void removeProduct() {
        given()
        .pathParam("cartId", 1)
        .pathParam("productId", 1)
        .contentType(ContentType.JSON)
        .when().delete("/cart/{cartId}/{productId}")
        .then()
            .statusCode(200);
    }

    @Test
    public void removeProductCartNotFound() {
        given()
        .pathParam("cartId", -1)
        .pathParam("productId", 1)
        .contentType(ContentType.JSON)
        .when().delete("/cart/{cartId}/{productId}")
        .then()
            .statusCode(404);
    }

    @Test
    public void removeProductProductNotFound() {
        given()
        .pathParam("cartId", 1)
        .pathParam("productId", -1)
        .contentType(ContentType.JSON)
        .when().delete("/cart/{cartId}/{productId}")
        .then()
            .statusCode(404);
    }
}
