package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();
		int last = sc.nextInt();

		for (int i = init; i <= last; i++) {
			if (isPrimeNumber(i)) {
				System.out.println(i);
			}
		}

	}

	public static boolean isPrimeNumber(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
