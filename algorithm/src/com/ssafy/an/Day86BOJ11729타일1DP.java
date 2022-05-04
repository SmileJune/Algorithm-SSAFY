package com.ssafy.an;

import java.util.Scanner;

public class Day86BOJ11729타일1DP { // 11726 2xn 타일링
	static int N;
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new Integer[N];
		dp[0] = 1; // 2x1 칸일 때
		dp[1] = 2;
		System.out.println(recur(N-1));
		sc.close();
	}

	private static int recur(int n) {
		if (dp[n] == null) {			
			dp[n] = recur(n - 1) + recur(n - 2);
		}
		return dp[n] % 10007;
	}
}
// 2x1 |
// 2x2 || 			==
// 2x3 |== 			==| 		|||
// 2x4 ==== 		|==| 		||== 		==|| 		||||
// 2x5 |==|| 		||==| 		||||| 		|====  		====|
// --- |||==		==|||		==|==
// 2x6 ====== 		|==|==		||==== 		==||== 		||||==
// --- |==||| 		||==|| 		|||||| 		|====| 		====||
// --- |||==|		==||||		==|==|
// 값 자체는 피보나치 수열과 같은 증가 양상을 보이지만,
// 실제로는 1(|)과 2(==)를 더하여 N(횡 길이)을 만드는 경우의 수