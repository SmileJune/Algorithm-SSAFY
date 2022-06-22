package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0621_JO_1341 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();

		// e가 s보다 크다면 증가해야 하니까
		if (s < e) {
			for (int i = s; i <= e; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.printf("%d * %d = %2d   ", i, j, i * j);
					// j가 3의 배수일 때마다 줄바꿈
					if (j % 3 == 0) {
						System.out.println();
					}
				}
				// 한 단이 끝나고 나면 줄 바꿈
				System.out.println();
			}
		} else {
			for (int i = s; i >= e; i--) {
				for (int j = 1; j <= 9; j++) {
					System.out.printf("%d * %d = %2d   ", i, j, i * j);
					if (j % 3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
		}

		sc.close();
	}
}
