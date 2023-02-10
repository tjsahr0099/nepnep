package com.nepnep.algorithm;
/**
 * @author 정성우
 * 2023. 2. 11.
 */
public class 소수_찾기 {
    public static void main(String[] args) {
        int n = 10;

        소수_찾기 s1 = new 소수_찾기();
        System.out.println(s1.solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i ++) {
            if (isSosu(i)){
                answer++;
            }
        }
        return answer;
    }
    private boolean isSosu(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
