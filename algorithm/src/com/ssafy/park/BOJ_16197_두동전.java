package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16197_두동전 {
	public static class Coin {
		int y1;
		int x1;
		int y2;
		int x2;

		public Coin(int y1, int x1, int y2, int x2) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
		}
	}
	static int n;
	static int m;
	static char[][] map;
	static int y1, x1, y2, x2;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int ans = 11;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		int c = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'o') {
					if (c == 0) {
						y1 = i;
						x1 = j;
					} else {
						y2 = i;
						x2 = j;
					}
					c++;
				}
			}
		}
		perm(new Coin(y1, x1, y2, x2), 0);
		if (ans == 11) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		br.close();
	}

	private static void perm(Coin coins, int move) {
		if (move > ans || move > 10)
			return;
		for (int i = 0; i < 4; i++) {
			int out = 0;
			int ny1 = coins.y1 + dr[i];
			int nx1 = coins.x1 + dc[i];
			int ny2 = coins.y2 + dr[i];
			int nx2 = coins.x2 + dc[i];
			if (ny1 < 0 || ny1 >= n || nx1 < 0 || nx1 >= m) {
				out++;
			}
			if (ny2 < 0 || ny2 >= n || nx2 < 0 || nx2 >= m) {
				out++;
			}
			if (out == 2)
				continue;
			if (out == 1) {
				ans = Math.min(ans, move + 1);
				return;
			}
			if (map[ny1][nx1] == '#') {
				ny1 = coins.y1;
				nx1 = coins.x1;
			}
			if (map[ny2][nx2] == '#') {
				ny2 = coins.y2;
				nx2 = coins.x2;
			}
			perm(new Coin(ny1, nx1, ny2, nx2), move + 1);
		}
	}
}

