package com.ssafy.hwang;

import java.util.Scanner;

/**
 * 배열돌리기 1에서 r을 낮춰주자 => 배열돌리기 2 완성! 바깥 사각형이 커봤자 둘레 1198이니까 그냥 바깥쪽 기준으로 나머지 구해서
 * r을 1198미만으로 낮추자.(N,M<=300이므로)
 * 
 */
public class Day21_BOJ_배열돌리기1 {
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		int min = Math.min(N, M);
		int amount = min / 2;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int j = 0; j < amount; j++) { // 시작인덱스

			int round = 2 * ((N - 2 * j) + (M - 2 * j) - 2); // 테두리 사각형의 갯수
			rot(N, M, j,R%round);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void rot(int N, int M, int amount, int R) {

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int i = amount;
		int j = amount;
		for (int r = 0; r < R; r++) {
			int d = 0;
			int tmp = map[i][j];
			
			while (d != 4) {
				if (i + dx[d] < amount || i + dx[d] >= N - amount || j + dy[d] < amount || j + dy[d] >= M - amount) {
					d++;
					continue;
				}
				map[i][j] = map[i + dx[d]][j + dy[d]];
				i += dx[d];
				j += dy[d];
			}
			map[amount + 1][amount] = tmp;
		}
	}
}