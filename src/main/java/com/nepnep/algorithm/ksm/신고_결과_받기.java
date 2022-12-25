package com.nepnep.algorithm.ksm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
        //report 를 짤라서 신고받은 ID 별 신고한 사람 리스트를 구한다.
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String report_one : report) {
        	String[] report_split = report_one.split(" ");
        	
        	//신고한 ID
        	String reportID = report_split[0];
        	
        	//신고받은 ID
        	String reportedID = report_split[1]; 
        	
        	List<String> list = map.get(reportedID);
        	
        	// 리스트가 없으면 새로 생성해서 신고한 ID 넣기
        	if(list==null) {
        		list = new ArrayList<String>();
        		list.add(reportID);
        	}else {   
        		// 리스트가 있으면 reportID가 있는지 확인하고 넣기 ( 중복제거 )
	        	if(!list.contains(reportID)) {
	        		list.add(reportID);
	        	}
        	}
        	
        	map.put(reportedID, list);
        }
        
//        System.out.println(map.toString());
        
        Map<String,Integer> cntMap = new HashMap<String,Integer>();
        
        // 메일받을 갯수 체크
        for ( String key : map.keySet() ) {        	
        	
        	List<String> list = map.get(key);
        	
        	// 메일 보내는 신고횟수 체크
        	if(list.size() >= k) {
//        		System.out.print("신고받은사람 : " + key + " 신고횟수 " + k + "넘음 : ");
//        		System.out.println(list.toString());
		        	for(String one : list) {
		        		
		        		Integer cnt = cntMap.get(one);
		        		
		        		if(cnt == null) {
		        			cntMap.put(one, 1);
		        		}else {
		        			cntMap.put(one, ++cnt);	
		        		}
//		        		System.out.print("??:");
//		        		System.out.println(cntMap.toString());
		        	}
		        	
	        	
        	}
//            System.out.println("key : " + key +" / value : " + map.get(key));
        }
        
//        System.out.println(cntMap);
        
        // 아이디 리스트로 포문 돌면서 맵에 몇개씩 있는지 체크
        for(int i=0;i<id_list.length;i++) {
        	if(cntMap.get(id_list[i])!=null) {
        		answer[i] =	cntMap.get(id_list[i]);
        	}else {
        		answer[i] =	0;
        	}
        	   
        }
        
      
        
        return answer;
    }
}