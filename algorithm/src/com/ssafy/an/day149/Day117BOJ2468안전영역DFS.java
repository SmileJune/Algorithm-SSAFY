package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day117BOJ2468안전영역DFS { // 2468 안전영역
	static int N, ans, max;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		ans = 0;
		max = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				max = Math.max(max, map[i][j] = Integer.parseInt(st.nextToken()));
		}
		for (int h = 0; h < max + 1; h++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && h < map[i][j])
						cnt += dfs(i, j, h);
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
		br.close();
	}

	private static int dfs(int idx, int jdx, int h) {
		visited[idx][jdx] = true;
		for (int i = 0; i < 4; i++) {
			int nr = idx + dr[i];
			int nc = jdx + dc[i];

			if (index(nr, nc) || visited[nr][nc])
				continue;
			if (map[nr][nc] > h)
				dfs(nr, nc, h);
		}
		return 1;
	}

	private static boolean index(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= N || nc >= N;
	}
}
