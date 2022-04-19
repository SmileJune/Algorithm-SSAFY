package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085_사탕게임 {
	static int N;
	static char[][] candy;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candy = new char[N][N];
		for (int i = 0; i < N; ++i) {
			candy[i] = br.readLine().toCharArray();
		}

		findAns();
		System.out.println(max);

	}

	static int max = 0;

	private static void findAns() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				for (int k = 0; k < 4; ++k) {
					int nr = dr[k] + i;
					int nc = dc[k] + j;
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
						continue;
					}
					if (candy[i][j] != candy[nr][nc]) {
						char tmp = candy[i][j];
						candy[i][j] = candy[nr][nc];
						candy[nr][nc] = tmp;
						findMax();
						tmp = candy[i][j];
						candy[i][j] = candy[nr][nc];
						candy[nr][nc] = tmp;
					}
				}
			}
		}
	}

	private static void findMax() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				count(i, j);
			}
		}

	}

	public static void count(int x, int y) {

		int yy = y, xx = x, row = 1, col = 1;
		// 연속된 행
		for (int i = y + 1; i < N; i++) {
			if (candy[x][yy] == candy[x][i]) {
				row++;
				yy = i;
			} else
				break;
		}

		// 연속된
		for (int i = x + 1; i < N; i++) {
			if (candy[xx][y] == candy[i][y]) {
				col++;
				xx = i;
			} else
				break;
		}

		int result = Math.max(row, col);
		max = Math.max(result, max);
	}
}
