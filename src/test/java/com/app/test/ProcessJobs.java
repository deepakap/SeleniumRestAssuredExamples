package com.app.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import groovyjarjarantlr.collections.List;

public class ProcessJobs {
	
	
	//"running -> stop -> killed"
	
//	2. Input
//	time: 1, hash: 263d1a90b72e, status: running, cmd: bash
//	time: 2, hash: 8ce44d15cef1, status: running, cmd: bash
//	time: 3, hash: 263d1a90b72e, status: stop, cmd: bash
//	time: 4, hash: 263d1a90b72e, status: killed, cmd: bash
//	time: 5, hash: 263d1a90b72e, status: running, cmd: bash
//
//	3. Output
//	time: 1, hash: 263d1a90b72e, status: OK
//	time: 2, hash: 8ce44d15cef1, status: OK
//	time: 3, hash: 263d1a90b72e, status: OK
//	time: 4, hash: 263d1a90b72e, status: OK
//	time: 5, hash: 263d1a90b72e, status: Error

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	String[] state =  {"running","stop","killed"};
		
		
	LinkedList<String> data = new LinkedList<String>();
	data.add("time: 1, hash: 263d1a90b72e, status: running, cmd: bash");
	//data.add("time: 2, hash: 8ce44d15cef1, status: running, cmd: bash");
	data.add("time: 3, hash: 263d1a90b72e, status: stop, cmd: bash");
	data.add("time: 4, hash: 263d1a90b72e, status: killed, cmd: bash");
	data.add("time: 5, hash: 263d1a90b72e, status: running, cmd: bash");
	
	HashMap<String, String> hm = new HashMap<String, String>();
	for(String str: data){
		hm.put(buildProcessMappings(str), str);
		 ///  hm( "hash: 263d1a90b72e"    "time: 1, hash: 263d1a90b72e, status: running, cmd: bash"  )
	}
	
	
	System.out.print("  map is "+hm.toString());
	
	HashMap<String, String> resultMap = new HashMap<String, String>();
	
	Iterator<String> itr = hm.keySet().iterator();
	String statusVal;
	int k=0;
	while(itr.hasNext()){
		String key  = itr.next();
		if(!resultMap.containsKey(key)){
			resultMap.put(key, hm.get(key));
			if(resultMap.get(key).split(",")[2].contains(state[k])){
				System.out.print(hm.get(key)+" status: OK ");
				k=k+1;
			}
		}else{
			
			statusVal= resultMap.get(key).split(",")[2];
			if(statusVal.contains(state[k])){
				k=k+1;
			}else{
				System.out.print(hm.get(key)+" status: Error ");
			}
			
			
		}
		
	}
			
	}
	
	public static String buildProcessMappings(String str){
		String[] result = str.split(",");
		return result[1];
	}
	
	

}
