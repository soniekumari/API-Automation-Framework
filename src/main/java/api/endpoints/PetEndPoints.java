package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.Pet;
import api.routes.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {

    public static Response createPet(Pet payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
        .when()
                .post(Routes.pet_post_url);

        return response;
    }

    public static Response readPet(long petId) {

        Response response = given()
                .pathParam("petId", petId)
        .when()
                .get(Routes.pet_get_url);

        return response;
    }

    public static Response updatePet(Pet payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

        .when()
                .put(Routes.pet_update_url);

        return response;
    }

    public static Response deletePet(long petId) {

        Response response = given()
                .pathParam("petId", petId)

        .when()
                .delete(Routes.pet_delete_url);

        return response;
    }
}