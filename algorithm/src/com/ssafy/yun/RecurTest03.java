package com.ssafy.yun;

public class RecurTest03 {

	public static void main(String[] args) {
		System.out.println(solve1(10, 4)); // 10의 4승을 구해라!
		System.out.println(solve2(10, 4)); // 10의 4승을 구해라!

	}

	// 자연수 n까지의 합
	static int solve1(int n, int cnt) {
		int sum = 0;
		for (int i = 1; i <= cnt; i++) {
			sum *= cnt;
		}
		return sum;
	}

	// 변경되는 값은 매개변수로 처리.
	static int solve2(int n, int cnt) {
		if (cnt == 1) {
			return 10;
		}

		return n * solve2(n, cnt - 1);

	}

}
