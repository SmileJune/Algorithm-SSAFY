package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0627_JO_1523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		if (!(1 <= n && n <= 100) || !(1 <= m && m <= 3)) {
			System.out.println("INPUT ERROR!");
			sc.close();
			return;
		}

		switch (m) {
		case 1:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = n; i >= 1; i--) {
				for (int j = i; j >= 1; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n - i; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= 2 * i - 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}

		sc.close();
	}
}
