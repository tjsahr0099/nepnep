package com.nepnep.algorithm.jsw;

public class 성격유형검사하기 {
    public int findIdx(String[] type, String character){

        int cnt = 0;
        for (String each : type){
            if(each.equalsIgnoreCase(character)){
                return cnt;
            }
            cnt++;
        }
        return 0;
    }

    public String solution(String[] survey, int[] choices) {

        String answer = "";

        //각각에 해당하는 점수를 부여
        int[] rtcfjman = new int[8];
        String[] type = {"R", "T", "C", "F", "J", "M", "A", "N"};

        for (int i = 0; i < survey.length; i++){

            //비동의 인경우 앞에 글자
            if(choices[i] > 4){
                String front = survey[i].split("")[0];
                //앞에꺼에 숫자를 플러스 해주는데 4-초이스의[i] 만큼
                rtcfjman[findIdx(type, front)] += 4 - choices[i];
            }
            //동의 인 경우 뒤에 글자
            else if(choices[i] < 4) {
                String back = survey[i].split("")[1];
                //뒤에꺼에 숫자를 플러스 해주는데 초이스의[i] -4 만큼
                rtcfjman[findIdx(type, back)] += choices[i] - 4;
            }
        }

        //
        for (int i = 0; i < rtcfjman.length; i += 2) {

            if (rtcfjman[i] >= rtcfjman[i+1]){
                answer += type[i];
            }else {
                answer += type[i+1];
            }
        }

        return answer;
    }
}
