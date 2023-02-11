package com.nepnep.algorithm;

/**
 * @author 이지영
 * 2023. 2. 11.
 */
public class 둘만의_암호 {

	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		
		둘만의_암호 password = new 둘만의_암호();
		
		System.out.println(password.solution(s, skip, index));
	}

	public String solution(String s, String skip, int index) {
        String answer = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        // 알파벳에서 skip에 있는 알파벳 제외
        for(String skipA : skip.split("")){
            alphabet = alphabet.replace(skipA, "");
        }
        
        for(String targetA : s.split("")){
            // 알파벳 길이를 벗어나면 되돌아감 (알파벳의 길이로 나눈 나머지 위치에 있는 문자열로 변경)
            int point = alphabet.indexOf(targetA) + index < alphabet.length() ?
                alphabet.indexOf(targetA) + index : (alphabet.indexOf(targetA) + index) % alphabet.length();
            // 문자열에서 index 만큼 뒤의 알파벳을 answer 에 추가
            answer += alphabet.charAt(point);
        }
        
        return answer;
    }
}
