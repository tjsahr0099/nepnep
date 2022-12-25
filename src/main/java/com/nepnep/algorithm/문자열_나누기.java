package com.nepnep.algorithm;

/**
 * TODO : 저자 변경필요
 * @author 이지영
 * 2022. 12. 25.
 */
public class 문자열_나누기 {

	public static void main(String[] args) {
		String test = "banana";
		// String test = "abracadabra";
		// String test = "aaabbaccccabba";
		
		문자열_나누기 s = new 문자열_나누기();
		
		System.out.println(s.solution(test));
	}
	
	public int solution(String s) {
    	
    	int answer = checkString(s);
        
        return answer;
    }    
     
    public int checkString(String s){
    	int answer = 0;
        String firstString = "";
        int sameCnt = 0;
        int diffCnt = 0;
        answer += 1;
        
        for(int i = 0; i < s.length(); i++){
            if(i == 0){
            	// 첫 글자를 읽고, 첫 글자가 나온 횟수 1회 추가
                firstString = s.substring(i, i+1);
                sameCnt += 1;
            }else{
                if(firstString.equals(s.substring(i, i+1))){
                	// 첫 글자와 같으면, 첫 글자가 나온 횟수 1회 추가
                    sameCnt += 1;
                }else{
                	// 첫 글자와 다르면, 다른 글자가 나온 횟수 1회 추가
                    diffCnt += 1;
                }
                
                // 첫 글자가 나온 횟수와 다른 글자가 나온 횟수가 같으면, 이후 문자열로 함수 재실행(재귀 함수) 
                if(sameCnt == diffCnt){
                    if(i+1 != s.length()){
                        return checkString(s.substring(i+1, s.length())); 
                    }
                }
            }
        }
        
        return answer;
    }

}
