package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_16926 {

	// 남동북서
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M, R;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		int[][] map = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			map = rotate(map);
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int[][] rotate(int[][] map) {
		boolean[][] visited = new boolean[N][M];
		int[][] mapAfter = new int[N][M];

		// 남동북서
		// 0,0 1,1 2,2 3,3 ->
		for (int i = 0; i < Math.min(N, M); i++) {
			int r = i;
			int c = i;
			int len = (N - 2 * i) + (M - 2 * i) - 4;
			// 하나의 방향으로 들어가기 시작하면 멈출때까지 값을 넣어주고 나오고
			// 남동북서로 쭉 넣어주면된다.
			// 0,0 부터 시작해서 1,1 2,2 ...
			for (int d = 0; d < 4; d++) {
				while (true) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!isInRange(nr, nc)) {
						break;
					}

					if (visited[nr][nc] == true) {
						break;
					}

					mapAfter[nr][nc] = map[r][c];
					visited[nr][nc] = true;
					r = nr;
					c = nc;
				}

			}
		}
		return mapAfter;
	}

	static boolean isInRange(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M) {
			return true;
		}
		return false;
	}

}
