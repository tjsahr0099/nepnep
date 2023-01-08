package com.nepnep.algorithm;

public class 기사단원의_무기 {

	public static void main(String[] args) {
		int number = 5;
		int limit = 3;
		int power = 2;
		
		기사단원의_무기 s = new 기사단원의_무기();
		
		System.out.println(s.solution(number, limit, power));
	}
	
	public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 기사단으로 for 문
        for(int i = 1; i <= number; i++){
            // 약수의 개수(=공격력)
            int measureCnt = 0;
            // 나누어 떨어지면 약수의 개수 추가
            for(int j = 1; j <= i; j++){
                if(i % j == 0) measureCnt += 1;
            }
            // 공격력이 제한수치를 초과한 경우, 제한수치를 초과한 기사가 사용할 무기의 공격력만큼 철을 추가
            if(measureCnt > limit){
                answer += power;
            }else{
                // 공격력이 제한수치 이하인 경우, 공격력만큼 철을 추가
                answer += measureCnt;
            }
        }
        
        return answer;
    }
}
