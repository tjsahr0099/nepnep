package com.nepnep.algorithm;
/**
 * @author 성우
 * 2023. 1. 28.
 */
public class 체육복 {
    public static void main(String[] args) {
        int n = 2;
        int[] lost = {1};
        int[] reserve = {2};

        체육복 s = new 체육복();
        System.out.println(s.solution(n, lost, reserve));

    }
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        //체육복이 없는사람 = -1
        for (int a : lost) {
            students[a-1] -= -1;
        }
        //여벌이 있는사람 = 1
        for (int a : reserve) {
            students[a-1] += 1;
        }


        for (int i = 0; i < students.length; i++) {
            if (i == 0) {
                if (students[i] == 1 && students[i+1] == -1) {
                    students[i] -= 1;
                    students[i + 1] += 1;
                }
            }else if (i == students.length - 1) {
                if (students[i] == 1 && students[i-1] == -1) {
                    students[i] -=1;
                    students[i-1] +=1;
                }
            //둘 다 왼쪽 방향을 먼저 생각하기 (-1, -1, 1, -1, 1)
            }else if (students[i] == 1) {
                if (students[i-1] == -1) {
                    students[i-1] += 1;
                    students[i] -= 1;
                }else if (students[i+1] == -1) {
                    students[i+1] += 1;
                    students[i] -= 1;
                }
            }
        }

        for (int a : students) {
            answer += a >= 0 ? 1 : 0;
        }
        return answer;
    }
}
