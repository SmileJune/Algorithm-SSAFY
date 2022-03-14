package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_11022 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.printf("Case #%d: %d + %d = %d%n", tc, a, b, a + b);
		}
	}

}
