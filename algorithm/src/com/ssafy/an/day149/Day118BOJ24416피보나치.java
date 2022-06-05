package com.ssafy.an.day149;

import java.util.Scanner;

public class Day118BOJ24416피보나치{
    static int N;
    static int[] d;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        d = new int[41];
        d[0]=0;
        d[1]=1;
        d[2]=1;
        d[3]=2;
        for(int i = 3;i<41;i++){
            d[i] = d[i-2]+d[i-1];
        }
        System.out.println(d[N]+" "+(N-2));
    }
}
