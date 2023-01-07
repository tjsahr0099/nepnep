package com.nepnep.algorithm;

public class 기사단원의_무기 {

    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;

        기사단원의_무기 s = new 기사단원의_무기();

        System.out.println(s.solution(number, limit, power));
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        //각 기사단원 별
        for (int i = 1; i <= number; i++) {

            //제한수치가 초과된 공격력이라면 power, 그렇지 않다면 약수의 개수
            int atk = getDivisors(i, limit) == -1 ? power : getDivisors(i, limit);

            answer += atk;
        }

        return answer;
    }

    //약수의 개수 구하는 함수
    private int getDivisors(int i, int limit) {

        if (i == 1) {
            return 1;
        } else {
            //1보다 클 때 1과 자신은 무조건 약수이므로 기본 2
            int divisors = 2;

            //자신으로 나누었을 때 (몫 1) 이후에는 몫이 2가 될 때까지는 약수가 없으므로 2로 나눈 수부터 확인
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    divisors++;
                }
                if (divisors > limit) {
                    divisors = -1;
                    break;
                }
            }

            return divisors;
        }
    }
}
