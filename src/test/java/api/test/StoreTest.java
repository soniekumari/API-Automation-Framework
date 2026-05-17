package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTest {
	Faker faker;
	Store payload;
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@BeforeClass
	public void setUpData() {

	    faker = new Faker();
	    payload = new Store();

	    payload.setId(faker.number().randomNumber());
	    payload.setPetId(faker.number().randomNumber());
	    payload.setQuantity(faker.number().numberBetween(1, 10));
	    payload.setShipDate(java.time.Instant.now().toString());
	    payload.setStatus("placed");
	    payload.setComplete(true);

	}
	
	@Test(priority = 1)
	public void testCreateStore() {
		
		logger.info("************* Creating Store *****************");
		Response response = StoreEndPoints.createStore(payload);
		response.then().log();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* Store is created successfully *****************");
	}
	
	@Test(priority = 2)
	public void testGetStore() {
		
		logger.info("************* Display Store *****************");
		Response response = StoreEndPoints.readStrore(this.payload.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* Store is displayed *****************");
	}
	
	
	@Test(priority = 3)
	public void testDeleteStore() {
		
		logger.info("************* Delete Store *****************");
		Response response = StoreEndPoints.deleteStrore(this.payload.getId());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* Store is deleted*****************");
	}
}
