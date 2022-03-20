package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_14490 {

	static Scanner sc = new Scanner(System.in);
	static int a, b;

	public static void main(String[] args) {
		String[] str = sc.nextLine().split(":");
		a = Integer.parseInt(str[0]);
		b = Integer.parseInt(str[1]);

		int gcd = gcd(a, b);

		System.out.printf("%d:%d", a / gcd, b / gcd);

	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}

}
