package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day69_BOJ_G5_10026_DFS {
	static int N;
	static char map[][];
	static boolean[][][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[2][N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 적록색약 인 거 아닌 거 2번 반복을 돌릴 거니까
		int[] ans = { 0, 0 };
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[k][i][j]) {
						dfs(i, j, visit[k]);
						ans[k]++;
					}

					if (map[i][j] == 'R') {
						map[i][j] = 'G';
					}
				}
			}
		}

		System.out.println(ans[0] + " " + ans[1]);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int r, int c, boolean[][] visit) {
		visit[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
				continue;

			if (map[r][c] == map[nr][nc]) {
				dfs(nr, nc, visit);
			}

		}

	}
}
