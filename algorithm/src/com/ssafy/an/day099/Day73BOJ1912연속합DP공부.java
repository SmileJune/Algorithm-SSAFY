package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day73BOJ1912연속합DP공부 { // 1912 연속합
	static int N, ans;
	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];
		dp = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = arr[0];
		ans = arr[0];
		recur(N - 1);

		System.out.println(ans);
		br.close();
	}

	private static int recur(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);
//			System.out.println(Arrays.toString(dp).replaceAll("null", "nn"));
			ans = Math.max(ans, dp[n]);
		} // 최대값 dp로 찾는 기본 구성
		return dp[n];
	}
}
