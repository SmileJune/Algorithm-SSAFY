package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day152BOJ1562비트마스킹DP { // 1562
	static final int MOD = 1_000_000_000;
	static int N;
	static long[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new long[N + 1][10][1 << 10];

		for (int i = 1; i <= 9; i++)
			dp[1][i][1 << i] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < 1 << 10; k++) {
					if (j == 0) {
						dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j + 1][k]) % MOD;
					} else if (j == 9) {
						dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j - 1][k]) % MOD;
					} else {
						dp[i][j][k | (1 << j)] = (dp[i][j][k | (1 << j)] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k])
								% MOD;
					}
				}
			}
		}
		long answer = 0;
		for (int i = 0; i <= 9; i++)
			answer += dp[N][i][(1 << 10) - 1];

		System.out.println(answer % MOD);
		br.close();
	}
}
