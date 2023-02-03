package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 성우
 * 2023. 2. 4.
 */

public class 실패율 {
    public static void main(String[] args) {
        int N = 2;
        int[] stages = {1, 1, 1, 1};

        실패율 s = new 실패율();
        for (int a : s.solution(N, stages)){
            System.out.print(a + " ");
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        //각 스테이지별 도달했으나 클리어하지 못한 플레이어의 수 numerator[0] -> 1stage
        int[] numerator = new int[N];
        int[] denominator = new int[N];
        int allClear = 0;

        for (int a : stages) {
            //N+1 모두 통과한 사람은 따로 셈
            if (a > N) {
                allClear++;
            }else {
                numerator[a-1]++;
            }
        }
        //각 스테이지별 도달한 플레이어 수(분모)
        for (int i = 0; i < numerator.length; i++) {
            for (int j = numerator.length - 1; j >= i; j--) {
                denominator[i] += numerator[j];
            }
            //모두 통과한 사람 추가
            denominator[i] += allClear;
        }
        //스테이지 별 실패율
        List<Float> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            //도달한 유저가 없는 경우 어차피 0
            list.add(denominator[i-1] == 0 ? 0 : (float)numerator[i-1] / (float)denominator[i-1]);
        }

        int idx = -1;
        for (int i = 0; i < answer.length; i++) {
            idx = list.indexOf(Collections.max(list));
            answer[i] =  idx + 1;
            //최대값을 앞에있는걸 우선으로 한다고 가정했을 때
            list.set(idx, -1f);
        }

        return answer;
    }
}
