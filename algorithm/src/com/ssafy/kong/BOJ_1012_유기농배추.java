package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int M, N, K;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;

	static class Dot {
		int r, c;

		public Dot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			// 걍 세로로 받든 가로로 받는 상관없다.
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (!visited[i][j] && map[i][j] == 1) {
						BFS(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static void BFS(int r, int c) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(r, c));
		visited[r][c] = true;
		while (!q.isEmpty()) {
			Dot d = q.remove();
			for (int i = 0; i < 4; ++i) {
				int nr = dr[i] + d.r;
				int nc = dc[i] + d.c;
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					q.add(new Dot(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
}
