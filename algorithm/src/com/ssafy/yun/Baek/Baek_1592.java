package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1592 {

	static int[] arr;
	static int N, M, L;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		if (M == 1) {
			System.out.println(0);
			return;
		}

		int cnt = 0;
		arr = new int[N];

		arr[0]++;
		int pivot = 0;
		while (true) {
			int idx = getIndex(pivot, arr[pivot]);
			arr[idx]++;
			cnt++;
			pivot = idx;

			if (arr[idx] == M)
				break;
		}
		System.out.println(cnt);

	}

	public static int getIndex(int pivot, int num) {
		if (num % 2 == 0) {
			int left = pivot - L;
			if (left < 0)
				left += arr.length;
			return left;
		}

		int right = pivot + L;
		if (right >= arr.length)
			right -= arr.length;

		return right;
	}

}
