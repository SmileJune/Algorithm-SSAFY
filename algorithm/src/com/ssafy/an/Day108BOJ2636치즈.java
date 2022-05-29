package com.ssafy.an;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day108BOJ2636치즈 {
	static int N, M, cnt, ans;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		visit = new boolean[N][M];

		for (ans = 0; check(); ans++) {
			for (boolean[] arr : visit) {
				Arrays.fill(arr, false);
			}
			visit[0][0] = true;
			cnt = 0;

			dfs(0, 0);
		}

		System.out.println(ans + "\n" + cnt + "\n");
		br.close();
	}

	public static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (index(nr, nc))
				continue;

			if (!visit[nr][nc]) {
				visit[nr][nc] = true;
				if (map[nr][nc] == 1) {
					map[nr][nc] = 2;
					cnt++;
				} else
					dfs(nr, nc);
			}
		}
	}

	public static boolean check() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 2)
					map[i][j] = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 1)
					return true;
		return false;
	}

	private static boolean index(int dr, int dc) {
		return dr < 0 || dc < 0 || dr >= N || dc >= M;
	}
}
