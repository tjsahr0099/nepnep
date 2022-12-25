package com.nepnep.algorithm.ksm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502?language=java
 * @author 사용자
 *
 */
public class 햄버거_만들기 {
	
	public static void main(String[] args) {
		
		// 어느정도 남는 경우 테스트 필요
//		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		// 전체가 다 사용되는 경우 테스트 필요
		int[] ingredient = {1,2,3,1,1,2,3,1,1,2,3,1};
		
		// 하나도 안만들어지는 경우 테스트 필요
//		int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
//		
//		
		Solution3 s = new Solution3();
		int result = s.solution(ingredient);
		
		System.out.println(result);
		
		
	}

}

class Solution3 {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> hamberger = new ArrayList<Integer>();
        hamberger.add(1);
        hamberger.add(2);
        hamberger.add(3);
        hamberger.add(1);
        
        List<Integer> list = new ArrayList<Integer>();        
        
        for(int a : ingredient) {
        	list.add(a);
        }
        
        int index = 0;
        while(true) {
        	
        	// 사이즈가 인덱스+4보다 낮을 경우 더 이상 햄버거를 만들 수 없음 - 앞으로 필요한 사이즈가 3 이하
        	
        	if(list.size()<index+4) {
    			break;
    		}        	
        	
        	// 햄버거가 만들어지는 경우
        	if(hamberger.equals(list.subList(index, index+4))){        		
        		
        		// 결과 갯수롤 올림
        		answer++;
        		
        		// 햄버거 재료를 리스트에서 삭제함. 인덱스 번호를 삭제하면 한칸씩 떙겨지기 떄문에 같은 인덱스로 4번 제거
        		list.remove(index);
        		list.remove(index);
        		list.remove(index);
        		list.remove(index);
        		
        		// 앞과 뒤가 붙어서 햄버거가 만들어지는 경우를 체크함. 123 1231 1 의 경우는 불가능하므로(앞이 먼저 만들어짐) 12 1234 31 의 경우가 최소임 그래서 -2함.
        		// 2로 했을 경우 실패가 많음. 3으로 했을 경우 4와 같은 결과 2개 실패함. -> 삭제되는 경우 index의 증가가 안되어야 하는 것이었음.        		
        		index = ( index - 2 < 0 ) ? 0 : index - 2 ;
        	}else {
        		index++;
        	}
        	
//        	System.out.println(index + " : " + list.size());
        	
        	
        }
        
        
        return answer;
    }
    
   
}