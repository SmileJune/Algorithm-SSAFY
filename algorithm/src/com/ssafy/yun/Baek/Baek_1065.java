package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1065 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int num = 0;
		for (int i = 1; i <= N; i++) {
			if (isHansoo(i)) {
				num++;
			}
		}
		System.out.println(num);

	}

	static boolean isHansoo(int num) {
		// 1자리
		if (num < 10) {
			return true;
		}

		// 2자리이상
		String str = "" + num;
		int diff = str.charAt(0) - str.charAt(1);
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) - str.charAt(i + 1) != diff) {
				return false;
			}
		}
		return true;
	}

}
