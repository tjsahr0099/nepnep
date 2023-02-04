package com.nepnep.algorithm;

public class 푸드_파이트_대회 {

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};

        푸드_파이트_대회 s = new 푸드_파이트_대회();
        System.out.println(s.solution(food));
    }

    public String solution(int[] food) {
        StringBuffer answer = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        //음식의 번호 (== i)
        int foodNum = 0;
        //음식 횟수
        int foodTime = 0;
        for (int i = 1; i < food.length; i++) {
            foodNum = i;
            foodTime = food[i] / 2;
            for (int j = 0; j < foodTime; j++) {
                sb.append(foodNum);
            }
        }
        answer.append(sb);
        answer.append("0");
        answer.append(sb.reverse());

        return answer.toString();
    }

}
