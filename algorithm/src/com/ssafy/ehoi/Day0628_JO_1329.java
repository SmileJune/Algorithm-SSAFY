package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0628_JO_1329 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n < 0 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			sc.close();
			return;
		}

		int mid = n / 2;
		for (int i = 1; i <= mid + 1; i++) {
			for (int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = mid; i >= 1; i--) {
			for (int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}
}
