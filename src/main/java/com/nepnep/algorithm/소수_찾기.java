package com.nepnep.algorithm;

/**
 * @author 이지영
 * 2023. 2. 11.
 */
public class 소수_찾기 {

	public static void main(String[] args) {
		int answers = 10;
		
		소수_찾기 s = new 소수_찾기();
		
		System.out.println(s.solution(answers));
	}

	public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            if(isPrimeNumber(i)) answer += 1;
        }
        
        return answer;
    }
    
    // 소수인지 확인하는 함수
    public boolean isPrimeNumber(int num) {
        // 나누어 떨어지면 약수의 개수 추가
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                // 약수가 있으면 소수가 아님
                return false;
            }
        }
        // 1은 제외
        return num != 1;
    }
}
