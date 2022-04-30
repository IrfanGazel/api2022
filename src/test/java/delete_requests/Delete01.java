package delete_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Delete01 extends JsonPlaceHolderBaseUrl {

    /*
     Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01() {
        //1. set the url
        spec.pathParams("first", "todos", "second", 198);

        //2. set the expected data
        Map<String, Object> expectedMap = new HashMap<>();

        //3. Send delete request and get the response
        Response response = given().spec(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        //4 Do Assertion
        //1.way
        Map<String, Object> actualMap = response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(expectedMap, actualMap);

        //2.way
        response.then().statusCode(200);
        assertTrue(actualMap.size() == 0);//
        assertTrue(actualMap.isEmpty());//recommended

    /*
    interview qusetoin
    how to automate delete request in api testing?
        i) create new data by using post request
        ii) use delete request to delete newly created data
    Note: do not use "delete request" for existing data, create your own data then delete them.
 */

    }


}
