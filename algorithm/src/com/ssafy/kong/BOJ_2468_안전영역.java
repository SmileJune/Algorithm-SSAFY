package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Dot {
		int r, c;

		public Dot(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		int max = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		int ans = 1;
		for (int k = 1; k < max; ++k) {
			int tmp = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] > k && !visited[i][j]) {
						BFS(k, i, j);
						tmp++;
					}
				}
			}
			ans = Math.max(tmp, ans);
		}
		System.out.println(ans);
	}

	static void BFS(int k, int r, int c) {
		Queue<Dot> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new Dot(r, c));
		while (!q.isEmpty()) {
			Dot now = q.remove();
			for (int i = 0; i < 4; ++i) {
				int nr = dr[i] + now.r;
				int nc = dc[i] + now.c;
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (map[nr][nc] > k && !visited[nr][nc]) {
					q.add(new Dot(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
}
