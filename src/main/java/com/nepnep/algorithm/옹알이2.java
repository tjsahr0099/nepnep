package com.nepnep.algorithm;

/**
 * @author 이지영
 * 2023. 1. 7.
 */
public class 옹알이2 {

	public static void main(String[] args) {
		String[] babbling = {"aya", "yee", "u", "maa"};
		// String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		
		옹알이2 s = new 옹알이2();
		
		System.out.println(s.solution(babbling));
	}
	
	public int solution(String[] babbling) {
        int answer = 0;
        
        for(String babble : babbling){
            babble = babble.replaceAll("aya", "1").replaceAll("ye", "2").replaceAll("woo", "3").replaceAll("ma", "4");
            
            // 정규식 사이트: https://regexper.com/
            // 연속해서 같은 발음이 없으며
            if(!babble.matches("(.*11.*|.*22.*|.*33.*|.*44.*)")){
                // 발음할 수 있는 단어로만 이루어진 경우
                if(babble.matches("[1-4]+")){
                    // 발음할 수 있는 단어의 개수 추가
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
}
