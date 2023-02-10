package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 정성우
 * 2023. 2. 11.
 */
public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        모의고사 s1 = new 모의고사();
        System.out.println(s1.solution(answers));
    }
    public int[] solution(int[] answers) {
        int[] patternA = {1, 2, 3, 4, 5};
        int[] patternB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] patternC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Integer> correctCnt = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            correctCnt.add(0);
        }
        //정답을 순회하며 각각의 정답 개수를 순서대로 담기
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == getNum(i, patternA)){
                correctCnt.set(0, correctCnt.get(0) + 1);
            }
            if (answers[i] == getNum(i, patternB)){
                correctCnt.set(1, correctCnt.get(1) + 1);
            }
            if (answers[i] == getNum(i, patternC)){
                correctCnt.set(2, correctCnt.get(2) + 1);
            }
        }

        //가장 많이 맞춘 개수를 찾고 그 개수와 같다면 새로운 list 에 번호 넣어주기(순서대로)
        int max = Collections.max(correctCnt);
        List<Integer> winner = new ArrayList<>();
        for (int i = 0; i < correctCnt.size(); i++) {
            if (correctCnt.get(i) == max){
                //사람 번호
                winner.add(i + 1);
            }
        }

        //List -> Array
        int[] answer = new int[winner.size()];
        for (int i = 0; i < winner.size(); i++) {
            answer[i] = winner.get(i);
        }

        return answer;
    }
    //답안지 확인
    private int getNum(int i, int[] pattern) {
        return pattern[i % pattern.length];
    }
}
