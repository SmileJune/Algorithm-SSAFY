package com.ssafy.yun;

import java.util.Scanner;

public class SWEA_1989 {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int T = sc.nextInt();
		sc.nextLine();

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() {
		String str = sc.nextLine();

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i))
				return 0;
		}

		return 1;
	}

}
