package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0627_JO_1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int gcd = arr[0];
		int lcm = arr[0];
		for (int i = 1; i < n; i++) {
			gcd = get_GCD(arr[i], gcd);
			lcm = arr[i] * lcm / get_GCD(lcm, arr[i]);
		}
		
		System.out.printf("%d %d", gcd, lcm);

		sc.close();
	}

	// 유클리드 호제법
	private static int get_GCD(int x, int y) {
		if (y == 0) {
			return x;
		}

		if (x > y) {
			return get_GCD(y, x % y);
		} else {
			return get_GCD(x, y % x);
		}
	}
}
