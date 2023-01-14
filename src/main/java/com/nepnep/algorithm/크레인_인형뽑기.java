package com.nepnep.algorithm;

import java.util.Stack;

/**
 * 
 * @author cwr94
 *
 */
public class 크레인_인형뽑기 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4}	;
		
		new 크레인_인형뽑기().solution(board, moves);

	}
	
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        //인형 담을 곳
        Stack<Integer> pocket = new Stack<Integer>();
        
        for (int move : moves)
        {     	
        	for(int i = 0; i < board.length; i++)
        	{
        		//인형이 없으면 위로
        		if(board[i][move-1] == 0)
            	{
            			continue;
            	}
        		else        			
        		{
        			//같은 모양의 인형이 쌓이는 경우
        			if(!pocket.isEmpty() && board[i][move-1] == pocket.peek())
        			{
        				answer += 2;
        				//바구니에서 삭제
        				pocket.pop();
        			}
        			else
        			{
        				pocket.add(board[i][move-1]);
        			}
        			
        			board[i][move-1] = 0;
        		}
        		
        		break;
        	}
        }
        
        return answer;
    }

}
