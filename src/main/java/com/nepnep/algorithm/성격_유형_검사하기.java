package com.nepnep.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO : 저자변경
 * @author 지영
 * 2022. 12. 25.
 */
public class 성격_유형_검사하기 {

	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices =  {5, 3, 2, 7, 5};
		
		// String[] survey = {"TR", "RT", "TR"};
		// int[] choices =  {7, 1, 3};
		
		성격_유형_검사하기 s = new 성격_유형_검사하기();
		
		System.out.println(s.solution(survey, choices));

	}
	
	public String solution(String[] survey, int[] choices) {
        // 유형별 점수 세팅
        Map<String, Integer> mbti = new HashMap<String, Integer>();
        mbti.put("R", 0);
        mbti.put("T", 0);
        mbti.put("C", 0);
        mbti.put("F", 0);
        mbti.put("J", 0);
        mbti.put("M", 0);
        mbti.put("A", 0);
        mbti.put("N", 0);
        
        for(int i = 0; i < survey.length; i++){
            String first = survey[i].substring(0,1);
            String second = survey[i].substring(1,2);

            if(choices[i] < 4){
                // 선택지가 4보다 큰 경우, 첫번째 유형에 점수를 추가
                mbti.put(first, mbti.get(first) + Math.abs(choices[i]-4));
            }else if(choices[i] > 4){
                // 선택지가 4보다 작은 경우, 두번째 유형에 점수를 추가
                mbti.put(second, mbti.get(second) + Math.abs(choices[i]-4));
            }
        }
        
        // 지표별로 유형의 점수가 큰 것을 표시, 점수가 같은 경우는 사전순으로 표시
        String answer = (mbti.get("R") < mbti.get("T") ? "T" : "R")
                + (mbti.get("C") < mbti.get("F") ? "F" : "C")
                + (mbti.get("J") < mbti.get("M") ? "M" : "J")
                + (mbti.get("A") < mbti.get("N") ? "N" : "A");
        
        return answer;
    }

}