/**
 * 
 */
package com.app.ngTest;

import java.util.Collection;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author deepa
 *
 */
public class TestNgFeaturesCheck {
	
	@Test(enabled=true, description="print test data and message !",alwaysRun=true,priority=1,testName="sample test 1", expectedExceptions=ClassCastException.class)
	public void printData(){
		throw new ClassCastException();
	}
	
	public String reverseString(String s){
		
		char[] sdata = s.toCharArray();
		char temp;
		int k=sdata.length-1;
		for(int i=0;i<sdata.length/2;i++){
			
			temp=sdata[i];
			sdata[i]=sdata[k];
			sdata[k]=temp;
			k--;
		}
		
		return String.valueOf(sdata);
		
	}
	
	
	@Test(dataProvider="dataGenerator") @DataProvider(name="test")
	public Object[][] _testPrintAllData(String str1, String str2){
		System.out.println(" >>>> "+str1+":  "+str2);
		
		Object[][] obj=  new Object[2][2];
		
		if(str1.equals("Paul")){
			obj[0][0]= reverseString(str1);
			obj[0][1]= reverseString(str2);
		}else{
		obj[1][0]=reverseString(str1);
		obj[1][1]=reverseString(str2);
		}
		
		return obj;
	}
	
	
	@DataProvider(name="dataGenerator")
	public Object[][] generateData(){
		Object[][] obj=  new Object[2][2];
		obj[0][0]="John";
		obj[0][1]="Paul";
		obj[1][0]="Max";
		obj[1][1]="Mark";
		return obj;
		} 
	
	

}
