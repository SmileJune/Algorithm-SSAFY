package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2563 {

	public static int[][] map;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		map = new int[101][101];

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					map[i][j]++;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
