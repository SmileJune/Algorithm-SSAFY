package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day164BOJ1520내리막DFSDP { // 1520
	static int N, M;
	static int[][] map;
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new Integer[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 0));
		br.close();
	}

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	private static int dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			return 1;
		}
		if (dp[r][c] == null) {
			dp[r][c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (index(nr, nc))
					continue;
				if (map[nr][nc] < map[r][c])
					dp[r][c] += dfs(nr, nc);
			}
		}
		return dp[r][c];
	}

	private static boolean index(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= N || nc >= M;
	}
}
