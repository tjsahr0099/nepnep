package com.nepnep.algorithm;

public class 신규_아이디_추천 {

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        신규_아이디_추천 s = new 신규_아이디_추천();

        System.out.println(s.solution(new_id));
    }

    public String solution(String new_id) {

        //1단계 : 대문자 -> 소문자
        new_id = new_id.toLowerCase();

        //2단계 : -_. 제외한 특수문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        //3단계 : 마침표 2개이상 -> 하나
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        //4단계 : 마침표가 처음이나 끝에 위치할 때 제거
        if (new_id.indexOf(".") == 0) {
            new_id = new_id.replaceFirst(".", "");
        }
        if (new_id.length() > 1 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        //5단계 : 빈 문자열 이라면 a 를 대입
        if (new_id.length() == 0) {
            new_id = "a";
        }

        //6단계 : 길이가 16 이상이라면 15, 마지막이 . 이라면 . 까지 제거
        if (new_id.length() > 15) {
            new_id = new_id.charAt(14) == '.' ? new_id.substring(0, 14) : new_id.substring(0, 15);

        }

        //7단계 : 길이가 2 이하라면 마지막 문자를 길이가 3이 될 때 까지 반복하여 추가
        while (new_id.length() < 3) {
            String last = String.valueOf(new_id.charAt(new_id.length() - 1));
            new_id += last;
        }

        return new_id;
    }
}
