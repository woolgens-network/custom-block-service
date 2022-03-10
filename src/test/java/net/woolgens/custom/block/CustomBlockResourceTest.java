package net.woolgens.custom.block;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import net.woolgens.custom.block.model.CustomBlock;
import net.woolgens.custom.block.repository.CustomBlockRepository;
import net.woolgens.custom.block.resource.CustomBlockResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(CustomBlockResource.class)
public class CustomBlockResourceTest {

    @Inject
    CustomBlockRepository repository;

    CustomBlock block;


    @BeforeEach
    public void setup() {
        repository.deleteAll();
        block = new CustomBlock();
        block.setId("test");
        block.setType("GENERATOR");
        block.setProperties(new HashMap<>());
        repository.persistOrUpdate(block);
    }

    @Test
    public void testGetEndpoint() {
        given()
                .when().get("/" + block.getId())
                .then()
                .statusCode(200)
                .body("id", is(block.getId()));
    }

    @Test
    public void testGetAllEndpoint() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body("isEmpty()", is(false));
    }

    @Test
    public void testPutEndpoint() {
        CustomBlock block = new CustomBlock();
        block.setId("PutTest");
        block.setType("GENERATOR");
        block.setProperties(new HashMap<>());

        given().body(block).contentType(ContentType.JSON)
                .when().put()
                .then()
                .statusCode(200)
                .body("id", is(block.getId()));
    }

    @Test
    public void testDeleteEndpoint() {
        given()
                .when().delete("/" + block.getId())
                .then()
                .statusCode(200)
                .body(is("true"));
    }

}