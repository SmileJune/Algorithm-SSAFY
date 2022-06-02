package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day83BOJ11055가큰증부수DP { // 11055 가장 큰 증가 부분 수열
	static int N, ans;
	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new Integer[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++)
			ans = Math.max(ans, recur(i));
		System.out.println(ans);
		br.close();
	}

	private static int recur(int n) {
//		System.out.println(Arrays.toString(dp).replaceAll("ull", ""));
		if (n == -1)
			return 0;
		if (dp[n] != null)
			return dp[n];
		dp[n] = arr[n];
		for (int i = n - 1; i >= 0; i--)
			if (arr[n] > arr[i])
				dp[n] = Math.max(dp[n], recur(i) + arr[n]);
		return dp[n];
	}
}
