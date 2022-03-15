package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1932_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] dt = new int[N][N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				dt[i][j] = sc.nextInt();
			}
		}
		
		dp[0][0] = dt[0][0];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j > 0)
					dp[i][j] = dp[i - 1][j - 1] + dt[i][j];
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + dt[i][j]);
			}
		}
		
		int max = -1;
		for (int i = 0; i < N; i++) 
			max = Math.max(max, dp[N - 1][i]);
		
		System.out.println(max);
	}
}