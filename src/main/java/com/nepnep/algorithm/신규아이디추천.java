package com.nepnep.algorithm;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 * @author ksm
 * 2023. 1. 3.
 */
public class 신규아이디추천 {

	public static void main(String[] args) {
//		new 신규아이디추천().solution("=.=");
		
		System.out.println(new 신규아이디추천().solution("=.=")) ;
	}
	
	public String solution(String new_id) {
        String answer = "";        
        
        // 1. 모든 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();        
        
        // 2. 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거        
        new_id = new_id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]","");        
        
        // 3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = new_id.replaceAll("\\.+",".");        
        
        // 4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(new_id.substring(0, 1).equals(".")) { 
        	if(new_id.length()>1) {
        		new_id = new_id.substring(1, new_id.length());
        	}else {
        		new_id = "";
        	}
        }
        if(new_id.length()!=0) {
	        if(new_id.substring(new_id.length()-1, new_id.length()).equals(".")) {
	        	new_id = new_id.substring(0, new_id.length()-1);	
	        }        
        }
        
        // 5. new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.equals("")) {
        	new_id = "a";
        }
        
        // 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length()>=16) {
        	new_id = new_id.substring(0,15);
        }
        if(new_id.substring(new_id.length()-1, new_id.length()).equals(".")) {
        	new_id = new_id.substring(0, new_id.length()-1);	
        }
        
        // 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length()<=2) {
        	String lastStr = new_id.substring(new_id.length()-1, new_id.length());
        	new_id = new_id + lastStr;
        	if(new_id.length()!=3) {
        		new_id = new_id + lastStr;
        	}
        }

        answer = new_id;
        
        return new_id;
    }

}
