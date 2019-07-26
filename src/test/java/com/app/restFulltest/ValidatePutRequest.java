/**
 * 
 */
package com.app.restFulltest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author deepa
 *
 */
public class ValidatePutRequest {
	
	RequestSpecification rs;
	
	@BeforeClass
	public void setUrl(){
		RestAssured.baseURI="https://reqres.in/";
		rs = RestAssured.given();
		
	}
	
	@Test
	public void _testPutreq(){
		rs.headers("Content-Type", "application/json");
		JsonObject reqObj =  new JsonObject();
		reqObj.addProperty("name", "baka");
		reqObj.addProperty("job", "Test Engineer !");
		rs.body(reqObj);
		Response resp = rs.put("/api/users/3");
		Assert.assertEquals(resp.getStatusCode(), 200);
		Assert.assertEquals(resp.jsonPath().getString("name"), "baka");
		
	}

}
