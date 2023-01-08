package com.nepnep.algorithm;

/**
 * @author 이지영
 * 2023. 1. 7.
 */
public class 신규_아이디_추천 {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		
		신규_아이디_추천 s = new 신규_아이디_추천();
		
		System.out.println(s.solution(new_id));

	}
	
	public String solution(String new_id) {
        // 소문자로 치환
        new_id = new_id.toLowerCase();
        
        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        // 마침표(.)가 처음이나 끝에 위치한다면 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        
        // 빈 문자열이면 "a"를 대입
        new_id = new_id.length() == 0 ? "a" : new_id;
        
        // 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        // 제거 후 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        new_id = new_id.length() >= 16 ? new_id.substring(0,15).replaceAll("\\.$", "") : new_id;
        
        // 길이가 2자 이하면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        for(int i = new_id.length(); i < 3 ; i++){
            new_id = new_id + new_id.substring(i-1,i);
        }
        
        return new_id;
    }
}
