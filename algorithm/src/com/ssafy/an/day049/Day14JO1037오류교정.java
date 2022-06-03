package com.ssafy.an.day049;

import java.util.Scanner;

public class Day14JO1037오류교정 { // 1037 오류교정
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		String ans = "Corrupt";

		if (check(arr, N)) {
			ans = "OK";
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = arr[i][j];
					arr[i][j] = (arr[i][j] + 1) % 2;
					if (check(arr, N)) {
						ans = "Change bit (" + (i + 1) + "," + (j + 1) + ")";
						break;
					}
					arr[i][j] = tmp;
				}
			}
		}

		System.out.println(ans);
		sc.close();
	}

	private static boolean check(int[][] arr, int N) {
		int rsum = 0;
		int csum = 0;
		for (int i = 0; i < N; i++) {
			rsum = 0;
			csum = 0;
			for (int j = 0; j < N; j++) {
				rsum += arr[i][j]; // 행 고정 합
				csum += arr[j][i]; // 열 고정 합
			}
			if (rsum % 2 != 0 || csum % 2 != 0) {
				return false;
			}
		}
		// 나오면 합이 모두 짝수
		return true;
	}
}
