package com.nepnep.algorithm.cwr;

public class 기사단원 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		Solution3 sol = new Solution3();
			System.out.println(sol.solution(babbling));	
			
		}
}

class Solution4 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i  = 1; i <= number; i++)
        {
        	int nResult = getCount(i);
        	
        	//제한 보다 작으면 약수개수
        	if(nResult <= limit)
        	{
        		answer += nResult;
        	}
        	//크면 제한 개수
        	else
        	{
        		answer += power;
        	}
        		
        }
        
        return answer;
    }
    
    public int getCount(int n)
    {
    	int nCount = 0;
    	
    	for(int i = 1; i * i <= n; i++)
    	{
    		if(n % i == 0)
    		{
    			nCount++;
    			
    			if(i * i < n)
    			{
    				nCount++;
    			}
    		}
    	}
    	
    	return nCount;
    }
}