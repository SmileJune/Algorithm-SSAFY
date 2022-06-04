package com.ssafy.hwang;

import java.util.Arrays;
import java.util.Scanner;

public class Day0604_BOJ_2217 {
    public static void main(String[] args){
        inputData();
    }
    private static void inputData(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0  ; i<N;i++){
            arr[i] = sc.nextInt();
        }
        // 오름차순 정렬
        Arrays.sort(arr);

        compareToRes(arr);
    }

    private static void compareToRes(int[] arr){
        int res = 0 ;
        for(int i =0  ; i<arr.length;i++){
            res = Math.max(res, arr[i]*( arr.length-i));
        }
        System.out.println(res);
    }
}