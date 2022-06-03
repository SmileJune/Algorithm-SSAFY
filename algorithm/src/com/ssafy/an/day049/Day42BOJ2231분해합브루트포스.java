package com.ssafy.an.day049;

import java.util.Scanner;

public class Day42BOJ2231분해합브루트포스 { // 2231 분해합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int tmp = i;
			int sum = 0;
			while (tmp != 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			if (sum + i == N) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);
		sc.close();
	}
}
