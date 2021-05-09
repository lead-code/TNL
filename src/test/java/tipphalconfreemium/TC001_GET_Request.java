package tipphalconfreemium;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class TC001_GET_Request {

	@Test
	//One Test Case
	void getReguest() {
		// Specify the base URI
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";

		// Request object
		RequestSpecification httpRequst = RestAssured.given();

		// Responsce Object
		Response response = httpRequst.request(Method.GET, "/Hyderabad");

		// Print response in the console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body  ::  " + responseBody);

		// How to verify status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code  ::  " + statusCode);
		Assert.assertEquals(200, statusCode);

		
		// How to verify status Line validation
		String statusLine = response.getStatusLine();
		System.out.println("Status Code  ::  " + statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);

	}

}
