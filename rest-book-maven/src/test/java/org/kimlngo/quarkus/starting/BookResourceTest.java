package org.kimlngo.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void testGetAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
               when()
               .get("/api/books")
               .then()
               .statusCode(200)
               .body("size()", is(5));
    }

    @Test
    void testCountAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
               .when()
               .get("/api/books/count")
               .then()
               .statusCode(200)
               .body(is("5"));
    }

    @Test
    void testGetBookById() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
               .pathParam("id", 5)
               .when()
               .get("/api/books/{id}")
               .then()
               .statusCode(200)
               .body("title", is("The Complete JavaScript Course 2024: From Zero to Expert!"))
               .body("author", is("Jonas Schmedtmann"))
               .body("yearOfPublication", is(2021))
               .body("genre", is("IT"));
    }
}