package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_10988 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String str = sc.nextLine();

		System.out.println(check(str));

	}

	static int check(String str) {

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return 0;
			}
		}

		return 1;
	}

}
