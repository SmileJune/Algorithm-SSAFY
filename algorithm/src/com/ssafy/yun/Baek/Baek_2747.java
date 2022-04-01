package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2747 {

	static Scanner sc = new Scanner(System.in);
	static long[] arr = new long[46];

	public static void main(String[] args) {
		int N = sc.nextInt();
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= 45; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(arr[N]);

	}
}
