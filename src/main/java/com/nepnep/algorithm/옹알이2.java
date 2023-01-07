package com.nepnep.algorithm;

import java.util.regex.Pattern;

public class 옹알이2 {
    public static void main(String[] args) {

        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        옹알이2 s = new 옹알이2();

        System.out.println(s.solution(babbling));
    }

    public int solution(String[] babbling) {
        int answer = 0;

        //발음할 수 있는 발음
        String[] available = {"aya", "ye", "woo", "ma"};

        //넘겨받은 단어 하나 추출
        for (String babblingWord : babbling) {

            boolean isImpossible = false;

            //추출한 단어에 대해서 발음할 수 있는 단어와 비교
            for (String availableWord : available) {

                //중복발음 불가능 하므로 isImpossible -> true
                if (babblingWord.contains(availableWord + availableWord)) {
                    isImpossible = true;
                    break;
                }
            }

            //중복 발음이 없다면
            if (!isImpossible) {

                //발음 가능한 단어를 0으로 치환
                for (String availableWord : available) {
                    babblingWord = babblingWord.replace(availableWord, "0");
                }
            }

            //단어가 모두 0으로만 이루어져 있다면 발음 가능한 단어로 판단
            Pattern pattern = Pattern.compile("^(0)+$");
            if (pattern.matcher(babblingWord).matches()) {
                answer++;
            }
        }

        return answer;
    }
}
