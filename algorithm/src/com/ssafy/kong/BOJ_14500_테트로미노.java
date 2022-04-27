package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static int N, M;
	static int[][] map;

	static class Dot {
		int r, c;
		int sum;
		int cnt;

		public Dot(int r, int c, int sum, int cnt) {
			this.sum = sum;
			this.cnt = cnt;
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] er = { { 0, 0, 0, 1 }, { 1, 1, 1, 0 }, { 0, 1, 2, 1 }, { 0, 1, 2, 1 } }; // 세로
	static int[][] ec = { { 0, 1, 2, 1 }, { 0, 1, 2, 1 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 } }; // 가로
	static boolean[][] visited;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				visited[i][j] = true;
				dfs(i, j, map[i][j], 1);
				visited[i][j] = false;
				exceptionCase(i, j);
			}
		}
		System.out.println(ans);
	}

	static void exceptionCase(int r, int c) {
		int nr, nc, sum;
		boolean outCheck = false;

		for (int i = 0; i < 4; i++) {
			sum = 0;
			outCheck = false;
			for (int j = 0; j < 4; j++) {
				nr = r + er[i][j]; // 세로
				nc = c + ec[i][j]; // 가로

				// 종이 범위 넘어가는지 체크
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					outCheck = true;
					continue;
				}

				sum += map[nr][nc];
			}

			// 범위 안나갔으면
			if (!outCheck)
				ans = Math.max(sum, ans);
		}
	}

	static void dfs(int r, int c, int sum, int depth) {
		if (depth >= 4) {
			ans = Math.max(ans, sum);
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i]; // 세로
				int nc = c + dc[i]; // 가로

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				// 방문한적 없으면
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc, (sum + map[nr][nc]), depth + 1);

					// 체크 해제
					visited[nr][nc] = false;
				}
			}
		}
	}
}
