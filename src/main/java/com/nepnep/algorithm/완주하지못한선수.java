package com.nepnep.algorithm;

import java.util.Arrays;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"leo", "kiki"};
		sol.solution(participant, completion);
	}

}

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for(i=0;i<completion.length;i++)
            if(!participant[i].equals(completion[i]))
                break;

        return participant[i];
    }
}
