package com.ssafy.an;

import java.util.Arrays;
import java.util.Scanner;

public class Day61BOJ9461파도반수열재귀 { // 9461 파도반의 수열
	static long[] arr; // 이 정도 크기는 재귀나 반복 메모리, 속도 비슷함.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new long[101];
		Arrays.fill(arr, -1);
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			System.out.println(padovan(N));
		}
		sc.close();
	}

	private static long padovan(int n) {
		if (arr[n] == -1)
			arr[n] = padovan(n - 2) + padovan(n - 3);
		return arr[n];
	}
}
