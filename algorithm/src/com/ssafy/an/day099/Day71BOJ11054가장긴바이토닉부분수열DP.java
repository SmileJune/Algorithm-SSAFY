package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day71BOJ11054가장긴바이토닉부분수열DP { // 11054 가장 긴 바이토닉 수열
	static int N, ans;
	static int[] arr;
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		ans = -1;
		arr = new int[N];
		dp = new Integer[N][2]; // 0: LIS(), 1: LDS()
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++)
			ans = Math.max(LIS(i) + LDS(i), ans);
		System.out.println(ans - 1);
		br.close();
	} // 이걸 자력으로 짤 수 있는 가..

	private static int LIS(int n) {
		if (dp[n][0] == null) {
			dp[n][0] = 1;
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] < arr[n])
					dp[n][0] = Math.max(dp[n][0], LIS(i) + 1);
			}
		}
		return dp[n][0];
	}

	private static int LDS(int n) {
		if (dp[n][1] == null) {
			dp[n][1] = 1;
			for (int i = n + 1; i < dp.length; i++) {
				if (arr[i] < arr[n])
					dp[n][1] = Math.max(dp[n][1], LDS(i) + 1);
			}
		}
		return dp[n][1];
	}
}
