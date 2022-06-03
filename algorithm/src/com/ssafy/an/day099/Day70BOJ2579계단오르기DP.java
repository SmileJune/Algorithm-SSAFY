package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day70BOJ2579계단오르기DP { // 2579 계단 오르기 동적계획법
	static int N;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		if (N > 1)
			dp[2] = arr[1] + arr[2];
		// 3칸 연속 밟을 수 없으므로, 1, 3 또는 2, 3번칸을 밟아야 한다.
		for (int i = 3; i < N + 1; i++)
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];

		System.out.println(dp[N]);
		br.close();
	}
}
