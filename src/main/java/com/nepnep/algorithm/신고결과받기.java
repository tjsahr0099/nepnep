package com.nepnep.algorithm;

import java.util.*;

/**
 * @author 정성우
 * 2022. 12. 25.
 */
public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        //맵에 유저를 키로 등록하기
        Map<String, Set<String>> map = new HashMap<>();
        for (String user : id_list) {
            map.put(user, new HashSet<>());
        }

        //유저별 신고한 사람 등록해주기, 중복신고는 무효하니 Set 사용
        for (String result : report){
            String reporter = result.split(" ")[0];
            String reported = result.split(" ")[1];
            map.get(reported).add(reporter);
        }

        //indexOf 메서드밖에 생각이 안나서 유저를 List 로 변환
        List<String> user = Arrays.asList(id_list);

        //맵을 한바퀴 돌면서 신고횟수가 k가 넘은 유저를 찾기
        for (int i = 0; i < map.size(); i++) {
            Set<String> receiver = map.get(id_list[i]);
            //신고횟수가 k번이 넘은 유저라면
            if (receiver.size() >= k){
                //신고한사람의 배열에서의 인덱스를 찾아 1씩 더해주기
                for(String value : receiver) {
                    int idxOfArr = user.indexOf(value);
                    answer[idxOfArr] += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        신고결과받기 a = new 신고결과받기();
    }
}
