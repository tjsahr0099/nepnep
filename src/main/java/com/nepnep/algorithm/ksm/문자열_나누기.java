package com.nepnep.algorithm.ksm;

/** 
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108?language=java
 * @author 사용자
 *
 */
public class 문자열_나누기 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		System.out.println(s.solution("aaabbaccccabba"));
				
		
	}
	
}

class Solution {

	public int solution(String s) {
        int answer = 0;
        
        while(s.length()!=0) {
        	
	        String _s = roof(s);
	        if(s == _s) {
	        	break;
	        }
	        s = _s;
	        answer++;
	        
        }                
        
        return answer;
    }
     
    public String roof(String s) {
    	
    	char[] cArray = s.toCharArray();
    	
    	char x = cArray[0];
        int eq = 0;
        int ne = 0;        
        
        for (char c : cArray) {
			if(x==c) {
				eq++;
			}else {
				ne++;
			}
			
			if(eq==ne) {
				break;
			}
		}
        
        return s.substring(eq+ne);
    }
}