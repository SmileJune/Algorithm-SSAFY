package com.ssafy.an;

import java.util.Scanner;

public class Day11BOJ2851슈퍼마리오 { // 2851
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 10;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (Math.abs(ans - 100) >= Math.abs(ans + n - 100)) {
				ans += n;
			} else {
				break;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
