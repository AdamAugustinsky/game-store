package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ListProductsTest {

    @Test
    public void listProducts() {
        given()
        .pathParam("cartId", 1)
        .contentType(ContentType.JSON)
        .when().get("/carts/{cartId}")
        .then()
            .statusCode(200)
            .body(notNullValue());
    }

    @Test
    public void listProductsNotfound() {
        given()
        .pathParam("cartId", -1)
        .contentType(ContentType.JSON)
        .when().get("/carts/{cartId}")
        .then()
            .statusCode(404)
            .body(notNullValue());
    }
}
