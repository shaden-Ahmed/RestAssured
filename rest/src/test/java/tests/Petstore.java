package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;


public class Petstore {
	@Test
	void TestGet() {
		Response response = get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}
	@Test
	public void TestGet2() {
		baseURI = "https://petstore.swagger.io/";
		
		given().
			get("v2/pet/findByStatus?status=available").
		then().
			statusCode(200);
			body("x[0].status",equalTo("available"));
			
		
	}

}