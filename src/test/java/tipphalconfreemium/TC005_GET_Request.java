package tipphalconfreemium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request {
	@Test
	// One Test Case
	void verifyJsonResponse() {
		// Specify the base URI
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";

		// Request object
		RequestSpecification httpRequst = RestAssured.given();

		// Responsce Object
		Response response = httpRequst.request(Method.GET, "/Hyderabad");

		// Print response in the console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body  ::  " + responseBody);
		Assert.assertEquals(responseBody.contains("Hyderabad"), true);

	}

	@Test
	// another Test Case
	void verifyAllValues() {
		// Specify the base URI
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";

		// Request object
		RequestSpecification httpRequst = RestAssured.given();

		// Responsce Object
		Response response = httpRequst.request(Method.GET, "/Hyderabad");

		JsonPath jsonPath=response.jsonPath();
		jsonPath.get("City");
		
		Assert.assertEquals(jsonPath.get("City"), " Hyd");
		

	}

}
