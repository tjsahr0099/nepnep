package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.Comparator;

public class 명예의_전당 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] score = {100, 10, 20, 20, 30, 100};
		sol.solution(3, score);
	}

}

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<score.length; i++) {
            
            if(i < k) {
            	arrayList.add(score[i]);
            	arrayList.sort(Comparator.reverseOrder());
                answer[i] = arrayList.get(i);
            } else {
            	arrayList.add(k, score[i]);  
            	arrayList.sort(Comparator.reverseOrder());
            	arrayList.remove(k);
                answer[i] = arrayList.get(k-1);
            }   
        }
        
        return answer;
    }
}