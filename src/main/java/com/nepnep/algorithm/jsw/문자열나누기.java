package com.nepnep.algorithm.jsw;

public class 문자열나누기 {

//    public int solution(String s){
//
//        char[] arr = s.toCharArray();
//        int result = 0;
//        char x = arr[0];
//        for (int i = 0; i < arr.length; i++){
//
//            int cntX = 1;
//            int cntY = 0;
//
//            if(x == arr[i+1]){
//                cntX++;
//            }else{
//                cntY++;
//            }
//
//            //마지막이 될 경우에도 result 올려주자
//            if (cntX == cntY){
//                result++;
//                x = arr[i+2];
//                i++;
//            }
//
//        }
//        return result;
//    }

    public int solution2(String s){
        char[] arr = s.toCharArray();
        char x;
        int result = 0;

        for (int i = 0; i < arr.length; i++){
            String test = "";
            if(i == arr.length - 1){
                System.out.println(arr[i]);
                return result + 1;
            }
            //비교 대상
            x = arr[i];

            int cntX = 1;
            int cntY = 0;

            test += x;
            for (int j = i+1; j < arr.length; j++) {

                test += arr[j];

                //비교 && 카운트
                if(x == arr[j]){
                    cntX++;
                }else{
                    cntY++;
                }

                //처음으로 같아 질 때 문자열 쪼개기
                if(cntX == cntY){
                    System.out.print(test+"-");
                    result++;
                    i = j;
                    break;
                //끝까지 같아지지 않았을 때
                }else if(j == arr.length - 1){
                    System.out.println(test+"-");
                    return result += 1;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        문자열나누기 c = new 문자열나누기();
        String s = "abracadabraq";
//        s = "banana";
        System.out.println(c.solution2(s));


    }
}
