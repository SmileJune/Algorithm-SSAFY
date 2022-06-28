package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day141BOJ15683감시브루트포스 { // 15683 감시
	static int N, M, ans, cnt;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int[][][] cDir = { //
			{ { 0 } }, // 미사용
			{ { 1 }, { 2 }, { 3 }, { 0 } }, // 1
			{ { 1, 3 }, { 0, 2 } }, // 2
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, // 3
			{ { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } }, // 4
			{ { 0, 1, 2, 3 } } // 5
	};

	static List<int[]> cctv;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		int[][] map = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					cnt++;
				else if (map[i][j] > 0 && map[i][j] != 6)
					cctv.add(new int[] { i, j, map[i][j] });
			}
		}
		ans = cnt;

		dfs(0, cnt, map);

		System.out.println(ans);
		br.close();
	}

	private static void dfs(int idx, int remine, int[][] map) {
		if (idx == cctv.size()) {
			ans = Math.min(ans, remine);
			return;
		}
		int[][] tmp = copy(map);

		int[] cc = cctv.get(idx);
		for (int i = 0; i < cDir[cc[2]].length; i++) {
			int c = 0;
			for (int j = 0; j < cDir[cc[2]][i].length; j++) {
				int d = cDir[cc[2]][i][j];
				c += observation(cc[0], cc[1], d, tmp);
			}
			dfs(idx + 1, remine - c, tmp);
			tmp = copy(map);
		}
	}

	private static int observation(int r, int c, int d, int[][] map) {
		int cnt = 0;
		while (true) {
			r += dr[d];
			c += dc[d];
			if (r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 6)
				break;
			if ((map[r][c] >= 1 && map[r][c] <= 5) || map[r][c] == -1)
				continue;
			map[r][c] = -1;
			cnt++;
		}
		return cnt;

	}

	private static int[][] copy(int[][] map) {
		int[][] tmp = new int[N][];
		for (int i = 0; i < N; i++)
			tmp[i] = map[i].clone();
		return tmp;
	}
}
