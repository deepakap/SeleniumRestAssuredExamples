/**
 * 
 */
package com.app.test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.assertj.core.util.Arrays;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import com.app.abst.Params;
import com.app.abst.SetUpClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.restassured.RestAssured;


public class ValidateApi {
	
	
	@BeforeClass
	public void setUp(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	}
	
	
	@Test(priority=0)
	public void _testGetComments(){
		given().when().get("/comments").then().assertThat().statusCode(200);
		given().when().get("/posts").then().assertThat().statusCode(200);
	}
	
	
	//https://jsonplaceholder.typicode.com/posts/1/comments
	// https://jsonplaceholder.typicode.com/comments
	
	@Test
	public void _testComparePostAndComments(){
		
		//System.out.print(" > "+);
		List<String> jsonResponse1 = given().when().get("/comments?postId=1").jsonPath().getList("$");
		
		
		System.out.print(" posts/1/comments >>> "+jsonResponse1.size());
		int count=0;
		
		
		List<String> jsonResponse = given().when().get("/comments").jsonPath().getList("$");

		
		System.out.print(" >>>"+jsonResponse.size());
		
//		Iterator<String> itr = jsonResponse.iterator();
//		while(itr.hasNext()){
//			System.out.println(" each comments  "+i);
//			
//		}
		
//		
//        for(String str: jsonResponse){
//        	
//        	System.out.println(" each comments  "+str);
//        	
//        }
		
//		for(Response rsp:given().when().get("/comments")){
//			
//		}
		
		
		
	}
	
	
	
	

}
