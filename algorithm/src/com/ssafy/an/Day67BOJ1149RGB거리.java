package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day67BOJ1149RGB거리 { // 1149 RGB거리
	static final int R = 0, G = 1, B = 2;
	static int N, ans = 1 << 22;
	static int[][] rgb, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][3];
		dp = new int[N][3];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			rgb[n][R] = Integer.parseInt(st.nextToken());
			rgb[n][G] = Integer.parseInt(st.nextToken());
			rgb[n][B] = Integer.parseInt(st.nextToken());
		}

		dp[0][R] = rgb[0][R];
		dp[0][G] = rgb[0][G];
		dp[0][B] = rgb[0][B];

		ans = m(recur(N - 1, R), m(recur(N - 1, G), recur(N - 1, B)));

		System.out.println(ans);
		br.close();
	}

	private static int recur(int n, int c) {
		if (dp[n][c] == 0) {
			switch (c) {
			case R:
				dp[n][c] = m(recur(n - 1, G), recur(n - 1, B)) + rgb[n][R];
				break;
			case G:
				dp[n][c] = m(recur(n - 1, B), recur(n - 1, R)) + rgb[n][G];
				break;
			case B:
				dp[n][c] = m(recur(n - 1, R), recur(n - 1, G)) + rgb[n][B];
				break;
			}
		}
		return dp[n][c];
	}

	private static int m(int a, int b) {
		return Math.min(a, b);
	}
}
