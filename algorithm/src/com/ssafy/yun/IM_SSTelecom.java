package com.ssafy.yun;

import java.util.Scanner;

public class IM_SSTelecom {

	public static Scanner sc = new Scanner(System.in);
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() {
		int n = sc.nextInt();
		int[][] map = new int[n + 6][n + 6];
		boolean[][] uncovered = new boolean[n + 6][n + 6];
		sc.nextLine();
		for (int i = 3; i < 3 + n; i++) {
			String str = sc.nextLine();
			for (int j = 3; j < 3 + n; j++) {
				map[i][j] = str.charAt(j - 3);
				if (str.charAt(j - 3) == 'H') {
					uncovered[i][j] = true;
				}
			}
		}

		for (int i = 3; i < 3 + n; i++) {
			for (int j = 3; j < 3 + n; j++) {
				switch (map[i][j]) {
				case 'A':
					for (int k = 0; k < 4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						uncovered[ni][nj] = false;
					}
					break;
				case 'B':
					for (int mul = 1; mul <= 2; mul++) {
						for (int k = 0; k < 4; k++) {
							int ni = i + mul * dx[k];
							int nj = j + mul * dy[k];
							uncovered[ni][nj] = false;
						}
					}
					break;
				case 'C':
					for (int mul = 1; mul <= 3; mul++) {
						for (int k = 0; k < 4; k++) {
							int ni = i + mul * dx[k];
							int nj = j + mul * dy[k];
							uncovered[ni][nj] = false;
						}
					}
					break;
				}
			}
		}
		int uncoveredHouse = 0;
		for (int i = 3; i < 3 + n; i++) {
			for (int j = 3; j < 3 + n; j++) {
				if (uncovered[i][j] == true) {
					uncoveredHouse++;
				}
			}
		}

		return uncoveredHouse;
	}
}
