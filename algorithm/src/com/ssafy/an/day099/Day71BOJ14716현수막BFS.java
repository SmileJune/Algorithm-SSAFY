package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day71BOJ14716현수막BFS {
	static int N, M, ans;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 }, dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[][] map;
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					bfs(i, j);
			}
		}

		System.out.println(ans);
		br.close();
	}

	private static void bfs(int idx, int jdx) {
		ans++;

		q = new LinkedList<>();

		q.add(new int[] { idx, jdx });
		while (!q.isEmpty()) {
			int[] a = q.poll();
			int r = a[0];
			int c = a[1];
			map[r][c] = 0;
			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (index(nr, nc))
					continue;
				if (map[nr][nc] == 0)
					continue;
				map[nr][nc] = 0;
				q.add(new int[] { nr, nc });
			}
		}
	}

	private static boolean index(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}
}
