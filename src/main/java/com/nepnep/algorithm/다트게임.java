package com.nepnep.algorithm;


/**
 * 
 * 
 * @author cwr942
 * 2023. 2. 04.
 */

public class 다트게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionDart sol = new SolutionDart();
		sol.solution("1S2D*3T");
	}

}

class SolutionDart {
    public int solution(String dartResult) {
        
        int[] nGame = new int[3];
        char[] cScore = dartResult.toCharArray();
        
        //3라운드
        int nRound = -1;
        
        for(int i = 0; i < cScore.length; i++)
        {
        	//0 ~ 9
        	if(cScore[i] >= '0' && cScore[i] <= '9')
        	{
        		nRound++;
        		//점수 추가
        		nGame[nRound] += Integer.parseInt(String.valueOf(cScore[i]));
        		//10점 쏠때
        		if(i+1 != cScore.length-1 && cScore[i+1] == '0' && cScore[i] == '1')
        		{
        			nGame[nRound] -= Integer.parseInt(String.valueOf(cScore[i]));
        			nGame[nRound] = 10;
        			i++;
        		}        		
        	}
        	else if(cScore[i] == 'D')
        	{
        		nGame[nRound] *= nGame[nRound];
        	}
        	else if(cScore[i] == 'T')
        	{
        		nGame[nRound] *= nGame[nRound] * nGame[nRound];
        	}
        	else if(cScore[i] == '*')
        	{
        		//1라 제외
        		if(nRound > 0)        		
        			nGame[nRound-1] *= 2;        		
        		
    			nGame[nRound] *= 2;

        	}
        	else if(cScore[i] == '#')
        	{
        		nGame[nRound] *= -1;
        	}
        }
        
        return nGame[0] + nGame[1] + nGame[2];
    }
}