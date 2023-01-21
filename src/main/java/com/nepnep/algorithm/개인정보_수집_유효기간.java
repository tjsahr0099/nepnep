package com.nepnep.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 김선목
 * 2023. 1. 14.
 */
public class 개인정보_수집_유효기간 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		String[] terms =  {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		System.out.println(new 개인정보_수집_유효기간().solution("2022.05.19", terms, privacies));
		
	}

	public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        
        // terms to map
        Map<String,String> termsMap = new HashMap<String,String>();
        for(String term : terms) {
        	termsMap.put(term.split(" ")[0], term.split(" ")[1]);
        }
        
        // check privacies
        int rowNum = 1;
        for(String privacy : privacies) {
        	
        	// 개인정보 수집일자
        	String privacyDay = privacy.split(" ")[0];
        	
        	// 해당 개인정보 수집일자의 유효기간 ( 월 )
        	String privacyTermMonth = termsMap.get(privacy.split(" ")[1]);
        	
        	// String을 Date로 변경
        	Date privacyDate = stringToDate(privacyDay.replaceAll("\\.", ""));
        	Date todayDate = stringToDate(today.replaceAll("\\.", ""));
        	
        	// +개월수 계산을 위한 캘린더 사용
        	Calendar cal = Calendar.getInstance();
        	cal.setTime(privacyDate);
        	cal.add(Calendar.MONTH, Integer.parseInt(privacyTermMonth));
        	
        	// !(수집일자 + 유효기간 < 오늘날짜) 
        	if(!todayDate.before(cal.getTime())) {
        		answerList.add(rowNum);
        	}
        	
        	rowNum++;
        	
        }
        
        answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
	
	public Date stringToDate(String date) throws ParseException {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.parse(date);
	}
}
