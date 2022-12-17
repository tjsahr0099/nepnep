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
		int[] answer = s.solution2(id_list, report, k);
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
		
	}	

}


class Solution2 {

	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String,Integer> reportCnt = new LinkedHashMap<String,Integer>();
        Map<String,Integer> mailCnt = new LinkedHashMap<String,Integer>();
        
        // 0개로 초기화
        for (String id : id_list) {
        	reportCnt.put(id, 0);
        	mailCnt.put(id, 0);
        }
        
        // 중복 제거
        List<String> reportList = Arrays.asList(report)
                .stream()
                .distinct()
                .collect(Collectors.toList());
        
        List<String> reportList2 = reportList;
        
        // 신고당한 사람의 카운트 구하기
        for (String r : reportList) {        	
        	
			//신고당한 사람
			String to = r.split(" ")[1];
			
			Integer toVal = reportCnt.get(to)==null?0:reportCnt.get(to);
			Integer nextVal = ++toVal;
			reportCnt.replace(to, nextVal);	
			
			// 신고 횟수가 정지 횟수에 도달하면 메일 카운트 증가
			if(nextVal==k) {
				for (String r2 : reportList2) {
					
					//신고한 사람
					String from = r2.split(" ")[0];	
					
					//신고당한 사람
					String to2 = r2.split(" ")[1];
					
					// 신고한 사람을 모두 찾아 카운트 1씩 증가
					if(to2.equals(to)) {
						mailCnt.put(from, mailCnt.get(from)+1);
					}
					
				}
			}
			
		}

       
        int i=0;
        for (String key : mailCnt.keySet()) {

        	answer[i]=mailCnt.get(key);
        	i++;
        }
        
        return answer;
    }
	
	int matchCnt = 0;
	
	public int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String,String> mailing = new LinkedHashMap<String,String>();
        
        
        for(String reportOne : report) {
        	
        	String f = reportOne.split(" ")[0];
        	String t = reportOne.split(" ")[1];
        	
        	String _f = mailing.get(t)==null ? "" : mailing.get(t);
        	if(!_f.matches("(.*)"+f+"(.*)")) {
        		mailing.put(t,(_f+" "+f).trim());	
        	}        	
        	
        }
        
        int i=0;
        for(String id : id_list) {
        	String str = mailing.get(id) == null ? "" : mailing.get(id);
        	
        	// 신고 정지 기준 체크
        	matchCnt=0;
        	mailing.forEach((key,value)->{
        		if(value.split(" ").length >= k) {
            	
        			if(value.matches("(.*)"+id+"(.*)")) {
        				matchCnt++;        				
        			}
            	}
        	});
        	answer[i]=matchCnt;
        	i++;
        	
        }        
        
        return answer;
    }
}