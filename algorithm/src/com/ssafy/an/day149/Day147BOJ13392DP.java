package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day147BOJ13392DP { // 13392 DP 구선생님
	static int N;
	static int[] arr, res;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		res = new int[N + 1];
		dp = new int[N + 1][10];

		String str1 = br.readLine();
		String str2 = br.readLine();

		for (int i = 0; i < N; i++) {
			arr[N - i] = str1.charAt(i) - '0';
			res[N - i] = str2.charAt(i) - '0';
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 10; j++)
				dp[i][j] = dp[i - 1][j] + (arr[i] - res[i] - j + 20) % 10;
			for (int j = 1; j < 20; j++)
				dp[i][j % 10] = Math.min(dp[i][j % 10], dp[i][(j - 1) % 10] + 1);
		}

		System.out.println(dp[N][0]);
		br.close();
	}
}
