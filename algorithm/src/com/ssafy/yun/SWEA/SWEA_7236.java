package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_7236 {

	static Scanner sc = new Scanner(System.in);
	static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() {
		int N = sc.nextInt();

		char[][] map = new char[N + 2][N + 2];

		for (int i = 1; i < 1 + N; i++) {
			for (int j = 1; j < 1 + N; j++) {
				map[i][j] = sc.next().charAt(0);
			}
		}

		int max = 1;
		for (int i = 1; i < 1 + N; i++) {
			for (int j = 1; j < 1 + N; j++) {
				if (map[i][j] != 'W')
					continue;

				int num = 0;
				for (int k = 0; k < dr.length; k++) {
					int ni = i + dr[k];
					int nj = j + dc[k];
					if (map[ni][nj] == 'W') {
						num++;
					}
				}
				max = Math.max(max, num);
			}
		}

		return max;
	}

}
