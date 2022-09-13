package de.prototype;
import de.prototype.model.Rental;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static org.wildfly.common.Assert.assertTrue;


@QuarkusTest
public class RentalResourceTest {

    /*
    @Test
    void shouldCreateRental() {
        Rental rental = new Rental(1, "Trekking Bike", "Reifen platt");

        String loc = given().body(rental)
                .header(CONTENT_TYPE,APPLICATION_JSON)
                .header(ACCEPT, APPLICATION_JSON)
                .when()
                .post("/api/rentals")
                .then()
                .statusCode(CREATED.getStatusCode())
                .extract().header("loc");
        assertTrue(loc.contains("/api/rentals"));
    }
     */


}