package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1009 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println(solution());
		}
	}

	static int solution() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int num = 1;
		for (int i = 0; i < b; i++) {
			num *= a;
			num %= 10;
		}
		if (num == 0) {
			return 10;
		}

		return num;
	}

}
