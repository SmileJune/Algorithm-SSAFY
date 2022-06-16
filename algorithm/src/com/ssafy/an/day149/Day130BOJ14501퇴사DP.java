package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day130BOJ14501퇴사DP { // 14501 퇴사
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());

		int[] t = new int[n];
		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			if (i + t[i] <= n)
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[n]);
		br.close();
	}
}
