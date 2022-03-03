package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1850 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		long A = sc.nextLong();
		long B = sc.nextLong();

		long len = recur(A, B);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append("1");
		}
		System.out.println(sb);

	}

	static long recur(long A, long B) {
		if (B == 0) {
			return A;
		}

		return recur(B, A % B);
	}

}
