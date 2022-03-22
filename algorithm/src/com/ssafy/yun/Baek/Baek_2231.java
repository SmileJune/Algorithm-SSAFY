package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2231 {

	static Scanner sc = new Scanner(System.in);
	static int N;

	public static void main(String[] args) {
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			if (isThat(i)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}

	static boolean isThat(int i) {
		int sum = i;
		while (true) {
			if (i == 0) {
				break;
			}
			sum += i % 10;
			i /= 10;
		}
		if (sum == N) {
			return true;
		}
		return false;
	}
}
