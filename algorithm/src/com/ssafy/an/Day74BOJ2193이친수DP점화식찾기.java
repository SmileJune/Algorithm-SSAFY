package com.ssafy.an;

import java.util.Scanner;

public class Day74BOJ2193이친수DP점화식찾기 {
	static int N, ans;
	static Long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		dp = new Long[N + 1];
		System.out.println(recur(N));
		sc.close();
	}

	private static long recur(int n) {
		if (n < 2)
			return dp[n] = (long) n;
		if (dp[n] == null)
			dp[n] = recur(n - 1) + recur(n - 2);
		return dp[n];
	}
}
