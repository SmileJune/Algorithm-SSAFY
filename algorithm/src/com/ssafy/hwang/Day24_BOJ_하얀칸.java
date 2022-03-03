package com.ssafy.hwang;

import java.util.Scanner;

public class Day24_BOJ_하얀칸 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] map = new char[8][8];
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			String tmp = sc.next();
			for (int j = 0; j < 8; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					if (map[i][j] == 'F')
						cnt++;
				}
				if (i % 2 == 1 && j % 2 == 1) {
					if (map[i][j] == 'F')
						cnt++;

				}
			}
		}
		System.out.println(cnt);
	}
}
