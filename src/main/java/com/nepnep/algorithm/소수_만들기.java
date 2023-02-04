package com.nepnep.algorithm;

public class 소수_만들기 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        소수_만들기 s = new 소수_만들기();
        System.out.println(s.solution(nums));
    }

    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    answer += this.isSosu(sum) ? 1 : 0;
                }
            }
        }

        return answer;
    }

    //소수 판별 함수 (2제외)
    private boolean isSosu(int a) {
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
