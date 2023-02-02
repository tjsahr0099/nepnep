package com.nepnep.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 실패율 {

	public static void main(String[] args) {
						
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		int[] answer = new 실패율().solution(N, stages);
		
		for(int x : answer) {
			System.out.println(x);
		}
	}
	
	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int sum = 0;
        HashMap<Integer,Float> map = new HashMap<Integer,Float>();
        
        for(int i=1 ; i<=N+1 ; i++) {
        	int cnt = 0;
        	for(int s : stages) {
        		if( s == (i-1) ) {
        			cnt++;
        		}
        	}
        	if(i!=1) {
        		
        		float f = (float)cnt/(stages.length-sum);
        		System.out.println(f);
        		map.put(i-1, f);        		

        	}
        	sum = sum + cnt;        	

        }
        
       
        HashMap<Integer,Float> hashMap = sortByValue(map);
        int i=0;
        for(Integer key : hashMap.keySet()){        	 
 
            System.out.println(key);
            
            answer[i++] = key;
 
        }

        return answer;
    }
	
	public HashMap<Integer,Float> sortByValue(HashMap<Integer,Float> hm){
	    // Create a list from elements of HashMap
	    List<Map.Entry<Integer,Float> > list = new LinkedList<Map.Entry<Integer,Float> >(hm.entrySet());

	    // Sort the list using lambda expression
	    Collections.sort(list, (i2, i1) -> i1.getValue().compareTo(i2.getValue()));

	    // put data from sorted list to hashmap
	    HashMap<Integer,Float> temp = new LinkedHashMap<Integer,Float>();
	    for (Map.Entry<Integer,Float> aa : list) {
	        temp.put(aa.getKey(), aa.getValue());
	    }
	    return temp;
	}

}
