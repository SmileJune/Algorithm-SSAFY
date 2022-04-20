package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day72BOJ11053LISDP재귀 {
	static int N, ans;
	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		ans = 1;
		st = new StringTokenizer(br.readLine());

		arr = new int[N];
		dp = new Integer[N];

		dp[0] = 1;

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++)
			LIS(i);
		for (int i = 0; i < N; i++)
			ans = Math.max(ans, dp[i]);
		
		System.out.println(ans);
		br.close();
	}

	// LIS : 최장 증가 부분 수열
	private static int LIS(int n) {
		if (dp[n] == null) {
			dp[n] = 1;
			for (int i = n - 1; i >= 0; i--)
				if (arr[i] < arr[n])
					dp[n] = Math.max(dp[n], LIS(i) + 1);
		}
		return dp[n];
	}
}
