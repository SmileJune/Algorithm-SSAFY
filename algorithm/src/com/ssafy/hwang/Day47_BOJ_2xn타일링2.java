
package com.ssafy.hwang;

import java.util.Scanner;

public class Day47_BOJ_2xn타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N : Between 1 AND 1000
		int N = sc.nextInt();

		int[] dp = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			if (i < 2) {
				dp[i] = 1;
				continue;
			}
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);
		sc.close();
	}

}