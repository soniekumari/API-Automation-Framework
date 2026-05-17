package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.Store;
import api.routes.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	public static Response createStore(Store storePayload) {
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(storePayload)
		.when()
		
			.post(Routes.store_post_url);
		
		return response;
	}
	
	public static Response readStrore(long orderId) {
		
		Response response = given()
			.pathParam("orderId", orderId)
		.when()
		
			.get(Routes.store_get_url);
		
		return response;
	}
	
	
	public static Response deleteStrore(long orderId) {
		
		Response response = given()
			.pathParam("orderId", orderId)
		.when()
		
			.get(Routes.store_delete_url);
		
		return response;
	}
}
