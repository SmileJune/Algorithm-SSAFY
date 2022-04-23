package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day75BOJ12865평범한배낭 { // 12865 평범한 배낭
	static int N, K;
	static int[][] list;
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new int[N][2];
		dp = new Integer[N][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(recur(N - 1, K));
		br.close();
	}

	private static int recur(int n, int k) {
//		print(dp);
		if (n < 0)
			return 0;

		if (dp[n][k] == null)
			if (list[n][0] > k)
				dp[n][k] = recur(n - 1, k);
			else
				dp[n][k] = Math.max(recur(n - 1, k), recur(n - 1, k - list[n][0]) + list[n][1]);

		return dp[n][k];
	}

	private static void print(Integer[][] a) {
		StringBuilder tt = new StringBuilder();
		tt.append("=====\n");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				tt.append((dp[i][j] != null) ? dp[i][j] : "n").append("\t");
			}
			tt.append("\n");
		}
		System.out.println(tt.toString());
	}
}
