package com.ssafy.an.day099;

import java.util.Scanner;

public class Day79BOJ1789수들의합구현 { // 1789 수들의 합 구현
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(sol(sc.nextLong()));
		sc.close();
	}

	private static long sol(long N) {
		int n = 0, i = 0;
		long S = 0L;
		while (true) {
			S += ++i;
			if (S > N)
				return n;
			n++;
		}
	}
}
