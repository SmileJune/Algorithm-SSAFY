package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_10872 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();

		System.out.println(fac(n));
	}

	static int fac(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * fac(n - 1);
	}

}
