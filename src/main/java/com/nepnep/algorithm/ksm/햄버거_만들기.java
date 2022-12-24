package com.nepnep.algorithm.ksm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502?language=java
 * @author �����
 *
 */
public class �ܹ���_����� {
	
	public static void main(String[] args) {
		
		// ������� ���� ��� �׽�Ʈ �ʿ�
//		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		// ��ü�� �� ���Ǵ� ��� �׽�Ʈ �ʿ�
		int[] ingredient = {1,2,3,1,1,2,3,1,1,2,3,1};
		
		// �ϳ��� �ȸ�������� ��� �׽�Ʈ �ʿ�
//		int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
//		
//		
		Solution3 s = new Solution3();
		int result = s.solution(ingredient);
		
		System.out.println(result);
		
		
	}

}

class Solution3 {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> hamberger = new ArrayList<Integer>();
        hamberger.add(1);
        hamberger.add(2);
        hamberger.add(3);
        hamberger.add(1);
        
        List<Integer> list = new ArrayList<Integer>();        
        
        for(int a : ingredient) {
        	list.add(a);
        }
        
        int index = 0;
        while(true) {
        	
        	// ����� �ε���+4���� ���� ��� �� �̻� �ܹ��Ÿ� ���� �� ���� - ������ �ʿ��� ����� 3 ����
        	
        	if(list.size()<index+4) {
    			break;
    		}        	
        	
        	// �ܹ��Ű� ��������� ���
        	if(hamberger.equals(list.subList(index, index+4))){        		
        		
        		// ��� ������ �ø�
        		answer++;
        		
        		// �ܹ��� ��Ḧ ����Ʈ���� ������. �ε��� ��ȣ�� �����ϸ� ��ĭ�� �������� ������ ���� �ε����� 4�� ����
        		list.remove(index);
        		list.remove(index);
        		list.remove(index);
        		list.remove(index);
        		
        		// �հ� �ڰ� �پ �ܹ��Ű� ��������� ��츦 üũ��. 123 1231 1 �� ���� �Ұ����ϹǷ�(���� ���� �������) 12 1234 31 �� ��찡 �ּ��� �׷��� -2��.
        		// 2�� ���� ��� ���а� ����. 3���� ���� ��� 4�� ���� ��� 2�� ������. -> �����Ǵ� ��� index�� ������ �ȵǾ�� �ϴ� ���̾���.        		
        		index = ( index - 2 < 0 ) ? 0 : index - 2 ;
        	}else {
        		index++;
        	}
        	
//        	System.out.println(index + " : " + list.size());
        	
        	
        }
        
        
        return answer;
    }
    
   
}