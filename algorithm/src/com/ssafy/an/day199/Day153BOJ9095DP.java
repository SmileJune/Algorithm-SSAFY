package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day153BOJ9095DP {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n] + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
