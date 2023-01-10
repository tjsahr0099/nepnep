package com.nepnep.algorithm;

import java.util.HashMap;
import java.util.Map;

public class 개인정보_수집_유효기간 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] terms =  {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		new 개인정보_수집_유효기간().solution("2022.05.19", terms, privacies);
		
	}

	public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        // terms to map
        Map<String,String> termsMap = new HashMap<String,String>();
        for(String term : terms) {
        	termsMap.put(term.split(" ")[0], term.split(" ")[1]);
        }
        
        // check privacies
        for(String privacy : privacies) {
        	
        	String privacyDay = privacy.split(" ")[0];
        	String privacyTerm = termsMap.get(privacy.split(" ")[1]);
        	
        	int diff = Integer.parseInt(today.split("\\.")[1]) - Integer.parseInt(privacyDay.split("\\.")[1]) ;
        	if(diff<0) {
        		diff = diff + 12 - Integer.parseInt(privacyTerm);
        	}
        	
        	
        	 
        	System.out.println(diff);
        	
        }
        
        return answer;
    }
	
}
