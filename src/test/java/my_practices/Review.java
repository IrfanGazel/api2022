package my_practices;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class Review {
         /*
        Given
            https://restful-booker.herokuapp.com/booking/2022
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "API is fun"
        And
            Connection is "keep-alive"
        And
           Server is not "RedKit"
     */


    @Test
    public void test() {


        //i)Set the URL

        String url = "https://restful-booker.herokuapp.com/booking/2022";

        //iii)Type code to send request

        Response response = given().when().get(url);
        response.prettyPrint();

        //iv)Do Assertions
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        assertTrue(response.asString().contains("Not Found"));

        assertFalse(response.asString().contains("API is fun"));

        System.out.println(response.getHeader("Connection"));

        assertEquals("Cowboy", response.getHeader("Server"));

        System.out.println(response.getHeaders());


        assertNotEquals("Red kit",response.getHeader("Server"));

    }


}

