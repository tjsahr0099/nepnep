package com.nepnep.algorithm;
/**
 * @author 정성우
 * 2023. 2. 11.
 */
public class 둘만의_암호 {
    public static void main(String[] args) {
        String s = "z";
        String skip = "abcdefghijklmnopqrstu";
        int index = 20;

        둘만의_암호 s1 = new 둘만의_암호();
        System.out.println(s1.solution(s, skip, index));
    }

    public String solution(String s, String skip, int index) {

        StringBuffer sb = new StringBuffer();

        //문자열을 하나씩 순회하면서
        for (char a : s.toCharArray()) {
            //각각의 index를 따로 사용
            int tmpIdx = index;
            //target을 저장
            char target = a;

            //한칸씩 다음칸으로 가며 skip에 포함되어 있다면 목표(tmpIdx)를 +1
            for (int i = 1; i <= tmpIdx; i++) {

                //만약 다음알파벳이 'z'를 넘어갔다면 'a'로 돌아오기
                target = (char)(a + i > 'z' ? 'a' + (a + i - 'a') % 26 : a + i);

                if (skip.contains(Character.toString(target))){
                    tmpIdx++;
                }
            }

            sb.append(target);

        }


        return sb.toString();
    }
}
