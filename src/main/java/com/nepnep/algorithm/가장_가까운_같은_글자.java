package com.nepnep.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 가장_가까운_같은_글자 {
    public static void main(String[] args) {
        String s = "banana";

        가장_가까운_같은_글자 s1 = new 가장_가까운_같은_글자();
        for (int a : s1.solution(s)){
            System.out.print(a + " ");
        }
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        List<Character> list = new ArrayList<>();

        //하나씩 리스트에 넣기 전에 있는지없는지 확인하고 있다면 idx의 차이를 구한다.
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                answer[i] = getIdxGap(i, s.charAt(i), list);
            } else {
                answer[i] = -1;
            }
            list.add(s.charAt(i));
        }

        return answer;
    }
    private int getIdxGap(int idx, char c, List<Character> list) {
        int cnt = 0;
        for (int i = idx - 1; i >= 0; i--) {
            cnt++;
            if (list.get(i) == c) {
                return cnt;
            }
        }
        return cnt;
    }
}
