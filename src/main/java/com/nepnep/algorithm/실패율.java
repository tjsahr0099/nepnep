package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 실패율 {

	public static void main(String[] args) {
		
		
		
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		new 실패율().solution(N, stages);
	}
	
	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
//        int base = 0;
//        for(int i=1 ; i<=N ; i++) {
//        	
//        }
        
        List<String> list = new ArrayList<String>();
        
        int sum = 0;
        for(int i=1 ; i<=N+1 ; i++) {
        	int cnt = 0;
        	for(int s : stages) {
        		if( s == (i-1) ) {
        			cnt++;
        		}
        	}
        	if(i!=1) {
        		String a = String.format("%.6f", (float)cnt/(stages.length-sum)) + ( (N+1) - i );
        		list.add(a);
//        		int a = Math.round(cnt/(stages.length-sum)*100000000);
//        		System.out.println("cnt:" + cnt + " , " + "sum:" + (stages.length-sum) + " cal:" + a);
//        		System.out.println("cnt:" + cnt + " , " + "sum:" + (stages.length-sum));
        	}
        	sum = sum + cnt;        	
//        	System.out.println("cnt:" + cnt + " , " + "sum:" + (stages.length-sum));
        }
        
        list.sort(Comparator.reverseOrder());
        
        int i = 0;
        for(String s : list) {
        	String s_last = s.substring(s.length()-1);
        	answer[i] = N- Integer.parseInt(s_last);
        	i++;
        }
        
//        System.out.println(list);
        
        return answer;
    }

}
