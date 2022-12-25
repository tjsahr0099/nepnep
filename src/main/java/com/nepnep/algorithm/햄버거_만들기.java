package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO : 저자변경필요
 * @author 웅렬
 * 2022. 12. 25.
 */
public class 햄버거_만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nIngredient = {2, 1, 1, 2, 3, 1, 2, 3, 1, 1, 2, 3, 1};
		
		햄버거_만들기 sol = new 햄버거_만들기();
		System.out.println(sol.solution(nIngredient));		
	}
	
	public int solution(int[] ingredient) {
        int answer = 0;
        
        ArrayList<Integer> intList = new ArrayList<Integer>();
        
       //재료 반복
       for (int nIngredi : ingredient)
       {
    	   //리스트에 재료 넣기
    	   intList.add(nIngredi);
    	   
    	   // 넣은 재료가 4개 이상일때
    	   if(intList.size() >= 4)
    	   {
    		   
    		   if(intList.get(intList.size() -4) == 1
    				   && intList.get(intList.size() -3) == 2
    				   && intList.get(intList.size() -2) == 3
    				   && intList.get(intList.size() -1) == 1
		   	   )		   
    		   {
    			 answer++;
    			 
    			 intList.remove(intList.size() - 4);
    			 intList.remove(intList.size() - 3);
    			 intList.remove(intList.size() - 2);
    			 intList.remove(intList.size() - 1);
    		   }    				   
    	   }
       }
        	
        return answer;
    }
	
}
