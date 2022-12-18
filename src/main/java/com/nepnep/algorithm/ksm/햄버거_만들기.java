package com.nepnep.algorithm.ksm;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502?language=java
 * @author 사용자
 *
 */
public class 햄버거_만들기 {
	
	public static void main(String[] args) {
		
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		Solution3 s = new Solution3();
		int result = s.solution(ingredient);
		
		System.out.println(result);
	}

}

class Solution3 {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        String str = "";
        
        for(int i=0;i<ingredient.length;i++) {        	
        	str+=ingredient[i];  	
        } 
        
        Map<String,Object> answerMap = new HashMap<String,Object>();
        answerMap.put("ingredient_str", "@"+str+"@");
        answerMap.put("answer", 0);
        
        while(true) {
        	answerMap = roof(answerMap);
//        	System.out.println(answerMap.toString());
        	if(answerMap.get("exit")!=null && (boolean) answerMap.get("exit")) {
        		break;
        	}
        }
        
        
        
        return (int) answerMap.get("answer");
    }
    
    public Map<String,Object> roof( Map<String,Object> input) {
    	
//    	System.out.println(input.toString());
    	
    	String[] strArray = input.get("ingredient_str").toString().split("1231");
    	int length = strArray.length;
    	
    	String str = "";
    	
    	Map<String,Object> res = new HashMap<String,Object>();
        
//    	System.out.println("length : " + length);
    	
        if(length<=1) {
        	res.put( "answer", (int)input.get("answer"));
        	res.put( "exit", true );
        }else {
        	
        	for(int i=0;i<length;i++) {        	
            	str+=strArray[i];  	
            }
        	
        	
        	res.put( "answer", (int)input.get("answer")+(length-1) );
        	res.put( "ingredient_str", str );
        
        	
        }
        
        return res; 
    }
}