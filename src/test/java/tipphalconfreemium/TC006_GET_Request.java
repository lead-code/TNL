package tipphalconfreemium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_Request {
	@Test
	// One Test Case
	void verifyAuthunticationAPIs() {
		// Specify the base URI
		RestAssured.baseURI = "https://restapi.demoqa.com/authentication/Checkforauthentication";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme authSchem=new PreemptiveBasicAuthScheme();
		authSchem.setUserName("User");
		authSchem.setPassword("Imn@123");
		RestAssured.authentication=authSchem;

		// Request object
		RequestSpecification httpRequst = RestAssured.given();

		// Responsce Object
		Response response = httpRequst.request(Method.GET, "/");

		// Print response in the console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body  ::  " + responseBody);
		
		// How to verify status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code  ::  " + statusCode);
		Assert.assertEquals(200, statusCode);


	}

}
