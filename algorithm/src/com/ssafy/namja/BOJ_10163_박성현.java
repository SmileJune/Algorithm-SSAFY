package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_10163_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] board = new int[1001][1001];
		int x_range = 0;
		int y_range = 0;
		for (int n = 1; n <= N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			for (int i = x; i < x + width; i++) {
				for (int j = y; j < y + height; j++) {
					board[i][j] = n;
				}
			}
			x_range = Math.max(x_range, x + width);
			y_range = Math.max(y_range, y + height);
		}

		for (int n = 1; n <= N; n++) {
			int cnt = 0;
			for (int i = 0; i < x_range; i++) {
				for (int j = 0; j < y_range; j++) {
					if (board[i][j] == n)
						cnt++;
				}
			}
			System.out.printf("%d\n",cnt);
		}
	}
}
