package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import javax.json.Json;
import javax.json.JsonObject;

@QuarkusTest
public class RemoveProductTest {

    @BeforeAll
    static void setup() {
        given()
        .when().post("/cart");

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
        .when().post("/cart/{cartId}");
    }

    @Test
    public void removeProduct() {
        given()
        .pathParam("cartId", 1)
        .pathParam("productId", 1)
        .contentType(ContentType.JSON)
        .when().delete("/cart/{cartId}/{productId}")
        .then()
            .log().all()
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
