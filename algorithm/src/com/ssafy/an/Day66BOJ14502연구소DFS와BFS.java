package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day66BOJ14502연구소DFS와BFS {
	static int N, M, ans;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] map, vmap;
	static List<int[]> vlist;
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;

		map = new int[N][M];
		vlist = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					vlist.add(new int[] { i, j });
				}
			}
		}
		// 1. 3개 선택 dfs()
		// 2. 바이러스 시뮬레이션 bfs()
		// 3. 안전지역 체크
		dfs(0);

		System.out.println(ans);
		br.close();
	}

	private static void dfs(int d) {
		if (d == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 3;
					dfs(d + 1);
					map[i][j] = 0; // visited 대용
				}
			}
		}
	}

	private static void bfs() {
		vmap = new int[N][];
		for (int i = 0; i < N; i++)
			vmap[i] = map[i].clone();

		q = new LinkedList<>();

		for (int[] a : vlist)
			q.add(a);

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (index(nr, nc))
					continue;
				if (vmap[nr][nc] != 0)
					continue;
				vmap[nr][nc] = 2;
				q.add(new int[] { nr, nc });
			}
		}
		check(vmap);
	}

	private static void check(int[][] a) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] == 0)
					cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}

	private static boolean index(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}
}
