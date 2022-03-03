package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1100 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] map = new int[8][8];
		for (int i = 0; i < map.length; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 != 0) {
					continue;
				}

				if (map[i][j] == 'F') {
					cnt++;
				}
			}
		}

		System.out.println(cnt);

	}

}
