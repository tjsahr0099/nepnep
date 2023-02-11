package com.nepnep.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * @author 이지영
 * 2023. 2. 11.
 */
public class 모의고사 {

	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		
		모의고사 s = new 모의고사();
		
		System.out.println(s.solution(answers));
	}
	
	public int[] solution(int[] answers) {
        int[] pick1 = { 1, 2, 3, 4, 5 }; // 1번 수포자가 찍는 방식
        int[] pick2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 2번 수포자가 찍는 방식
        int[] pick3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 3번 수포자가 찍는 방식
        int[] sum = { 0, 0, 0 }; // 수포자들이 맞힌 문제 수
        List<Integer> winner = new ArrayList<Integer>(); // 가장 문제를 많이 맞힌 사람 리스트
        
        // 정답별로 채점
        for(int i=0; i < answers.length; i++){
            if(answers[i] == pick1[i % 5]) sum[0] += 1;
            if(answers[i] == pick2[i % 8]) sum[1] += 1;
            if(answers[i] == pick3[i % 10]) sum[2] += 1;
        }
        
        // 가장 높은 점수
        int max = Arrays.stream(sum).max().getAsInt();
        // 가장 높은 점수 받은 사람을 가장 문제를 많이 맞힌 사람 리스트에 추가
        for(int j=0; j < sum.length; j++){
            if(max == sum[j]) winner.add(j+1);
        }
        // 리스트를 배열로 변환
        int[] answer = new int[winner.size()];
        for (int k = 0; k < winner.size(); k++) {
            answer[k] = winner.get(k);
        }
        
        return answer;
    }
}
