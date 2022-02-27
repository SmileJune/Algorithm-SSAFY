package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1733_오목 {
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };
	static int ly = 0;
	static int lx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[21][21];
		for (int i = 1; i <= 19; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (find(map, 1)) {
			System.out.println(1);
			System.out.println(ly + " " + lx);
		} else if (find(map, 2)) {
			System.out.println(2);
			System.out.println(ly + " " + lx);
		} else if (!find(map, 1) && !find(map, 2)) {
			System.out.println(0);
		}

	}

	static boolean find(int[][] map, int color) {
		for (int i = 1; i <= 19; ++i) {
			for (int j = 1; j <= 19; ++j) {
				int cnt = 0;
				if (map[i][j] == color) {
					for (int k = 0; k < 4; ++k) {
						cnt = 1;
						int nr = 0;
						int nc = 0;
						if (map[i - dr[k]][j - dc[k]] == color) {
							continue;
						}
						for (int m = 1; m <= 4; ++m) {
							nr = i + dr[k] * m;
							nc = j + dc[k] * m;
							if (nr >= 1 && nr <= 19 && nc <= 19 && nc >= 1) {
								if (map[nr][nc] == color)
									cnt++;
							}
						}
						nr += dr[k];
						nc += dc[k];
						if (nr >= 0 && nr <= 20 && nc <= 20 && nc >= 0) {
							if (map[nr][nc] != color) {
								if (cnt == 5) {
									ly = i;
									lx = j;
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

}