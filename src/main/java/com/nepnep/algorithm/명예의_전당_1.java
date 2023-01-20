package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class 명예의_전당_1 {

	public static void main(String[] args) {
		int k = 3;
		int[] score = {10, 100, 20, 150, 1, 100, 200};
		
		// int k = 4;
		// int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
		
		명예의_전당_1 s = new 명예의_전당_1();
		
		for(int i : s.solution(k, score)) {
			System.out.println(i);
		}
	}

	public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> honor = new ArrayList<>();
        
        for(int j = 0; j < score.length; j++){
            // 해당 점수가 k 번째 이내면 명예의 전당에 추가
            if(honor.size() < k){
                honor.add(score[j]);
            }else if(honor.get(honor.size()-1) < score[j]){
                // 해당 점수가 k 번째 이후면서 가장 낮은 점수보다 높으면 해당 점수 명예의 전당에 추가
                honor.set(honor.size()-1, score[j]);
            }
            // 명예의 전당 점수 내림차순으로 정렬
            Collections.sort(honor, Collections.reverseOrder());
            // 가장 낮은 점수(가장 마지막에 있는 점수)를 발표 점수에 추가
            answer[j] = honor.get(honor.size()-1);
        }
        
        return answer;
    }
}
