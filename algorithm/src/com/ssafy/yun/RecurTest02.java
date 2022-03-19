package com.ssafy.yun;

public class RecurTest02 {

	public static void main(String[] args) {
		System.out.println(solve1(10)); // 반복 이용
		System.out.println(solve2(10)); // 재귀 이용
		System.out.println(solve3(10, 0)); // 재귀 이용
	}

	// 자연수 n까지의 합
	static int solve1(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

	// 변경되는 값은 매개변수로 처리.
	static int solve2(int n) {
		if (n == 1) {
			return 1;
		}
		// 재귀함수가 해야할 일
		return n + solve2(n - 1);
	}

	static int solve3(int n, int sum) {
		if (n == 0) {
			return sum;
		}
		// 재귀함수가 해야할 일
		return solve3(n - 1, sum + n);
	}
}