package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_9095 {

	static Scanner sc = new Scanner(System.in);
	static int n, sum, num;
	static int[] arr;

	public static void main(String[] args) {
		arr = new int[] { 1, 2, 3 };
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			num = 0;
			n = sc.nextInt();
			perm();
			System.out.println(num);
		}
	}

	static void perm() {
		if (sum == n) {
			num++;
			return;
		}
		if (sum > n) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			perm();
			sum -= arr[i];
		}
	}

}
