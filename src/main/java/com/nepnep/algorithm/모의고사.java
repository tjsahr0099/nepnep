package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SolutionGosa gosa = new SolutionGosa();
		int[] answer = {1,2,5,4,1,2,4,5};
		gosa.solution(answer);
	}

}

class SolutionGosa {
    public int[] solution(int[] answers) {

    	 int[] one = {1,2,3,4,5}; 
         int[] two = {2,1,2,3,2,4,2,5}; 
         int[] three = {3,3,1,1,2,2,4,4,5,5}; 
         int[] score = {0,0,0};
    	
         for(int i=0; i<answers.length; i++) 
         {
             if(answers[i] == one[i%5]) 
            	 score[0]++;
             if(answers[i] == two[i%8]) 
            	 score[1]++;
             if(answers[i] == three[i%10]) 
            	 score[2]++;
         }
         
         //최대 점수
         int max = Math.max(score[0], Math.max(score[1], score[2]));
         
         List<Integer> list = new ArrayList<Integer>();
         for(int i=0; i<score.length; i++)
         {
        	 if(max == score[i])
        	 {
        		 list.add(i+1);
        	 }	
         }
         
         int[] answer = new int[list.size()];
         
         for(int i=0; i<list.size(); i++){
             answer[i] = list.get(i);
         }

         return answer;
    }
}