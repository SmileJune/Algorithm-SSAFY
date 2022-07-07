package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day151BOJ17070파이프옮기기DFS { // 17070 그래프 탐색
	static int N, ans;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;

		dfs(0, 1, 0);

		System.out.println(ans);
		br.close();
	}

	private static void dfs(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			ans++;
			return;
		}
		switch (dir) {
		case 0:
			if (c + 1 < N && map[r][c + 1] == 0)
				dfs(r, c + 1, 0);
			break;
		case 1:
			if (r + 1 < N && map[r + 1][c] == 0)
				dfs(r + 1, c, 1);
			break;
		case 2:
			if (c + 1 < N && map[r][c + 1] == 0)
				dfs(r, c + 1, 0);
			if (r + 1 < N && map[r + 1][c] == 0)
				dfs(r + 1, c, 1);
			break;
		}

		if (c + 1 < N && r + 1 < N && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0)
			dfs(r + 1, c + 1, 2);
	}
}
