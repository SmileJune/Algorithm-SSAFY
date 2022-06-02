package com.ssafy.an.day099;

import java.util.Scanner;

public class Day57BOJ11051이항계수2 { // 이항 계수 2
	static final int DIV = 10007;
	static int N, K;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 자연수 N
		int K = sc.nextInt(); // 정수 K

		dp = new int[N + 1][K + 1];

		System.out.println(recur(N, K));
		sc.close();
	}

	private static int recur(int n, int k) {
		if (dp[n][k] > 0) return dp[n][k];
		if (k == 0 || n == k) return dp[n][k] = 1;
		return dp[n][k] = (recur(n - 1, k - 1) + recur(n - 1, k)) % DIV;
	}

	private static int factorial(int n) {
		return (n < 2) ? n : factorial(n - 1) * n;
	} // 안씀

	private static int modInverse(int a, int p) {
		int ret = 1;
		while (p > 0) {
			if (p % 2 == 1) {
				ret *= a;
				p--;
				ret %= DIV;
			}
			a *= a;
			a %= DIV;
			p >>= 1;
		}
		return ret;
	} // 안씀
}
