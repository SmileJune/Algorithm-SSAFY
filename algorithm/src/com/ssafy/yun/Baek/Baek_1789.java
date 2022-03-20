package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1789 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		long S = sc.nextLong();
		long n = 0;
		while (true) {
			n++;
			if (S < sum(n)) {
				n--;
				break;
			}
		}
		System.out.println(n);

	}

	static long sum(long n) {
		return (n + 1) * n / 2;
	}

}
