package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1949_등산로조성 {
	public static class point {
		int r, c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, k;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = 0;
			int max = 0;
			List<point> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) {
						list = new ArrayList<>();
						list.add(new point(i, j));
						max = map[i][j];
					} else if (map[i][j] == max) {
						list.add(new point(i, j));
					}
				}
			}
			for (int p = 0; p < list.size(); p++) {
				recur(list.get(p), 1, max, false);
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	public static void recur(point start, int cnt, int num, boolean chance) {
		visited[start.r][start.c] = true;
		for (int i = 0; i < 4; i++) {
			int ddr = start.r + dr[i];
			int ddc = start.c + dc[i];

			if (ddr == N || ddr < 0 || ddc == N || ddc < 0)
				continue;

			if (map[ddr][ddc] < num && !visited[ddr][ddc]) {
				recur(new point(ddr, ddc), cnt + 1, map[ddr][ddc], chance);
			}
			else if (map[ddr][ddc] >= num && !visited[ddr][ddc]) {				
				if (!chance) {
					for (int j = 1; j <= k; j++) {
						int temp = map[ddr][ddc] - j;
						if (temp < num ) {
							recur(new point(ddr, ddc), cnt + 1, temp, true);
							break;
						} else continue;
					}
				}
			}
		}
		visited[start.r][start.c] = false;
		ans = Math.max(ans, cnt);
	}
}
