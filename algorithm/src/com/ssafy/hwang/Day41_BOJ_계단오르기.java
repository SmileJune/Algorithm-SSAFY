package com.ssafy.hwang;

import java.util.Scanner;

public class Day41_BOJ_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] point = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			point[i] = sc.nextInt();
		}
		dp[1] = point[1];
		if(N>=2) {
			dp[2] = point[1]+point[2];
		}
		
		for(int i = 3; i <= N; i++) {
			dp[i] = point[i] + Math.max(dp[i-2], dp[i-3]+point[i-1]);
		}
		
		System.out.println(dp[N]);
		
		
	}
}
