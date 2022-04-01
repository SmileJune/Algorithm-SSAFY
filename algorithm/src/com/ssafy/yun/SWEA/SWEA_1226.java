package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_1226 {

	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	static boolean[][] visited;
	static int[] start, end;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d\n", tc, solution());
		}
	}

	static int solution() {
		map = new int[16][16];
		visited = new boolean[16][16];
		sc.nextLine();

		for (int i = 0; i < map.length; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j + 1));
				if (map[i][j] == 2) {
					start = new int[] { i, j };
				}
				if (map[i][j] == 3) {
					end = new int[] { i, j };
				}
			}
		}

		try {
			dfs(start[0], start[1]);
		} catch (Exception e) {
			return 1;
		}
		return 0;
	}

	static void dfs(int i, int j) throws Exception {
		if (map[i][j] == 3) {
			throw new Exception();
		}
		visited[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + dx[d];
			int nj = j + dy[d];
			if (isPossible(ni, nj)) {
				dfs(ni, nj);
			}
		}
	}

	static boolean isPossible(int i, int j) {
		if (map[i][j] == 1)
			return false;
		if (visited[i][j] == true)
			return false;
		return true;
	}

}
