/**
 * 
 */
package com.app.ApiTesting;

import org.testng.annotations.BeforeMethod;
import org.assertj.core.util.Arrays;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import com.app.abst.Params;
import com.app.abst.SetUpClass;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

/**
 * @author deepa
 *
 */
public class TestGetRequestApi extends SetUpClass {

	
	//body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
		
		@Test(description=" validating api  :   /docs/_albums/GET ", priority=0)
		public void _testPostApi(){
			System.out.println(given().when().get("/posts/2").asString());
			given().when().get("/posts/2").then().body("userId",equalTo(new Integer(1)));
			//given().when().get("/posts/1").then().assertThat().statusCode(200).and().body(containsString("sunt aut facere repellat provident occaecati exceptri optio reprehenderit"));
			//System.out.print(given().when().get("/posts").getBody().asString());
		}
		
		@Test(priority=1 ,description="/users")
		public void _testValidateGetBody(){
			String[] strArr = {"Kulas Light", "Victor Plains", "Douglas Extension", "Hoeger Mall", "Skiles Walks", "Norberto Crossing", "Rex Trail", "Ellsworth Summit", "Dayna Park", "Kattie Turnpike"};
			ArrayList<String> data  = (ArrayList) Arrays.asList(strArr);
			System.out.println(" > "+data);
			given().when().get("/users").then().body("address.street", hasSize(10));
			given().when().get("/users").then().body("address.street", contains(strArr));
		}
		
		
		@Test(priority=3)
		public void _testValidateUserID2(){
			given().when().get("/todos/1").then().body("userId", equalTo(new Integer(1)));
		}
		
		
		@Test(priority=4)
		public void _testValidateUserID3(){
			given().when().get("/users/1").then().body("address.zipcode", equalTo("92998-3874"));
		}
	
	
}
