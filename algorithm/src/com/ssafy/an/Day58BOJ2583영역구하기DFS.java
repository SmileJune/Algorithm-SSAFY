package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day58BOJ2583영역구하기DFS { // 2583 영역구하기 DFS
	static class Pos {
		int r, c, d;

		Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int N, M, K;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static List<Integer> ans;
	static Queue<Pos> q;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); // 순서
		K = Integer.parseInt(st.nextToken());
		ans = new ArrayList<>();

		map = new boolean[N ][M ];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			for (int i = r1; i < r2; i++) {
				for (int j = c1; j < c2; j++) {
					map[i][j] = true;
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!map[i][j])
					bfs(i, j);
			}
		}

		Collections.sort(ans);
		sb.append(ans.size()).append("\n");
		for (int a : ans) {
			sb.append(a).append(" ");
		}

		System.out.println(sb);
		br.close();
	}

	private static void bfs(int idx, int jdx) {
		q = new LinkedList<>();

		q.add(new Pos(idx, jdx, 0));
		map[idx][jdx] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			Pos p = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length)
					continue;

				if (!map[nr][nc]) {
					map[nr][nc] = true;
					q.add(new Pos(nr, nc, p.d));
				}
			}
		}
		ans.add(cnt);
	}
}
