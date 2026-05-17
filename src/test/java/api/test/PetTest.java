package api.test;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.PetEndPoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tag;
import io.restassured.response.Response;

public class PetTest {

    Pet payload;
    private Logger logger = LogManager.getLogger(this.getClass());;

    @BeforeClass
    public void setUpData() {

        payload = new Pet();

        // Category
        Category category = new Category();
        category.setId(1);
        category.setName("Dogs");

        // Tag
        Tag tag = new Tag();
        tag.setId(101);
        tag.setName("Bulldog");

        // Payload
        payload.setId(5001);
        payload.setCategory(category);
        payload.setName("Tommy");

        payload.setPhotoUrls(Arrays.asList("photo1.jpg"));
        payload.setTags(Arrays.asList(tag));
        payload.setStatus("available");
    }

    @Test(priority = 1)
    public void testCreatePet() {

    	logger.info("************* Creating Pet *****************");
        Response response = PetEndPoints.createPet(payload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("************* Pet is created successfully *****************");
    }

    @Test(priority = 2)
    public void testGetPet() {

    	logger.info("************* Display Pet *****************");
        Response response = PetEndPoints.readPet(payload.getId());
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("************* Pet is displayed *****************");
    }
    
    @Test(priority = 3)
    public void testUpdatePet() {

    	logger.info("************* Update Pet *****************");
        // Update values
        payload.setName("Rocky");
        payload.setStatus("sold");

        // Update Category
        Category updatedCategory = new Category();
        updatedCategory.setName("Cats");

        payload.setCategory(updatedCategory);

        // Update Tag
        Tag updatedTag = new Tag();
        updatedTag.setName("Persian");

        payload.setTags(Arrays.asList(updatedTag));

        // Send PUT request
        Response response = PetEndPoints.updatePet(payload);

        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("************* Pet is updated *****************");

        logger.info("************* Get Pet after update *****************");
        Response updatedResponse = PetEndPoints.readPet(payload.getId());
        updatedResponse.then().log().body();

        Assert.assertEquals(updatedResponse.getStatusCode(), 200);
        Assert.assertEquals(updatedResponse.jsonPath().getString("name"), "Rocky");
        
        logger.info("************* Pet is displayed after updated *****************");

    }
    
    @Test(priority = 4)
    public void testDeletePet() {

    	logger.info("************* Delete Pet *****************");
        Response response = PetEndPoints.deletePet(payload.getId());
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("************* Pet is deleted *****************");
    }
}