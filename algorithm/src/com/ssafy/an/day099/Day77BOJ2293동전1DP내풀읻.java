package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day77BOJ2293동전1DP내풀읻 { // 2293 동전 1
	static int N, K;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		dp = new int[K + 1];

		// dp[10] = dp[9] + dp[8] + dp[5]
		// dp[9] = dp[8] + dp[7] + dp[4]
		// dp[8] = dp[7] + dp[6] + dp[3]
		// dp[7] = dp[6] + dp[5] + dp[2]
		// dp[6] = dp[5] + dp[4] + dp[1]
		// dp[5] = dp[4] + dp[3] + dp[0]
		// dp[4] = dp[3] + dp[2]
		// dp[3] = dp[2] + dp[1]
		// dp[2] = dp[1] + dp[0]
		// dp[1] = dp[1]
		// dp[0] = 1
		// dp[k] = dp[k-1] + dp[k-2] + dp[k-5]
		// dp[k] = dp[k-arr[0] + dp[k-arr[1]] + dp[k-arr[2]]

		dp[0] = 1;
		for (int a : arr) {
			for (int k = a; k < K + 1; k++) {
				dp[k] += dp[k - a];
			}
		}

		System.out.println(dp[K]);
		br.close();
	}
}
