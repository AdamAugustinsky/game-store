package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class CartCheckoutTest {

    @Test
    public void cartCheckout() {
        given()
        .pathParam("cartId", 2) .contentType(ContentType.JSON)
        .when().get("/carts/{cartId}/checkout")
        .then()
            .statusCode(200)
            .body("shipping_price", equalTo(20))
            .body("subtotal", equalTo(247.87F))
            .body("total", equalTo(267.87F));
    }
    
    @Test
    public void zeroShippingPriceForSubtotalBiggerThan250() {
        given()
        .pathParam("cartId", 1)
        .contentType(ContentType.JSON)
        .when().get("/carts/{cartId}/checkout")
        .then()
            .statusCode(200)
            .body("shipping_price", equalTo(0));
    }

    @Test
    public void cartCheckoutNotFound() {
        given()
        .pathParam("cartId", -2)
        .contentType(ContentType.JSON)
        .when().get("/carts/{cartId}/checkout")
        .then()
            .statusCode(404);
    }

}
