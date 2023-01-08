package com.nepnep.algorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class 숫자_짝꿍 {

	public static void main(String[] args) {
		String X = "5525";
		String Y = "1255";
		
		숫자_짝꿍 s = new 숫자_짝꿍();
		
		System.out.println(s.solution(X, Y));
	}
	
	public String solution(String X, String Y) {
        String answer = "";
        String[] integerArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int[] XArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] YArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] XYArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Integer> resultList = new ArrayList<>();
        
        for(int i = 0; i < integerArr.length; i++){
            for (String x : X.split("")) {
                if(x.equals(integerArr[i])){
                    XArr[i] += 1;
                }
            }
            
            for (String y : Y.split("")) {
                if(y.equals(integerArr[i])){
                    YArr[i] += 1;
                }
            }
        }
        
        for(int i = 0; i < XYArr.length; i++){
            // X, Y 중 하나라도 해당 숫자가 없는 경우 0
            if(XArr[i] == 0 || YArr[i] == 0){
                XYArr[i] = 0;
            }else if(XArr[i] >= YArr[i]){
                // X 가 Y 보다 해당 숫자 많은 경우, Y 의 개수를 입력
                XYArr[i] = YArr[i];
            }else{
                XYArr[i] = XArr[i];
            }
        }
        
        for(int i = 0; i < XYArr.length; i++){
            for(int j = 0; j < XYArr[i]; j++){
                resultList.add(i);
            }
        }
        
        // 짝꿍이 없는 경우, -1 리턴
        if(resultList.size() == 0){
            return "-1";
        }
        
        // 내림차순으로 정렬
        Collections.sort(resultList, Collections.reverseOrder());
        for(int result : resultList){
            answer += result;
        }
        
        // 0 만 있는 경우, 0 리턴
        if(answer.matches("0+")){
            return "0";
        }
        
        return answer;
    }
}
