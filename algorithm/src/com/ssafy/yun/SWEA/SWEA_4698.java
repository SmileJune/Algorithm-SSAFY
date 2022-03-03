package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_4698 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static int solution() {
		int D = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();

		int cnt = 0;
		for (int i = A; i <= B; i++) {
			if (isPrimeNumber(i) && hasD(i, D)) {
				cnt++;
			}
		}
		return cnt;
	}

	static boolean isPrimeNumber(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean hasD(int num, int D) {
		while (num > 0) {
			int digit = num % 10;
			num /= 10;

			if (digit == D) {
				return true;
			}
		}
		return false;
	}
}
