package com.ssafy.hwang;

import java.util.Scanner;

public class Day72_BOJ_가장긴감소하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		
		int[] arr = new int[A];
		for(int i =0 ; i<A;i++) {
			arr[i] = sc.nextInt();
		}
		int res=0;
		int[] dp = new int[A];
		for(int i =0; i<A;i++) {
			dp[i] = 1;
			for(int j =0; j<i;j++) {
				if(arr[i]<arr[j]) {
					dp[i] = Math.max(dp[i],dp[j]+1); 
				}
			}
			res = Math.max(res,dp[i]);
		}
		System.out.println(res);
	}
}
