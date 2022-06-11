package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day101BOJ10026적록색약DFS {
	static int N;
	static int[] ans, dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static boolean[][][] visit;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = new int[2];
		visit = new boolean[2][N][N];

		map = new char[N][];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		for (int k = 0; k < 2; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					if (!visit[k][i][j]) {
						dfs(i, j, k, map[i][j]);
						ans[k]++;
					}
					if (map[i][j] == 'G')
						map[i][j] = 'R';
				}

		System.out.println(ans[0] + " " + ans[1]);
		br.close();
	}

	private static void dfs(int r, int c, int k, int cl) {
		visit[k][r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (index(nr, nc) || visit[k][nr][nc] || map[nr][nc] != cl)
				continue;
			dfs(nr, nc, k, cl);
		}
	}

	private static boolean index(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= N;
	}
}
