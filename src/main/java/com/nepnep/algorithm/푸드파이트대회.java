package com.nepnep.algorithm;

public class 푸드파이트대회 {

	public static void main(String[] args) {
		
		int[] food = {1, 3, 4, 6};
		
		new 푸드파이트대회().solution(food);

	}
	
	public String solution(int[] food) {
        String answer = "";
        
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<food.length;i++) {
        	if(i==0) {
        		answer = "0";
        		continue;
        	}
        	
        	
        	for(int j=0;j<(int)food[i]/2;j++) {
        		sb.append(i);
        	}
        	
        }
        
        answer = sb.toString()+answer+sb.reverse().toString();        
        
        return answer;
    }

}
