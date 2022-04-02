package com.ssafy.hwang;

import java.util.Scanner;

public class Day53_BOJ_바닥장식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		int cnt = 0;
		char[][] map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '-') {
					cnt++;
					while (j < c && map[i][j] == '-') {
						j++;
					}
				}
			}
		}
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (map[j][i] == '|') {
					cnt++;
					while (j < r && map[j][i] == '|') {
						j++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}