package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.json.Json;
import javax.json.JsonObject;

@QuarkusTest
public class CartCheckoutTest {

    @BeforeAll
    static void setup() {
        given()
        .when().post("/cart");

        JsonObject testProduct = Json.createObjectBuilder()
            .add("name", "test")
            .add("price", 10)
            .add("score", 10)
            .add("image", "https://source.unsplash.com/user/c_v_r/100x100")
            .build();
        
        given()
        .pathParam("cartId", 2)
        .body(testProduct.toString())
        .contentType(ContentType.JSON)
        .when().post("/cart/{cartId}");

        given()
        .pathParam("cartId", 2)
        .body(testProduct.toString())
        .contentType(ContentType.JSON)
        .when().post("/cart/{cartId}");
    }
    @Test
    public void cartCheckout() {
        given()
        .pathParam("cartId", 2) .contentType(ContentType.JSON)
        .when().get("/cart/{cartId}/checkout")
        .then()
            .statusCode(200)
            .log().all()
            .body("shipping_price", equalTo(20))
            .body("subtotal", equalTo(20.0F))
            .body("total", equalTo(40.0F));
    }
    
    @Test
    public void zeroShippingPriceForSubtotalBiggerThan250() {
        JsonObject testProduct = Json.createObjectBuilder()
            .add("name", "test")
            .add("price", 250.0)
            .add("score", 10)
            .add("image", "https://source.unsplash.com/user/c_v_r/100x100")
            .build();
        
        given()
        .pathParam("cartId", 2)
        .body(testProduct.toString())
        .contentType(ContentType.JSON)
        .when().post("/cart/{cartId}");

        given()
        .pathParam("cartId", 2)
        .contentType(ContentType.JSON)
        .when().get("/cart/{cartId}/checkout")
        .then()
            .statusCode(200)
            .body("shipping_price", equalTo(0));
    }

    @Test
    public void cartCheckoutNotFound() {
        given()
        .pathParam("cartId", -2)
        .contentType(ContentType.JSON)
        .when().get("/cart/{cartId}/checkout")
        .then()
            .statusCode(404);
    }

}
