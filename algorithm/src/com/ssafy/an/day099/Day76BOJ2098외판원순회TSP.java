package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day76BOJ2098외판원순회TSP {
	static final int INF = 16 * 1_000_000;
	static int N;
	static int[][] arr;
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new Integer[N][(1 << N) - 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(TSP(0, 1));
		br.close();
	}

	private static int TSP(int n, int visit) {
		if (visit == (1 << N) - 1)
			return arr[n][0] == 0 ? INF : arr[n][0];
		if (dp[n][visit] != null)
			return dp[n][visit];
		dp[n][visit] = INF;
		for (int i = 0; i < N; i++) {
//			print(dp);
			if (arr[n][i] == 0 || (visit & (1 << i)) > 0)
				continue;
			dp[n][visit] = Math.min(dp[n][visit], TSP(i, (visit | 1 << i)) + arr[n][i]);
		}

		return dp[n][visit];
	}

	static int pcnt = 1;
	private static void print(Integer[][] a) {
		StringBuilder tt = new StringBuilder();
		tt.append("===== " + pcnt++ + "번째 =====\n");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				tt.append((dp[i][j] != null) ? dp[i][j] : "n").append("\t");
			}
			tt.append("\n");
		}
		System.out.println(tt.toString());
	}
}
