package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_11050 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int K = sc.nextInt();

		System.out.println(fac(N) / fac(K) / fac(N - K));

	}

	static int fac(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		return fac(n - 1) * n;
	}

}
