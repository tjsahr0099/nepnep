package com.nepnep.algorithm.cwr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 신고결과받기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report =  {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};		
		
		Solution2 sol = new Solution2();
		
		System.out.println(sol.solution(id_list, report, 3));
	}

}

class Solution2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        
        Map<String, List<String>> reportList = new HashMap<String, List<String>>();
        List<String> stopUserList = new ArrayList<>();
        
        for(String strId: id_list){
            List<String> list = new ArrayList<>();
            reportList.put(strId, list);
        }
        
        for(String strReport: report){
            String strUser = strReport.split(" ")[0];
            String strReportedUser = strReport.split(" ")[1];

            List<String> reportUserList = reportList.get(strReportedUser);
            if(!reportUserList.contains(strUser)){
                reportUserList.add(strUser);
            }
        }        
        
        for(String strId: id_list){
            if(reportList.get(strId).size() >= k){
                if(!stopUserList.contains(strId)){
                	stopUserList.add(strId);
                }
            }
        }
        
        for(int i=0; i < id_list.length; i++){
            int cnt = 0;
            for( String key : reportList.keySet() ){
                if(stopUserList.contains(key)){
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
