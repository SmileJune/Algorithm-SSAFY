package com.ssafy.an;

import java.util.Arrays;
import java.util.Scanner;

public class Day88BOJ2133타일채우기DP {
	static int N;
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new Integer[N + 1];
		System.out.println(recur(N));
		System.out.println(Arrays.toString(dp));
		sc.close();
	}

	private static int recur(int n) {
		if (n % 2 == 1) return 0;
		if (n == 0) return 1; // n번째 특이케이스 2*1을 위한 
		if (n == 2) return dp[2] = 3;
		if (dp[n] == null) {
			dp[n] = recur(2) * recur(n - 2); // 3x2를 뒤에 붙히는 (편의상)기본형
			for (int i = 4; i < n + 1; i += 2) // 4부터 특이 케이스가 생긴다. 
				dp[n] += 2 * recur(n - i); // n-4의 경우의 수에 4때 생겼던 특이 케이스 2개를 곱한 경우의 수
		}
		return dp[n];
	}
}
// 규칙성은 3x짝수에서 나타나며, 홀수인경우는 모두 채울 수 없다.
// 짝수 부분만 손풀이를 해보면,
// 3x2는 ㅠ ㅛ 三 으로 볼 수 있으며, 
// 3-2 : 3
// 3x4는 3x2에 3x2를 붙히는 경우의 수와 1칸 밀린 특이케이스 +2
// 3-4 : 3*3 + 2*1 = 11
// 3x6은 3x4에 3x2를 붙힌 경우와, 3x4특이케이스 앞에 3x2를 붙히고(2개씩 존재),
// 거기에 3x6 1칸 밀린 특이 케이스 +2
// 3-6 : 11*3 + 2*3 + 2*1 = 41
// 3x8은 3x6에 3x2를 붙힌 경우와 특이케이스에 3x2를 붙힌 경우 들의 합 
// 에 3x8 기준 1칸 밀린 케이스 +2
// 3-8 : 41*3 + 2*11 + 2*3 + 2*1 = 153
// 특이케이스의 점화식은 dp[n] = 2(dp[n-2] + dp[n-4] ... dp[n-n])   
// 3-10 : 153*3 + 2*41 + 2*11 + 2*3 + 2*1 = 571