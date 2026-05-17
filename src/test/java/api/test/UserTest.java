package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User payload;
	private Logger logger = LogManager.getLogger(this.getClass());;
	
	@BeforeClass
	public void setUpData() {
		
		faker = new Faker();
		payload = new User();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().fullName());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5, 10));
		payload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("************* Creating User *****************");
		
		Response response = UserEndPoints.createUser(payload);
				response.then().log();
				
				Assert.assertEquals(response.getStatusCode(), 200);
				
		logger.info("************* User is Created *****************");
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		logger.info("************* Get User *****************");
		Response response = UserEndPoints.readUser(this.payload.getUsername());
				response.then().log().all();
				
				Assert.assertEquals(response.getStatusCode(), 200);
				
		logger.info("************* User is displayed *****************");
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		logger.info("************* Update User *****************");
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.payload.getUsername(), payload);
				response.then().log().body();
				
				Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* User is updated *****************");
		logger.info("************* Get User after update *****************");		
		Response readAfterUpdate = UserEndPoints.readUser(this.payload.getUsername());	
				readAfterUpdate.then().log().all();
				
				Assert.assertEquals(readAfterUpdate.getStatusCode(), 200);
		logger.info("************* User is displayed after update *****************");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("************* Delete User *****************");
		Response response = UserEndPoints.deleteUser(this.payload.getUsername());
				response.then().log().body();
				
				Assert.assertEquals(response.getStatusCode(), 200);
				
		logger.info("************* User Deleted successfully *****************");
	}
}
