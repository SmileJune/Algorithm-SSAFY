package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static class Loc {
		int r, c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] map;

	static List<Loc> virus = new ArrayList<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<Loc> list;
	static Loc[] sel;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Loc(i, j));
				}
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					list.add(new Loc(i, j));
				}
			}
		}
		sel = new Loc[3];
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			ans = Math.max(ans, countDis());
			return;
		}

		for (int i = start; i < list.size(); ++i) {
			sel[cnt] = list.get(i);
			comb(cnt + 1, i + 1);
		}
	}

	private static int countDis() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 3; ++i) {
			tmp[sel[i].r][sel[i].c] = 1;
		}

		Queue<Loc> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); ++i) {
			q.add(virus.get(i));
		}
		while (!q.isEmpty()) {
			Loc now = q.remove();
			for (int i = 0; i < 4; ++i) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if (isFine(nr, nc) && tmp[nr][nc] == 0) {
					q.add(new Loc(nr, nc));
					tmp[nr][nc] = 2;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (tmp[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static boolean isFine(int nr, int nc) {
		if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
			return false;
		}
		return true;

	}
}
