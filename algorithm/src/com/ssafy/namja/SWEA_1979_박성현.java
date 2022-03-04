package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_1979_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 0) {
						if (sum == K)
							cnt++;
						sum = 0;
					}
					sum += board[i][j];
				}
				if (sum == K)
					cnt++;
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if (board[j][i] == 0) {
						if (sum == K)
							cnt++;
						sum = 0;
					}
					sum += board[j][i];
				}
				if (sum == K)
					cnt++;
			}
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
