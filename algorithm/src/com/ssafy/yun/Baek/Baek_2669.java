package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2669 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] map = new int[101][101];

		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int k = x1 + 1; k <= x2; k++) {
				for (int j = y1 + 1; j <= y2; j++) {
					map[k][j] = 1;
				}
			}

		}

		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
