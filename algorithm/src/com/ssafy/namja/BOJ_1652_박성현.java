package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1652_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[n][n];
		for (int i = 0 ; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		
		int verCnt = 0 , horCnt = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				if (map[i][j] == '.') {
					count++;
					if (count == 2)
						verCnt++;
				}
				else count = 0;
			}
		}
		
		for (int i = 0; i < n; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				if (map[j][i] == '.') {
					count++;
					if (count == 2)
						horCnt++;
				}
				else count = 0;
			}
		}
		System.out.printf("%d %d",verCnt, horCnt);
		sc.close();
	}
}
