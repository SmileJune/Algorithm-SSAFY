package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_1961 {
	static Scanner sc = new Scanner(System.in);
	static int N;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			solution();
		}
	}

	static void solution() {
		N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[][] map90 = rotate(map);
		int[][] map180 = rotate(map90);
		int[][] map270 = rotate(map180);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map90[i][j]);
			}
			System.out.printf(" ");

			for (int j = 0; j < N; j++) {
				System.out.print(map180[i][j]);
			}
			System.out.printf(" ");

			for (int j = 0; j < N; j++) {
				System.out.print(map270[i][j]);
			}
			System.out.println();
		}

	}

	static int[][] rotate(int[][] map) {
		int[][] mapRotate = new int[N][N];
		for (int i = 0; i < mapRotate.length; i++) {
			for (int j = 0; j < mapRotate[i].length; j++) {
				mapRotate[i][j] = map[N - 1 - j][i];
			}
		}

		return mapRotate;
	}

}
