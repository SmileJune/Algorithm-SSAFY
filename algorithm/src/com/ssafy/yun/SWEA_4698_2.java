package com.ssafy.yun;

import java.util.Scanner;

public class SWEA_4698_2 {

	static boolean[] isNotPrime = new boolean[(int) (Math.pow(10, 6) + 1)];
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		setIsNotPrime();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static void setIsNotPrime() {
		isNotPrime[0] = isNotPrime[1] = true;
		for (int i = 2; i * i <= isNotPrime.length; i++) {
			if (isNotPrime[i] == false) {
				for (int j = i * i; j < isNotPrime.length; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
	}

	static int solution() {
		int D = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();

		int cnt = 0;
		for (int i = A; i <= B; i++) {
			if (isNotPrime[i] == false && (i + "").contains(D + "")) {
				cnt++;
			}
		}
		return cnt;
	}
}
