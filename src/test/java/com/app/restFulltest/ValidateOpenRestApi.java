/**
 * 
 */
package com.app.restFulltest;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author deepa
 *
 */
public class ValidateOpenRestApi {
	
	
	@BeforeClass
	public void setUp(){
		RestAssured.baseURI="https://reqres.in";
	}
	
	@Test(priority=0)
	public void launchApi(){
		RequestSpecification rs =  RestAssured.given();
		Response resp =  rs.get("/api/users");
		System.out.print(" "+resp.getBody().asString());
		Assert.assertEquals(resp.getStatusCode(), 200, "Issue : status not matching !");
		
	}
	

}
