package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0629_JO_1641 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받기
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 입력 조건 처리하기
		if (n < 0 || n > 100 || n % 2 == 0 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			sc.close();
			return;
		}

		// 출력
		if (m == 1) {
			int[][] arr = new int[n][n];
			int num = 1;

			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j <= i; j++) {
						arr[i][j] = num++;
					}
				} else {
					for (int j = i; j >= 0; j--) {
						arr[i][j] = num++;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0) {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
		} else if (m == 2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("  ");
				}
				for (int j = 0; j < (n - i) * 2 - 1; j++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			
		} else if (m == 3) {
			for (int i = 1; i < n / 2 + 1; i++) {
				int num = 1;
				for (int j = 1; j <= i; j++) {
					System.out.print(num++ + " ");
				}
				System.out.println();
			}
			for (int i = n / 2 + 1; i >= 1; i--) {
				int num = 1;
				for (int j = 1; j <= i; j++) {
					System.out.print(num++ + " ");
				}
				System.out.println();
			}
		}
		

		sc.close();
	}
}
