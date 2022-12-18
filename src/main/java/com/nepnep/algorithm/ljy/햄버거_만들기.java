package com.nepnep.algorithm.ljy;

public class 햄버거_만들기 {

	public static void main(String[] args) {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		// int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
		Solution3 s = new Solution3();
		
		s.solution(ingredient);
	}

}

class Solution3 {
    int answer = 0;
    
    public int solution(int[] ingredient) {
        stackBuger(ingredient);
        
        return answer;
    }
    
    public int stackBuger(int[] ingredient){      
        for(int i = 0; i < ingredient.length; i++){
            if(ingredient[i] == 1 && i+4 < ingredient.length){
                for(int j = i+1; j < ingredient.length; j++){
                    if(ingredient[j] == 0){
                        continue;
                    }else if(j+2 < ingredient.length && ingredient[j] == 2 && ingredient[j+1] == 3 && ingredient[j+2] == 1){
                        answer += 1;
                        ingredient[i] = 0;
                        ingredient[j] = 0;
                        ingredient[j+1] = 0;
                        ingredient[j+2] = 0;

                        return stackBuger(ingredient);
                    }else{
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}