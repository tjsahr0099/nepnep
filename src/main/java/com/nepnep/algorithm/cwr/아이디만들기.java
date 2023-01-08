package com.nepnep.algorithm.cwr;

public class 아이디만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String strId = "new_id";
		Solution5 sol = new Solution5();
			System.out.println(sol.solution(strId));				
	}
}

class Solution5 {
    public String solution(String new_id) {
        String answer = "";
        
        //1단계 소문자
        new_id = new_id.toLowerCase();
        //2단계 특정 단어 아니면 제거 
        new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
        //3단계 마침표 반복 이면 한번으로
        new_id = new_id.replaceAll("[.]{2,}", ".");
        //4단계 마침표 처음 끝 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        //5단계
        if(new_id.length() == 0)
        	new_id = "a";
        
        //6단계
        if (new_id.length() >= 16) {     // 6단계
        	new_id = new_id.substring(0, 15);
        	new_id = new_id.replaceAll("[.]$","");
        }
        
        //7단계
        if (new_id.length() <= 2) {  // 7단계
            while (new_id.length() < 3) {
            	new_id += new_id.charAt(new_id.length()-1);
            }
        }
        
        answer = new_id;
        
        return answer;
    }
}