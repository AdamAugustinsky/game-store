package br.com.supera;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import javax.json.Json;
import javax.json.JsonObject;

@QuarkusTest
public class ListProductsTest {

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

        given()
        .pathParam("cartId", 1)
        .body(testProduct.toString())
        .contentType(ContentType.JSON)
        .when().post("/cart/{cartId}");
    }

    @Test
    public void listProducts() {
        given()
        .pathParam("cartId", 1)
        .contentType(ContentType.JSON)
        .when().get("/cart/{cartId}")
        .then()
            .statusCode(200)
            .body(notNullValue());
    }

    @Test
    public void listProductsNotfound() {
        given()
        .pathParam("cartId", -1)
        .contentType(ContentType.JSON)
        .when().get("/cart/{cartId}")
        .then()
            .statusCode(404)
            .body(notNullValue());
    }
}
