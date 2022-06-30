package com.ssafy.ehoi;

import java.util.Scanner;

// 파스칼 삼각형
public class Day0630_JO_2071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] arr = new int[n][n];

		// 제일 왼쪽으로 1로 채운다
		for (int i = 0; i < n; i++) {
			arr[i][0] = 1;
		}

		// 나머지 점화식으로 표현이 가능한 부분을 채운다
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}

		// 종류별로 출력한다
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		} else if (m == 2) {
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < n - 1 - i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0) {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
		} else if (m == 3) {
			for (int i = n - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (arr[j][i] != 0) {
						System.out.print(arr[j][i] + " ");
					}
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
