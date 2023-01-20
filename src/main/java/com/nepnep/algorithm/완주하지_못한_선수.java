package com.nepnep.algorithm;

import java.util.*;

/**
 * @author 성우
 * 2022. 1. 21.
 */

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        완주하지_못한_선수 s = new 완주하지_못한_선수();

        System.out.println(s.solution(participant, completion));
        System.out.println(s.solution2(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        //맵에 참가자 이름과 숫자1을 저장
        Map<String, Integer> map = new HashMap<>();

        //동명이인이 있다면 숫자를 +1
        for (String a : participant) {
            if (map.containsKey(a)){
                map.put(a, map.get(a) + 1);
            }else {
                map.put(a, 1);
            }
        }

        //완주한사람에 해당하는 value 1감소
        for (String b : completion) {
            map.put(b, map.get(b) - 1);
        }

        //한명만 숫자가 1이므로 그 키값을 찾아 리턴
        for (String key : map.keySet()){
            if (map.get(key) == 1){
                answer = key;
                break;
            }
        }

        return answer;
    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        //주어진 배열을 각각 정렬 (Arrays.sort() 보다 Collections.sort()가 효율적)
        List<String> arr1 = Arrays.asList(participant);
        List<String> arr2 = Arrays.asList(completion);
        Collections.sort(arr1);
        Collections.sort(arr2);

        //순회하며 다른 원소가 나오는 순간 완주하지 못한선수
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;

            //끝까지 다 돌았는데도 멈추지 않았다면 마지막 원소가 완주하지 못한 선수
            }else if (i == completion.length -1) {
                answer = participant[i+1];
            }
        }

        return answer;
    }
}
