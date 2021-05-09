package tipphalconfreemium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request {
	@Test
	//One Test Case
	void getAllHeaders() {
		// Specify the base URI
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request object
		RequestSpecification httpRequst = RestAssured.given();

		// Responsce Object
		Response response = httpRequst.request(Method.GET, "/Hyderabad");

		// Print response in the console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body  ::  " + responseBody);
		
		//get all headers
		Headers getAllHeaders=response.headers();
		
		for(Header getHeaders:getAllHeaders)
		{
			System.out.println(getHeaders.getName()+"    "+getHeaders.getValue());
		}
		

	}

}
