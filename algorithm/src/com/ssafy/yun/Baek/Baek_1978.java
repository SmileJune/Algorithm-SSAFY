package com.ssafy.yun;

import java.util.Scanner;

public class Baek_1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < num; i++) {
			if (isPrimeNumber(sc.nextInt())) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static boolean isPrimeNumber(int num) {

		if (num < 2)
			return false;
//
		if (num == 2 || num == 3 || num == 5)
			return true;
//
//		if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0)
//			return false;
//
//		int order = num / 6;
//		for (int i = 1; i <= order + 1; i++) {
//			if (num % (6 * i + 1) == 0 || num % (6 * i + 5) == 0) {
//				return false;
//			}
//		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

}
