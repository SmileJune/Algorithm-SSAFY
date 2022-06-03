package com.ssafy.an.day099;

import java.util.Scanner;

public class Day71BOJ10844쉬운계단오르기DP { // 10844 쉬운? 계단 오르기
	static final int SIBUK = 1_000_000_000;
	static int N;
	static Long[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new Long[N + 1][10];
		System.out.println(solve());
		sc.close();
	}

	private static long solve() {
		for (int i = 0; i < 10; i++)	dp[1][i] = 1L;
		long res = 0;
		for (int i = 1; i < 10; i++)	res += recur(N, i);
		return res % SIBUK;
	}
	// 점화식 찾는 게 중요하다. 1, 9의 예외와 나머지 분리.
	private static long recur(int n, int v) {
		if (n == 1)				return dp[n][v];
		if (dp[n][v] != null)	return dp[n][v] % SIBUK;
		if (v == 0)				dp[n][v] = recur(n - 1, 1);
		else if (v == 9)		dp[n][v] = recur(n - 1, 8);
		else					dp[n][v] = recur(n - 1, v - 1) + recur(n - 1, v + 1);
		return dp[n][v] % SIBUK;
	}
}
