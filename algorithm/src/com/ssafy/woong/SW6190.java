package com.ssafy.woong;

import java.util.Arrays;
import java.util.Scanner;

public class SW6190 {

	// 4 2 7 10 => 2 4 7 10
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] num = new int[n];

			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}

			for (int i = 0; i < num.length; i++) {
				for (int j = 0; j < num.length - i - 1; j++) {
					if (num[j + 1] < num[j]) {
						int tmp = num[j + 1];
						num[j + 1] = num[j];
						num[j] = tmp;
					}
				}
			}

			boolean flag = true;
			int max = 0;
			for (int i = num.length - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					if (isIncrease(num[i] * num[j])) {
						if (max < num[i] * num[j]) {
							max = num[i] * num[j];
						}
						flag = false;
					}
				}
			}
			if (flag) {
				System.out.printf("#%d %d\n", tc, -1);
			}
			else {
				System.out.printf("#%d %d\n", tc, max);
			}

		}
	}

	static boolean isIncrease(int n) {

		char[] arr = String.valueOf(n).toCharArray();
		char comp = arr[0];
		for (char ch : arr) {
			if (ch >= comp) {
				comp = ch;
				continue;
			}
			return false;
		}
		return true;
	}

}
