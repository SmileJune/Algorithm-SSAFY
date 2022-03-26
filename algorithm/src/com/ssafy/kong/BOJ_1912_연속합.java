package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
	static int N;
	static int[] arr;
	static Integer[] dp;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new Integer[N];
//		Arrays.fill(dp, -1000);
//		find(0);
//		Arrays.sort(dp);
//		System.out.println(dp[N - 1]);
		dp[0] = arr[0];
		max = arr[0];
		find(N - 1);
		System.out.println(max);
	}
	// 시간초과코드 ㅠㅠ
//	static void find(int idx) {
//		if (idx == N) {
//			return;
//		}
//		int sum = 0;
//		for (int i = idx; i < arr.length; ++i) {
//			sum += arr[i];
//			dp[idx] = Math.max(dp[idx], sum);
//		}
//		find(idx + 1);
//	}

	static int find(int N) {

		// 탐색하지 않은 인덱스라면
		if (dp[N] == null) {
			dp[N] = Math.max(find(N - 1) + arr[N], arr[N]);

			max = Math.max(dp[N], max);
		}

		return dp[N];
	}
}
