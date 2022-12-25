package com.nepnep.algorithm.ljy;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class 신고_결과_받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report =  {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		// String[] id_list = {"con", "ryan"};
		// String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		// int k = 3;
		
		Solution2 s = new Solution2();
		
		System.out.println(s.solution(id_list, report, 3));
	}

}

class Solution2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> reportList = new HashMap<String, List<String>>();
        List<String> stopUser = new ArrayList<>();
        
        for(String id: id_list){
            List<String> list = new ArrayList<>();
            reportList.put(id, list);
        }
        
        for(String r: report){
            String user = r.split(" ")[0];
            String reportedUser = r.split(" ")[1];

            List<String> reportUserList = reportList.get(reportedUser);
            if(!reportUserList.contains(user)){
                reportUserList.add(user);
            }
        }        
        
        for(String id: id_list){
            if(reportList.get(id).size() >= k){
                if(!stopUser.contains(id)){
                    stopUser.add(id);
                }
            }
        }
        
        for(int i=0; i < id_list.length; i++){
            int cnt = 0;
            for( String key : reportList.keySet() ){
                if(stopUser.contains(key)){
                    for(String value : reportList.get(key)){
                        if(id_list[i].equals(value)) cnt += 1;
                    }
                }
            }

            answer[i] = cnt;
        }
        
        return answer;
    }
}
