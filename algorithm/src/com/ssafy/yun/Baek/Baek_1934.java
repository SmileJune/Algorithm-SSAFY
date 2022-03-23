package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1934 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(A * B / GCD(A, B));
		}
	}

	static int GCD(int A, int B) {

		if (B == 0) {
			return A;
		}

		return GCD(B, A % B);
	}

}
