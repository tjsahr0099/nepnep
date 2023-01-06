package com.nepnep.algorithm;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * @author ksm
 * 2023. 1. 3.
 */
public class 기사단원의무기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new 기사단원의무기().solution(5, 3, 2));
		
//		System.out.println((int)Math.sqrt(2));

	}

	public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 1번 기사부터 number번 기사까지 존재함.
        for(int num=1 ; num<=number ; num++) {
        	//약수의 갯수 구하기
        	int yacsu = 0;
        	for(int x=1;x<=Math.sqrt(num);x++) {
        		//나머지가 0이면 약수
        		if(num%x==0) {
        			if(Math.sqrt(num)==x) {
            			// 제곱근이 약수일 경우 중복으로 1개만 플러스
        				yacsu++;
        			}else {
        				// 약수는 쌍으로 이루어져 있어서 2개씩 플러스
        				yacsu=yacsu+2;
        			}
        			
        			
        			// 제한수치를 넘을경우 power만큼을 할당한다.
        			if(yacsu>limit) {
        				yacsu = power ; 
        				break;
        			}
        		}
        	}
        	
        	answer+=yacsu;
        	
        }
        
        return answer;
    }
	
}
