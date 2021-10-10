package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import javax.json.Json;
import javax.json.JsonObject;

@QuarkusTest
public class AddProductTest {

    @Test
    public void createCart() {
        JsonObject testProduct = Json.createObjectBuilder()
            .add("name", "test")
            .add("price", 10.0)
            .add("score", 10)
            .add("image", "https://source.unsplash.com/user/c_v_r/100x100")
            .build();
        
        given()
        .pathParam("cartId", 1)
        .body(testProduct.toString())
        .contentType(ContentType.JSON)
        .when().post("/cart/{cartId}")
        .then()
            .statusCode(201)
            .body("products", notNullValue());
    }

    @Test
    public void createCartNotFound() {
        String testProduct = Json.createObjectBuilder()
            .add("name", "test")
            .add("price", 10.0)
            .add("score", 10)
            .add("image", "https://source.unsplash.com/user/c_v_r/100x100")
            .build().toString();
        
        given()
        .pathParam("cartId", 12)
        .body(testProduct)
        .contentType(ContentType.JSON)
        .when().post("/cart/{cartId}")
        .then()
            .statusCode(404);
    }

}
