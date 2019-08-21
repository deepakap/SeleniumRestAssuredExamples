package com.app.test;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class ArrayPairOfSum {
	// [2, 3, 4, 1, 5, 0] 5
	
	public static void main(String args[]){
		int[] data =  {2, 3, 4, 1, 5, 0,-6,11};
		int sumPair = 5;
		HashMap<Integer, Integer> hm = sumArray(data, sumPair);
		
		System.out.println("Given Test data "+Arrays.toString(data)+" , sum of pairs should be "+sumPair);
		System.out.println("----------------------------------------------------------------------------");
		Iterator<Entry<Integer, Integer>> itr = hm.entrySet().iterator();
		while(itr.hasNext()){
			int key = itr.next().getKey();
			System.out.println("Array pairs are : "+Arrays.toString(printArrayPairs(key, hm.get(key))));
		}
	}
	
	
	public static HashMap<Integer, Integer> sumArray(int[] data, int sum){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		HashSet<Integer> hs = new HashSet<Integer>();
		int total;
		for(int i=0;i<data.length;i++){
			total = sum-data[i];
			if(hs.contains(total)){
				hm.put(data[i], total);
			}else{
				hs.add(data[i]);
			}
		}
		return hm;
	}
	
	public static int[] printArrayPairs(Integer key, Integer value){
		int i=0;
		int result[] = new int[2];
		result[i]=key;
		i++;
		result[i]=value;
		return result;
	}
	
	

}
