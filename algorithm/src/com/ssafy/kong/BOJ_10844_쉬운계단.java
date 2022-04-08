package com.ssafy.BOJ_SB;

import java.util.Scanner;

public class BOJ_10844_쉬운계단 {
	static int N;
	static long[][] dp;
	static long mod = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N + 1][10];
		for (int i = 1; i <= 9; ++i) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; ++i) {
			for (int j = 0; j < 10; ++j) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1] % mod;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][j - 1] % mod;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		long ans = 0;
		for (int i = 0; i < 10; ++i) {
			ans += dp[N][i];
		}

		System.out.println(ans % mod);
	}

}
