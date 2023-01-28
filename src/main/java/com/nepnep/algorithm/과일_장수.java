package com.nepnep.algorithm;

import java.util.Arrays;

/**
 * @author 성우
 * 2023. 1. 28.
 */

public class 과일_장수 {
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        과일_장수 s = new 과일_장수();
        System.out.println(s.solution(k, m, score));
    }
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        //나머지가 start idx
        int startIdx = score.length % m;
        for (int i = startIdx; i < score.length; i += m){
            answer += score[i];
        }
        return answer * m;
    }

}
