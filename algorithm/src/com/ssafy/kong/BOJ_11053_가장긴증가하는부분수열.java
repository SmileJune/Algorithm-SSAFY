package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열2 {

	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			find(i);
		}
		int max = dp[0];
		// 최댓값 찾기
		for (int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	static int find(int N) {

		if (dp[N] == null) {
			dp[N] = 1; 

			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < arr[N]) {
					dp[N] = Math.max(dp[N], find(i) + 1);
				}
			}
		}
		return dp[N];
	}
	
	/* 시간초과..
	 * static void recure(int idx, int ans) {
		if (idx == N - 1) {
			max = Math.max(max, ans);
		}
		for (int i = idx + 1; i < N; ++i) {
			if (arr[idx] < arr[i]) {
				recure(i, ans + 1);
			}
		}
	}
	 * */
}