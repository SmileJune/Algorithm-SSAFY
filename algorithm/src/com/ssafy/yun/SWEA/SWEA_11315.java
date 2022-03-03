package com.ssafy.yun;

import java.util.Scanner;

public class SWEA_11315 {

	static Scanner sc = new Scanner(System.in);
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };
	static char[][] map;
	static int N;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %s%n", tc, solution());
		}
	}

	static String solution() {
		N = sc.nextInt();
		map = new char[N][N];
		for (int i = 0; i < map.length; i++) {
			map[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (check(i, j))
					return "YES";
			}
		}

		return "NO";
	}

	static boolean check(int i, int j) {
		if (map[i][j] == '.') {
			return false;
		}

		int nr = -1;
		int nc = -1;
		int len = -1;
		int cnt = -1;
		for (int d = 0; d < 4; d++) {
			len = 1;
			cnt = 1;
			while (true) {
				nr = i + len * dr[d];
				nc = j + len * dc[d];

				// 범위밖
				if (!isInRange(nr, nc)) {
					break;
				}

				// 돌없음
				if (map[nr][nc] == '.') {
					break;
				}

				cnt++;
				len++;

				if (cnt == 5) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isInRange(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < N) {
			return true;
		}
		return false;
	}

}
