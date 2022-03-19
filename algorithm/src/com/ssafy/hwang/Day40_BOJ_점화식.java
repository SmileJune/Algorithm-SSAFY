package com.ssafy.hwang;

import java.util.Scanner;

public class Day40_BOJ_점화식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n + 1];
		dp[0] = 1;
		if (n > 0) {
			dp[1] = 1;
			for (int i = 2; i < dp.length; i++) {
				for (int j = 0; j < i; j++) {
					dp[i] += (dp[j] * dp[i - 1 - j]);
				}
			}
		}
		System.out.println(dp[n]);
	}
}
