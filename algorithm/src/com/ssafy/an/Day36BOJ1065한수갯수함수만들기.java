package com.ssafy.an;

import java.util.Scanner;

public class Day36BOJ1065한수갯수함수만들기 { // 1065 한수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(cal(sc.nextInt()));
		sc.close();
	}

	private static int cal(int n) {
		int cnt = 99;
		if (n < 100)
			return n;
		else {
			if (n == 1000)
				n = 999;
			for (int i = 100; i <= n; i++) {
				int h = i / 100;
				int t = (i / 10) % 10;
				int o = i % 10;
				if ((h - t) == (t - o))
					cnt++;
			}
		}
		return cnt;
	}
}
