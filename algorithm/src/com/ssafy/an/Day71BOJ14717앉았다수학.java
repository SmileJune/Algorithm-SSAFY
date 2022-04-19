package com.ssafy.an;

import java.util.Scanner;

public class Day71BOJ14717앉았다수학 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%.3f\n", solve(sc.nextInt(), sc.nextInt()));
		sc.close();
	}

	private static double solve(int a, int b) {
		int cases = (18 * 17) / (2 * 1);
		int cnt = 0;
		if (a == b)
			cnt = cases - (10 - a);
		else {
			int e = (a + b) % 10;
			for (int i = 1; i < 11; i++) {
				for (int j = i + 1; j < 11; j++) {
					if ((i + j) % 10 < e) {
						if (i == a || i == b || j == a || j == b)
							cnt += 2;
						else
							cnt += 4;
					}
				}
			}
		}
		return cnt / (cases * 1.0);
	}
}
