package com.nepnep.algorithm.cwr;

public class 문자열나누기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 sol = new Solution1();
		sol.solution("abbbaacca");
	}
}
class Solution1 {
	 public int solution(String strInput) {
	        int nResult = 0;
	        int nCnt1 = 0;
	        int nCnt2 = 0;
	        char cStart = ' ';
			
			for (int i = 0; i < strInput.length(); i++) {
			    if (cStart == ' ') 
				{
					cStart = strInput.charAt(i);
				}
			if (cStart == strInput.charAt(i))
				{
					nCnt1++;
				}
			else {
					nCnt2++;
				}
			
			//두개의 개수가 같으면 결과값 증가 시키고 초기화
			if (nCnt1 == nCnt2) {
				nResult++;
				nCnt1 = 0;
				nCnt2 = 0;
				cStart = ' ';
			    }
			}
			
			//마지막에 공백이 아니라 글자가 더있으면 결과값 +1;
			if (cStart != ' ') {
			    		nResult++;
			    	}
			
			    return nResult;
			}
}
