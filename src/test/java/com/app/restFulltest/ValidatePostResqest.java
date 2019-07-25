/**
 * 
 */
package com.app.restFulltest;

import java.util.HashMap;

import org.openqa.selenium.json.Json;
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
public class ValidatePostResqest {
	
	
	@BeforeClass
	public void setUp(){
		RestAssured.baseURI="https://reqres.in/";
	}
	
	
	@Test
	public void _test_PostApi(){
		
		RequestSpecification rs = RestAssured.given();
		JsonObject hm = new JsonObject();
		
		hm.addProperty("name", "morpheus");
		hm.addProperty("job", "leader");
		
		rs.headers("Content-Type", "application/json");
		rs.body(hm.getAsJsonObject());
		Response resp = rs.post("api/users");
		
		
		System.out.print(" "+resp);
		Assert.assertEquals(resp.getStatusCode(), 201);
		System.out.print(" response is "+resp.getBody().asString());
		//Assert.assertEquals(resp.getBody().toString(), expected);
		Assert.assertEquals(resp.jsonPath().getString("name"), "morpheus");
		
		
		
		System.out.println(" response name "+resp.jsonPath().getString("createdAt"));

		
		
		
	}
	
	

}
