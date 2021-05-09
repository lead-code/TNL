package tipphalconfreemium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCOO3_GET_Request {
	@Test
	//One Test Case
	void getReguest() {
		// Specify the base URI
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request object
		RequestSpecification httpRequst = RestAssured.given();

		// Responsce Object
		Response response = httpRequst.request(Method.GET, "      ");

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
		
		
		//Validating Headers 
		String contentType=response.header("Content-Type"); //capture deatils Headers from Response
		Assert.assertEquals(contentType, "application/xml");
		
		String contentEncoding=response.header("Content-Encoding"); //capture deatils Headers from Response
		Assert.assertEquals(contentEncoding, "gzip");
	}

}
