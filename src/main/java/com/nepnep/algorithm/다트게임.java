package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ksm
 * 
 * 20230204
 *
 */
public class 다트게임 {

	public static void main(String[] args) {
		
		new 다트게임().solution("1D2S#10S");
	}
	
	public int solution(String dartResult) {
        int answer = 0;
        
        List<String> sList = new ArrayList<String>();
        char[] cArray = dartResult.toCharArray();
        
        String temp = "";
        for(int i=0;i<cArray.length;i++) {
        	
        	if(cArray[i]=='S' || cArray[i]=='D'  || cArray[i]=='T') {
        		
        		temp = temp + cArray[i];
        		
        		if(((i+1) < cArray.length) && (cArray[i+1]=='*' || cArray[i+1]=='#')) {
        			i++;
        			temp = temp + cArray[i];        		
        		}
        		sList.add(temp);
        		temp = "";
        	}else {
        		temp = temp + cArray[i];	
        	}
        	
        }
        
        
        int[] calArray = new int[3];
        
        int index = 0;
        
        for(String s : sList) {
        	String[] split = {};
        	String bonus = "";
        	
        	
        	// D S T 구분
        	if(s.split("D")[0].length() != s.length()) {
        		split = s.split("D");
        		bonus = "D";
        	}
        	if(s.split("S")[0].length() != s.length()) {
        		split = s.split("S");
        		bonus = "S";
        	}
        	if(s.split("T")[0].length() != s.length()) {
        		split = s.split("T");
        		bonus = "T";
        	}
        	
        	
        	// 계산할 정수 + 제곱 
    		if("S".equals(bonus)) {
    			calArray[index] = Integer.parseInt(split[0]);
    		}
			if("D".equals(bonus)) {
				calArray[index] = (int) Math.pow(Integer.parseInt(split[0]), 2);       			
    		}
			if("T".equals(bonus)) {
				calArray[index] = (int) Math.pow(Integer.parseInt(split[0]), 3);    
			}
			
			//길이가 1이면 *#이 없음	
			if(split.length!=1) {
        	
        		String option = split[1];
        		if(option.equals("*")) {
        			calArray[index] = calArray[index] * 2;
        			if(index!=0) {
        				calArray[index-1] = calArray[index-1] * 2;
        			}
        		}
        		if(option.equals("#")) {
        			calArray[index] = calArray[index] * -1;
        		}        		
        		
        	}
        	index++;
        }
        
        for(int cal : calArray) {
        	answer = answer + cal;
        }
        
        return answer;
    }

}
