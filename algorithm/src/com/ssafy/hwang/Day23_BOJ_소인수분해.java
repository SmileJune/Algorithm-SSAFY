package com.ssafy.hwang;

import java.util.Scanner;

public class Day23_BOJ_소인수분해 {
	static boolean[] isNotPrime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		if (N == 1) {
			System.out.println();
			return;
		}
		isNotPrime = new boolean[N + 1];
		isNotPrime[1] = true;
		getPrime(N);
		int tmp = N;
		for (int i = 2; i <= N; i++) {
			if (!isNotPrime[i]) {
				if (tmp % i == 0) {
					tmp = tmp/i;
					sb.append(i + "\n");
					i--;
				}
			}
		}

		System.out.println(sb.toString());
	}

	public static void getPrime(int N) {

		for (int i = 2; i < Math.sqrt(N); i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
	}
}
