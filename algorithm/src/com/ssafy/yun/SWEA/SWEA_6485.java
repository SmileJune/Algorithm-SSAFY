package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_6485 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ",tc);
			solution();
			System.out.println();
		}
	}

	static void solution() {
		int[] arr = new int[5001];

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			for (int j = first; j <= second; j++) {
				arr[j]++;
			}
		}

		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int idx = sc.nextInt();
			System.out.printf("%d ", arr[idx]);
		}
	}

}
