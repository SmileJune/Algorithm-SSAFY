package com.ssafy.yun;

import java.util.Scanner;

public class SWEA_2005 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		int[][] map = new int[10][10];
		for (int i = 0; i < map.length; i++) {
			map[i][0] = 1;
			for (int j = 1; j < i; j++) {
				map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
			}
			map[i][i] = 1;
		}
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d%n", tc);
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
