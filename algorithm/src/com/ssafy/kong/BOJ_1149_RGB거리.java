package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	static int[][] home;
	static int[][] dp;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; ++j) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][3];
		for (int i = 0; i < 3; ++i) {
			dp[N - 1][i] = home[N - 1][i];
		}
		int ans = Math.min(find(0, 0), find(0, 1));
		ans = Math.min(find(0, 2), ans);
		System.out.println(ans);
	}

	static int find(int r, int c) {
		if (r == N - 1)
			return dp[r][c];
		if (dp[r][c] == 0) {
			if (c == 1) {
				dp[r][c] = Math.min(find(r + 1, c + 1), find(r + 1, c - 1)) + home[r][c];
			} else if (c == 2) {
				dp[r][c] = Math.min(find(r + 1, c - 2), find(r + 1, c - 1)) + home[r][c];
			} else if (c == 0) {
				dp[r][c] = Math.min(find(r + 1, c + 1), find(r + 1, c + 2)) + home[r][c];
			}
		}
		return dp[r][c];
	}
}
