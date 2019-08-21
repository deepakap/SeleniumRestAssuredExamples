/**
 * 
 */
package com.app.algo;

/**
 * @author deepa
 *
 */
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        System.out.println("Print group of anagram list");
        
        HashMap<String, LinkedList<String>> hm = new HashMap<String, LinkedList<String>>();
        String[] strs = {"sel","les","ltop","lopt","lpto","lotp","max"};
        List data = Arrays.asList(strs);
        
        System.out.println(" > "+data.toString());
        String result;
        
        String tmp;
        
        for(Object str: data){
            tmp = (String) str;
            result = isAnagramString(tmp);
            if(hm.containsKey(result)){
                hm.get(result).add(tmp);
            }else{
                LinkedList<String> lst = new LinkedList<String>();
                lst.add(result);
            	hm.put(result, lst);
            }
        }
        
        
        
        Iterator itr = hm.keySet().iterator();
        
        while(itr.hasNext()){
        
            String key = (String) itr.next();
            System.out.println(" value > "+hm.get(key));
        }
        
        
    }
    
    
    public static String isAnagramString(String str){
    
    char[] chrData =  str.toCharArray();
    Arrays.sort(chrData);
    return new String(chrData);
    }
    
    
    }
