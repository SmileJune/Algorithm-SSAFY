package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0628_JO_1719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 받기
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 입력이 잘못 됐을 때 처리
		if (n < 0 || n > 100 || n % 2 == 0 || m < 1 || m > 4) {
			System.out.println("INPUT ERROR!");
			sc.close();
			return;
		}

		int mid = n / 2;

		// 본 처리
		if (m == 1) {
			for (int i = 1; i <= mid; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = mid + 1; i <= n; i++) {
				for (int j = 1; j <= n + 1 - i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 2) {
			for (int i = 1; i <= mid; i++) {
				// 공백
				for (int j = mid + 1 - i; j >= 1; j--) {
					System.out.print(" ");
				}
				// 별
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = mid + 1; i >= 1; i--) {
				// 공백
				for (int j = mid + 1 - i; j > 0; j--) {
					System.out.print(" ");
				}
				// 별
				for (int j = i; j >= 1; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 3) {
			for (int i = mid; i >= 1; i--) {
				// 공백
				for (int j = 0; j < mid - i; j++) {
					System.out.print(" ");
				}
				// 별
				for (int j = 2 * i + 1; j >= 1; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 1; i <= mid + 1; i++) {
				for (int j = 0; j < mid + 1 - i; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= 2 * i - 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 4) {
			for (int i = mid + 1; i >= 1; i--) {
				for (int j = 0; j < mid + 1 - i; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 1; i <= mid; i++) {
				for (int j = 1; j <= mid; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= i + 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}

		sc.close();
	}
}
