package com.nepnep.algorithm;

public class 소수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionSosu sosu = new SolutionSosu();
		sosu.solution(5);
	}

}

class SolutionSosu {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++)
        {
        	if(i > 1)
        	{
        		if(isPrime(i) == 1)
        		answer++;
        	}
        }
        
        return answer;
    }
    
    public int isPrime(int n) {
    	for (int i = 2; i<=(int)Math.sqrt(n); i++)
    	{
          if (n % i == 0)
          {
              return 0;
          }
    	}
    	
    	return 1;
    }
}