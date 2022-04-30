package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get07 extends JsonPlaceHolderBaseUrl {

    /*
    Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds less than 5 on the console
			   Assert that maximum userId less than 5 is 1
			 4)Print all titles whose ids are less than 5
			   Assert that “delectus aut autem” is one of the titles whose id is less than 5
     */

    @Test
    public void get01() {
        //1.Step: Set the URL
        spec.pathParam("first", "todos");

        //2.Set the expected data

        //3.Step Send the Request and GEt the REsponse
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4.Do Assertions
        //1)Status code is 200
        response.then().assertThat().statusCode(200);

        //2)Print all ids greater than 190 on the console
        JsonPath json = response.jsonPath();
        List<Integer> ids = json.getList("findAll{it.id>190}.id");//Groovy LAnguage : Java Based Programming Language ("it" means json object)
        System.out.println(ids);
        List<Integer> titles = json.getList("findAll{it.id>190}.title");//Groovy LAnguage : Java Based Programming Language ("it" means json object)
        System.out.println(titles);

        //Assert that there are 10 ids greater than 190

        assertEquals("Number of Ids did not match", 10, ids.size());

        //3)Print all userIds whose ids are less than 5 on the console
        List<Integer> userIds = json.getList("findAll{it.id<5}.userId");
        System.out.println(userIds);
        //Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals("The number of userIds whose ids are less than 5 is not 4", 4, userIds.size());

        //4)Print all titles whose ids are less than 5
        //Assert that “delectus aut autem” is one of the titles whose id is less than 5

        List<String> titleS = json.getList("findAll{it.id<5}.title");
        System.out.println(titleS);
        //1.way
        assertTrue("Expected title is not among them",titleS.contains("delectus aut autem"));

        //2.way using Lambda
        assertTrue("Expected title is not among them",titleS.stream().anyMatch(t->t.equals("delectus aut autem")));




    }


}
