package com.ssafy.an;

import java.util.Scanner;

public class Day21SW2005파스칼의삼각형 { // 2005 파스칼의 삼각형
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			StringBuilder ans = new StringBuilder();
			arr = new int[N][N];

			arr[0][0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (i - 1 >= 0 && j - 1 >= 0) {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					} else if (i - 1 >= 0) {
						arr[i][j] = arr[i - 1][j];
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					ans.append(arr[i][j]);
					if (j != i) {
						ans.append(" ");
					}
				}
				if (i != N - 1)
					ans.append("\n");
			}
			sb.append("#").append(tc).append("\n").append(ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
