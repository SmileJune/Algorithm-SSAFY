package com.ssafy.hwang;

import java.util.Scanner;

public class Day29_BOJ_123더하기 {
	static int n;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			int sum = 0;
			cnt = 0;
			solution(sum);

			System.out.println(cnt);
		}
	}

	public static void solution(int sum) {
		if (sum == n) {
			cnt++;
			return;
		} else if (sum > n) {
			return;
		}

		solution(sum + 1);
		solution(sum + 2);
		solution(sum + 3);

	}
}
