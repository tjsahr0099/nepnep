package com.nepnep.algorithm.ksm;


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
		
		String[] id_list = null;
		String[] report = null;
		int k = 0;
		
		Solution2 s = new Solution2();
		s.solution(id_list, report, k);

	}	

}


class Solution2 {

	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        Map<String,Integer> result = new LinkedHashMap<String,Integer>();
        
        for (String id : id_list) {
        	result.put(id, 0);
        }
        
        // 중복 제거
        List<String> reportList = Arrays.asList(report)
                .stream()
                .distinct()
                .collect(Collectors.toList());
        
        for (String r : reportList) {
        	
        	//신고한 사람
			String from = r.split(" ")[0];
			
			//신고당한 사람
			String to = r.split(" ")[1];
			
			Integer toVal = result.get(to);
			result.replace(to, toVal, toVal+1);		
			
		}
        
        for (String id : id_list) {
        	result.put(id, 0);
        }
        
        
        return answer;
    }
}