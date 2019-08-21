/**
 * 
 */
package com.app.abst;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

/**
 * @author deepa
 *
 */
public class SetUpClass {
	
	
	@BeforeSuite
	public void setUpEndPoint(){
		 //https://api.spotify.com/v1/albums
		//RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		//RestAssured.basePath="";
		//https://jsonplaceholder.typicode.com/posts/1
		
		
		//http://localhost:3000/
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=3000;
		
	}

}
