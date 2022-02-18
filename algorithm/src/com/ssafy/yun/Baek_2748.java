package com.ssafy.yun;

import java.util.Scanner;

public class Baek_2748 {

	static long[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new long[N + 1];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(arr[N]);
	}
}
