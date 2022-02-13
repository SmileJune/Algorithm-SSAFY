package com.ssafy.hong;

import java.util.Scanner;

public class Boj1695{

    /**
     * [BOJ: 1695] 팰린드롬 만들기
     * 주어진 수열을 팰린드롬으로 만들기 위해
     * 몇몇 수를 추가하는 경우가 생길 수 있다.
     * 추가하는 숫자의 수를 최소로 구하기
     *
     * input:   N           수열의 길이
     *          a1 a2...    수열
     * output:  ans         추가하는 수의 최소 갯수
     */
    static int[][] dp = new int[5001][5001];
    static int[] arr = new int[5001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++)dp[i][j]=-1;
        }
        for(int i=0; i<N; i++)arr[i]=sc.nextInt();
        System.out.println(recur(0,N-1));

    }

    static int recur(int l, int r){
        if(l>=r)return 0;
        if(dp[l][r-l+1]!=-1)return dp[l][r-l+1];
        int res=0;
        if(arr[l] != arr[r]){
            res=Math.min(recur(l+1,r),recur(l,r-1))+1;
        }
        else{
            res = recur(l+1,r-1);
        }
        return dp[l][r-l+1]=res;
    }
}

