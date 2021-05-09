package tipphalconfreemium;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_POST_Request {
	@Test
	void getMultipleData() {
		// Specify the base URI
				RestAssured.baseURI = "https://restapi.demoqa.com/customer";

				// Request object
				RequestSpecification httpRequst = RestAssured.given();

				//Request Payload sending to the post request
				JSONObject requestParams=new JSONObject();
				requestParams.put("FirstName", "Jhon");
				requestParams.put("LastName", "Josph");
				requestParams.put("UserName", "jhonkumar");
				requestParams.put("Password", "Infi@123");
				requestParams.put("Email", "Infi@123");
				
				//we need to specify the header
				httpRequst.header("Content-Type","application/json");
				//attach data to the request
				httpRequst.body(requestParams.toJSONString());
				
				//how to send the request
				// Responsce Object
				Response response = httpRequst.request(Method.POST, "/register");
				
				//Print the response body to the console
				String responseBody=response.getBody().toString();
				System.out.println("response Body  ::  "+responseBody);
				Assert.assertEquals(responseBody.contains("Jhon"), true);

				// How to verify status code validation
				int statusCode = response.getStatusCode();
				System.out.println("Status Code  ::  " + statusCode);
				Assert.assertEquals(201, statusCode);
				
				//Success code validation
				String successCode=response.jsonPath().get("SuccessCode");
				Assert.assertEquals(successCode, "Operation_Suceess");
				

	}

}
