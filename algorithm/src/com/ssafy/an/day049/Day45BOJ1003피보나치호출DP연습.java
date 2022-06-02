package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day45BOJ1003피보나치호출DP연습 { // 1003 피보나치수열 호출 DP
	static StringBuilder sb;
	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		dp[0][0] = dp[1][1] = 1;
		dp[0][1] = dp[1][0] = 0;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			recur(N);
			sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static Integer[] recur(int n) {
		if (dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = recur(n - 1)[0] + recur(n - 2)[0];
			dp[n][1] = recur(n - 1)[1] + recur(n - 2)[1];
		}
		return dp[n];
	}
}
