package com.nepnep.algorithm;
/**
 * @author 성우
 * 2023. 1. 28.
 */
public class 로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        로또의_최고_순위와_최저_순위 s = new 로또의_최고_순위와_최저_순위();
        for (int a : s.solution(lottos, win_nums)){
            System.out.print(a + " ");
        }

    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int sameCnt = 0;
        int zeroCnt = 0;
        //일치하는 개수 를 센다
        for (int i = 0; i < win_nums.length; i++){
            for (int a : lottos) {
                if (win_nums[i] == a) {
                    sameCnt++;
                } else if (i == 0 && a == 0) {
                    zeroCnt++;
                }
            }
        }

        //하나도 일치하는게 없다면 7-0 일 떄 랭크가 7 이 나오는 것을 방지
        if (sameCnt == 0) {
            sameCnt +=1;
        }

        //zeroCnt는 마음대로 바꿀 수 있는 개수와 같다.
        int maxRank = 7 - Math.min(sameCnt + zeroCnt, 6);
        int minRank = 7 - sameCnt;
        int[] answer = {maxRank, minRank};
        return answer;
    }
}
