package com.nepnep.algorithm;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 * @author ksm
 * 2023. 1. 3.
 */
public class 옹알이2 {

	public static void main(String[] args) {
		
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		
		옹알이2 s = new 옹알이2();
        
        
        System.out.println(s.solution(babbling));

	}
	
	public int solution(String[] babbling) {
		int answer = 0;
		
		// 네 가지 발음의 조합 "aya", "ye", "woo", "ma" , 연속해서 같은 발음은 못함.
		
		// 전체 babbling을 검사한다.
		for(String str : babbling) {
			
			// 이전 옹알이 저장
			String beforeBabbling = "";
			
			// 단건 단어를 앞에서부터 검사하기 위해 반복문을 돌린다
			while(true) {				
				
				if(str.startsWith("aya")) {
					// 이전 옹알이와 같으면 더이상 발음하지 못한다.
					if( beforeBabbling.equals("aya")) {
						break;
					}
					str = str.substring(3);
					beforeBabbling = "aya";
				} else if(str.startsWith("ye")) {
					if( beforeBabbling.equals("ye")) {
						break;
					}
					str = str.substring(2);	
					beforeBabbling = "ye";
				} else if(str.startsWith("woo")) {
					if( beforeBabbling.equals("woo")) {
						break;
					}
					str = str.substring(3);
					beforeBabbling = "woo";
				} else if(str.startsWith("ma")) {
					if( beforeBabbling.equals("ma")) {
						break;
					}
					str = str.substring(2);
					beforeBabbling = "ma";
				} else {
					// 단어를 모두 발음했으면 성공 카운트를 올린다.
					if(str.length()==0) {
						answer++;
					}
					break;
				}
			}			
		}
		
		
        return answer;
    }

}
