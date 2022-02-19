package com.ssafy.yun;

import java.util.Scanner;

public class Baek_10163 {

	public static int[][] map;
	public static int x, y, width, height;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		map = new int[1001][1001];

		for (int i = 1; i <= T; i++) {
			solution(i);
		}

		for (int i = 1; i <= T; i++) {
			int cnt = 0;
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[j].length; k++) {
					if (map[j][k] == i) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

	public static void solution(int order) {
		x = sc.nextInt();
		y = sc.nextInt();
		width = sc.nextInt();
		height = sc.nextInt();

		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + height; j++) {
				map[i][j] = order;
			}
		}
	}

}
