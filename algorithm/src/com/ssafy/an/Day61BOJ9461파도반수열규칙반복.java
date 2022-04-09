package com.ssafy.an;

import java.util.Scanner;

public class Day61BOJ9461파도반수열규칙반복 { // 9461 파도반의 수열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		for (int i = 6; i < 101; i++) {
			arr[i] = arr[i - 1] + arr[i - 5];
		}
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			System.out.println(arr[N]);
		}
		sc.close();
	}
}
