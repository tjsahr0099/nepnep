package com.nepnep.algorithm;

/**
 * @author 정성우
 * 2023. 1. 7.
 */
public class 숫자_짝꿍 {

    public static void main(String[] args) {
        String X = "100";
        String Y = "123450";

        숫자_짝꿍 s = new 숫자_짝꿍();

        System.out.println(s.solution(X, Y));
    }

//    public String solution(String X, String Y) {
//
//
//        String shorter = X.length() <= Y.length() ? X: Y;
//        String longer = X.length() <= Y.length() ? Y : X;
//
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < shorter.length(); i++) {
//            char now = shorter.charAt(i);
//            if (longer.contains(Character.toString(now))){
//                longer = longer.replaceFirst(Character.toString(now), "");
//                list.add(now - 48);
//            }
//        }
//
//        Collections.sort(list, Collections.reverseOrder());
//
//        StringBuffer sb = new StringBuffer();
//        if (list.size() == 0){
//            return "-1";
//        }else if (list.get(0) == 0){
//            return "0";
//        }else {
//            for (int a : list) {
//                sb.append(a);
//            }
//            return sb.toString();
//        }
//
//    }

    public String solution(String X, String Y) {
        String answer = "";

        //0~9의 각 개수를 나타낼 수 있는 배열 생성
        int[] arr = new int[10];

        //0 부터 몇개를 가지고 있는지 각각 확인 후 더 작은 개수를 배열에 담기
        for (int i = 0; i < arr.length; i++) {
            int a = X.length() - X.replace(Integer.toString(i), "").length();
            int b = Y.length() - Y.replace(Integer.toString(i), "").length();
            arr[i] = Math.min(a, b);
        }


        StringBuffer sb = new StringBuffer();
        //가장 큰 수를 만들어야 하므로 9부터 짝지어진 개수 만큼 앞에서부터 추가
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i);
            }
        }

        //짝이 없다면 "-1", 첫시작이 0 이라면 "0", 그렇지 않다면 sb 그대로를 String으로 리턴
        if (sb.length() == 0) {
            answer = "-1";
        } else if (sb.charAt(0) == '0') {
            answer = "0";
        } else {
            answer = sb.toString();
        }

        return answer;
    }
}
