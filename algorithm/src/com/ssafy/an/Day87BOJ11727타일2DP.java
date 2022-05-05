package com.ssafy.an;

import java.util.Scanner;

public class Day87BOJ11727타일2DP { // 11727 2xn 타일링2
	static int N;
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new Integer[N];
		dp[0] = 1; // 2x1 칸일 때
		if (N > 1) dp[1] = 3; // 2x2칸일 때 || == ㅁ 3가지 경우
		System.out.println(recur(N - 1));
		sc.close();
	}

	private static int recur(int n) {
		if (dp[n] == null) 
			dp[n] = recur(n - 1) + 2 * recur(n - 2);
		return dp[n] %= 10007;
	}
}
// 1(|)과 2(==), 2(ㅁ)를 더하여 N(횡 길이)을 만드는 경우의 수
// 타일1 문제에서 
// i-1에 |를 더하는 경우의 수, 
// i-2에 ==를 더하는 경우의 수(||은 중복됨.)의 합으로 풀었다.
// 타일2에서는 i-1에 |를 더하는 경우는 동일하지만,
// i-2에 == 또는 ㅁ를 더하는 경우로 2배가 된다.