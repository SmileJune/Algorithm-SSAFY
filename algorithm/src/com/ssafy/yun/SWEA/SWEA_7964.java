package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_7964 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static int solution() {
		int N = sc.nextInt();
		int limit = sc.nextInt();

		int[] arr = new int[N + 2];
		for (int i = 1; i <= arr.length - 2; i++) {
			arr[i] = sc.nextInt();
		}
		arr[0] = 1;
		arr[arr.length - 1] = 1;

		int len = 0;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				len++;
			}
			if (arr[i] == 1) {
				len = 0;
			}
			if (len == limit) {
				len = 0;
				cnt++;
			}
		}
		return cnt;
	}

}
