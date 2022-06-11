package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day115SW1865동철이일분배DP {
	static int N;
	static double ans;
	static int[][] map;
	static Double[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 0.0;
			map = new int[N][N];
			dp = new Double[1 << N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			sb.append("#" + tc + " ").append(String.format("%.6f\n", dfs(0, 0) / Math.pow(100, N - 1)));
		}
		System.out.println(sb);
		br.close();
	}

	private static double dfs(int idx, int visit) {
		if (idx >= N)
			return 1;
		if (dp[visit] == null) {
			dp[visit] = 0.0;
			for (int i = 0; i < N; i++) {
				if ((visit & 1 << i) > 0)
					continue;
				dp[visit] = Math.max(dp[visit], dfs(idx + 1, visit | 1 << i) * map[idx][i]);
			}
		}
//		System.out.println(Arrays.toString(dp));
		return dp[visit];
	}
}
