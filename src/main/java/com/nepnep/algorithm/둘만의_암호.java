package com.nepnep.algorithm;

import java.util.Arrays;

public class 둘만의_암호 {

	public static void main(String[] args) {

//		String s = "aaaaa";
//		String skip = "bcdefghijkl";
//		int index = 20;
		String s = "z";
		String skip = "bcdef";
//		int index = 1;		
		
		for(int index=1;index<=20;index++) {
			System.out.println(new 둘만의_암호().solution(s, skip, index));
		}

	}
	
	public String solution(String s, String skip, int index) {
        String answer = "";
        
        //a 97 ~ z 122  26개, 25차이        
        for(char c : s.toCharArray()) {        	
        	int skipCount = 0;
        	for(char cSkip : skip.toCharArray()) {
        		
        		int iSkip = (int)cSkip;
        		int minValue = (int)c;
        		int maxValue = (int)c + index + skipCount;
        		// s와 s+index+skipCount 사이에 skip글자가 있는 경우 skipCount를 올린다. skipCount만큼 더하는 이유는 지워지면 다음엔 그 다음껏까지 체크해야 하기 때문에.. 
        		if((iSkip > minValue) && (iSkip <= maxValue)) {
        			skipCount++;
        		}
        	}
        	
        	// 한글자씩 인덱스만큼 올리고, 스킵한 카운트만큼 더 올린다.
        	int charCal = (int)c + index + skipCount;
        	
        	// z가 넘어간 경우 a~z만큼의 인덱스(26)을 빼면 롤링된다.
        	if(charCal > 122) {
        		c = (char)(charCal - 26);
        		
        		// 한바퀴 돌아서 글자가 나왔는데 스킵에 해당되는 문자면, +1씩 해서 스킵에 해당하지 않는 문자를 찾는다.
        		// aukks -> happy 에서 보면, u->a 이기 때문에 "skip에 포함되는 알파벳은 s에 포함되지 않습니다." 는 한바퀴 돌았을 때는 포함되어도 되는 것으로 보인다. -> result에는 포함되어도 되는 것으로..보임.
        		while(skip.contains(""+c)) {
        			System.out.println("xxxxxxxx:" +c);
	        		c = (char)((int)c+1);
	        	}
			
        		
        	}else {
        		c = (char)(charCal);
        	}
        	answer = answer + c;
        }
        
        return answer;
    }

}
