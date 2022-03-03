package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_7272 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %s%n", tc, solution());
		}
	}

	public static String solution() {
		String str1 = sc.next();
		String str2 = sc.next();

		if (str1.length() != str2.length()) {
			return "DIFF";
		}

		for (int i = 0; i < str1.length(); i++) {
			if (check(str1.charAt(i)) != check(str2.charAt(i))) {
				return "DIFF";
			}
		}

		return "SAME";
	}

	public static int check(char ch) {
		if ("CEFGHIJKLMNSTUVWXYZ".contains(ch + "")) {
			return 0;
		}
		if ("ADOPQR".contains(ch + "")) {
			return 1;
		}
		return 2;
	}
}