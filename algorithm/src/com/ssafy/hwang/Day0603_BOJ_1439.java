package com.ssafy.hwang;

import java.util.Scanner;

public class Day0603_BOJ_1439 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String input = inputData(sc);

        int[] res = removeContinuity(input);

        System.out.println( res[0]>res[1]? res[1] : res[0]);
    }

    private static String inputData(Scanner sc) {
        // 데이터 입력
        return sc.nextLine();
    }

    private static int[] removeContinuity(String input) {
        // 연속된 숫자 제거된 문자열 저장할 문자열
        String tmp = input.charAt(0)+"";

        // 연속된 문자 제거
        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i-1) != input.charAt(i)){
                tmp+= input.charAt(i);
            }
        }
        // 갯수세기
        return cntNum(tmp);
    }

    private static int[] cntNum(String s) {
        int[] res = new int[2];

        // 0과 1 갯수 세기
        for(int i = 0 ; i< s.length();i++){
            if(s.charAt(i) == '0') res[0] ++;
            else res[1]++;
        }

        return res;
    }
}