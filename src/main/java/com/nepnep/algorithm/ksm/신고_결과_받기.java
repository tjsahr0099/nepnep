package com.nepnep.algorithm.ksm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java
 * @author �����
 *
 */
public class �Ű�_���_�ޱ� {

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
        
        //report �� ©�� �Ű���� ID �� �Ű��� ��� ����Ʈ�� ���Ѵ�.
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String report_one : report) {
        	String[] report_split = report_one.split(" ");
        	
        	//�Ű��� ID
        	String reportID = report_split[0];
        	
        	//�Ű���� ID
        	String reportedID = report_split[1]; 
        	
        	List<String> list = map.get(reportedID);
        	
        	// ����Ʈ�� ������ ���� �����ؼ� �Ű��� ID �ֱ�
        	if(list==null) {
        		list = new ArrayList<String>();
        		list.add(reportID);
        	}else {   
        		// ����Ʈ�� ������ reportID�� �ִ��� Ȯ���ϰ� �ֱ� ( �ߺ����� )
	        	if(!list.contains(reportID)) {
	        		list.add(reportID);
	        	}
        	}
        	
        	map.put(reportedID, list);
        }
        
//        System.out.println(map.toString());
        
        Map<String,Integer> cntMap = new HashMap<String,Integer>();
        
        // ���Ϲ��� ���� üũ
        for ( String key : map.keySet() ) {        	
        	
        	List<String> list = map.get(key);
        	
        	// ���� ������ �Ű�Ƚ�� üũ
        	if(list.size() >= k) {
//        		System.out.print("�Ű������� : " + key + " �Ű�Ƚ�� " + k + "���� : ");
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
        
        // ���̵� ����Ʈ�� ���� ���鼭 �ʿ� ��� �ִ��� üũ
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