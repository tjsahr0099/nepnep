package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * @author ksm
 * 2023. 1. 3.
 */
public class 숫자짝꿍 {

	public static void main(String[] args) {
		System.out.println(new 숫자짝꿍().solution("410480127581740917409127409172047397305734095723479182763126480727365237491273490174908325", "534539475947937602375293572934702937402934710947019561283746082347235235347520973492734927390472935"));
	}

	public String solution(String X, String Y) {
		
		List<String> list = new ArrayList<String>();
		String answer = "";
		
		//시간을 줄이기 위한 길이비교 X가 짧은것 Y가 긴것		
		if(X.length()>Y.length()) {
			String temp = "";
			temp = Y;
			Y=X;
			X=temp;
		}
			
		// X를 포문 돌려서 Y에 포함되어있는지 확인 후 포함되어있으면 잘라내고 따로 저장함
		for(char x : X.toCharArray()) {
			
			//해당 문자의 포함 위치
			int yIndex = Y.indexOf(x);
			
			// yIndex가 0미만이면 문자를 못찾은것임.
			if(yIndex>=0) {
				list.add(Y.substring(yIndex,yIndex+1));
				Y = Y.substring(0,yIndex) + Y.substring(yIndex+1, Y.length());
			}
		}
		
		// 리스트에 적재된것이 있는 경우
		if(list.size()!=0) {
			list.sort(Comparator.reverseOrder());
			for(String s : list) {
				answer += s;
			}			
			if(list.get(0).equals("0")) {
				return answer = "0";
			}
		}else {
			return answer = "-1";
		}
		
        
        return answer;
	}
	 
}
