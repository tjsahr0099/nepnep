package com.nepnep.algorithm.ksm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java
 * @author 사용자
 *
 */
public class 신고_결과_받기 {

	public static void main(String[] args) {
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
//		String[] id_list = {"ryan", "con"};
//		String[] report = {"ryan con","ryan con","ryan con","ryan con"};
//		int k = 3;
//		
//		String[] id_list = {"a", "b", "c", "d"};
//		String[] report = {"a b","c b"};
//		int k = 2;
		
		Solution2 s = new Solution2();
		int[] answer = s.solution(id_list, report, k);
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
		
	}	

}


class Solution2 {

	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
      
        
        return answer;
    }
}