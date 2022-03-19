package com.ssafy.yun;

public class RecurTest04 {

	public static void main(String[] args) {
		System.out.println(solve1(12345)); // 10의 4승을 구해라!
		System.out.println(solve2(12345)); // 10의 4승을 구해라!

	}

	// 자연수 n까지의 합
	static int solve1(int n) {
		int ans = 0;
		while (true) {
			ans += n % 10;
			if (n < 10) {
				break;
			}
			n /= 10;
		}
		return ans;
	}

	// 변경되는 값은 매개변수로 처리.
	static int solve2(int n) {
		if (n < 10) {
			return n;
		}

		return n % 10 + solve2(n / 10);
	}

}
