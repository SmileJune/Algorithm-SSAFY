package com.ssafy.ehoi;

import java.util.Scanner;

public class Day24_BOJ_B2_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);

		sc.close();
	}
}
