package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1769 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.next();
		if (str.length() == 1) {
			System.out.println(0);
			if ((str.charAt(0) - '0') % 3 == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			return;
		}

		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num += str.charAt(i) - '0';
		}
		int cnt = 1;

		while (true) {
			if (num < 10) {
				System.out.println(cnt);
				break;
			}

			int n = num;
			num = 0;
			while (n != 0) {
				num += n % 10;
				n /= 10;
			}
			cnt++;
		}

		if (num % 3 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
