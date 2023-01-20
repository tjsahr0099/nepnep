package com.nepnep.algorithm;

/**
 * @author 이지영
 * 2023. 1. 14.
 */
public class 키패드_누르기 {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		// int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		// String hand = "left";
		
		// int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		// String hand = "right";
		
		키패드_누르기 s = new 키패드_누르기();
		
		System.out.println(s.solution(numbers, hand));
	}
	
	public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // * 은 10, 0 은 11, # 은 12 로 생각
        int leftHere = 10;
        int rightHere = 12;
        
        for(int number : numbers){
            // 0 은 11 로 고려
            number = number == 0 ? 11 : number;
            
            if(number == 1 || number == 4 || number == 7){
                answer += "L";
                leftHere = number;
            }else if(number == 3 || number == 6 || number == 9){
                answer += "R";
                rightHere = number;
            }else{
                // 3 으로 나눴을 때, 몫과 나머지를 더하면 해당 손을 사용할 경우 움직이는 횟수가 나타남
                // 몫은 위아래로 움직인 경우, 나머지는 좌우로 움직인 경우
                /*
                    2 5  3
                    4 5  1

                    2 8  6
                    4 8  4
                */
                int leftMove = Math.abs(leftHere - number) / 3 + Math.abs(leftHere - number) % 3;
                int rightMove = Math.abs(rightHere - number) / 3 + Math.abs(rightHere - number) % 3;
                
                // 움직인 횟수가 같은 경우, 사용하는 손으로 이동
                if(leftMove == rightMove){
                    if(hand.equals("right")){
                            answer += "R";
                            rightHere = number;
                        }else{
                            answer += "L";
                            leftHere = number;
                        }
                }else if(leftMove > rightMove){
                    answer += "R";
                    rightHere = number;
                }else{
                    answer += "L";
                    leftHere = number;
                }
            }
        }
        
        return answer;
    }
}
