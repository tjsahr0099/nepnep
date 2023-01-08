package com.nepnep.algorithm.cwr;

public class 옹알이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

    String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
	Solution3 sol = new Solution3();
		System.out.println(sol.solution(babbling));	
		
	}

}

class Solution3 {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String str : babbling)
        {
        	if(str.contains("ayaaya") || str.contains("woowoo") || str.contains("yeye") || str.contains("mama"))
        		continue;
        	
        	String strWord = str;
        	
        	strWord = strWord.replaceFirst("aya", "");
        	strWord = strWord.replaceFirst("woo", "");
        	strWord = strWord.replaceFirst("ye", "");
        	strWord = strWord.replaceFirst("ma", "");
        	
        	if(strWord.length() == 0)
        		answer++;       			
        	
        }
        
        return answer;
    }
}
