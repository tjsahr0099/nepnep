package com.nepnep.algorithm.ksm;

import java.util.HashMap;
import java.util.Map;

public class ����_����_�˻��ϱ� {

	/**
	 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
	 * @param args
	 */
	public static void main(String[] args) {


		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		Solution4 s = new Solution4();
		String ss = s.solution(survey, choices);
		System.out.println(ss);
	}

}

class Solution4 {
    public String solution(String[] survey, int[] choices) {
    	
    	String[][] jipo = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};
        String answer = "";
        
        Map<String,Integer> jumsuPan = new HashMap<String,Integer>();
        
        // ������ �ʱ�ȭ
        for(String[] x : jipo) {
        	for(String y : x) {
        		jumsuPan.put(y, 0);
        	}
        }
        
        // ����üũ
        for(int i=0;i<survey.length;i++) {
        	
        	// ����
        	String sunguk = survey[i];
        	// ����
        	int jumsu =  choices[i];        	
        	
        	String before = sunguk.split("")[0];
        	String after = sunguk.split("")[1];
        	
        	// ������ ���� ��������
        	switch(jumsu) {
        		case 1:
        		case 2:
        		case 3:
        			jumsuPan.put(before, jumsuPan.get(before) + (4 - jumsu) );
        			break;
        		case 4:
        			break;
        		case 5:
        		case 6:
        		case 7:
        			jumsuPan.put(after, jumsuPan.get(after) + (jumsu - 4) );
        			break;
    			default :
    				break;
        	}
        	
        }
        
//        System.out.println(jumsuPan.toString());
        
        // �������� üũ        
        for(String[] x : jipo) {
        	// ����üũ. ������ ������ ��� ������ �켱��
        	if(jumsuPan.get(x[0]) < jumsuPan.get(x[1])) {
        		answer += x[1];
        	}else {
        		answer += x[0];
        	}
        }
        
        return answer;
    }
    
    
}