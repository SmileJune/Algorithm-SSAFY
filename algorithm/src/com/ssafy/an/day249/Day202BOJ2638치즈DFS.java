package com.ssafy.an.day249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day202BOJ2638치즈DFS {
	static int N, M, tot = 0, ans = 0;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tot += map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					list.add(new int[] { i, j });
			}
		}
		while (tot > 0) {
			ans++;
			visited = new boolean[N][M];
			dfs(0, 0);
			melt();
		}
		System.out.println(ans);
		br.close();
	}

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	private static void melt() {
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			int cnt = 0;
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (map[nr][nc] == -1)
					cnt++;
			}
			if (cnt > 1) {
				map[r][c] = 0;
				tot--;
				list.remove(i--);
			}
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		map[r][c] = -1;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (index(nr, nc))
				continue;
			if (visited[nr][nc])
				continue;
			if (map[nr][nc] == 1)
				continue;
			dfs(nr, nc);
		}
	}

	private static boolean index(int r, int c) {
		return r < 0 || c < 0 || r >= N | c >= M;
	}
}
