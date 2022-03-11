package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1748 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		if (N < 10) {
			System.out.println(N);
			return;
		}

		int len = ("" + N).length();

		int a = 0;
		int b = 0;

		for (int i = 1; i <= len - 1; i++) {
			a += 9 * Math.pow(10, i - 1) * i;
		}

		b = (int) ((N - (Math.pow(10, len - 1) - 1)) * len);

		System.out.println(a + b);
	}

}
