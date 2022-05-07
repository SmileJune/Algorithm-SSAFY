package com.ssafy.an;

import java.util.Scanner;

public class Day90BOJ2133타일채우기DP개선 {
	static int N;
	static Integer[] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new Integer[N + 1];
		System.out.println(recur(N));
		sc.close();
	}

	private static int recur(int n) {
		if (n % 2 == 1) return 0;
		if (n == 0) return 1;
		if (n == 2) return d[2] = 3;
		if (d[n] == null)
			d[n] = 4 * recur(n - 2) - recur(n - 4); // for문이 사라짐..
		return d[n];
	}
}
//dp[n] = dp[n-2]*3 + 2(dp[n-4] ~ dp[n-n])
//d[4] = 3*d[2] + 2*d[0]
//d[6] = 3*d[4] + 2*d[2] + 2*d[0]
//---- = 3*d[4] + 2*d[2] + 2*d[0] + d[2] - d[2]
//---- = 3*d[4] + 3*d[2] + 2*d[0] - d[2]
//---- = 3*d[4] + d[4] - d[2]
//---- = 4*d[4] - d[2] (4*d[n-2] - d[n-4])
//d[8] = 3*d[6] + 2*d[4] + 2*d[2] + 2*d[0]
//---- = 3*d[6] + 2*d[4] + 2*d[2] + 2*d[0] + d[4] - d[4]
//---- = 3*d[6] + 3*d[4] + 2*d[2] + 2*d[0] - d[4]
//---- = 3*d[6] + d[6] - d[4]
//---- = 4*d[6] - d[4]
//d[n] = 4d[n-2] - d[n-4] <<-- 최종식