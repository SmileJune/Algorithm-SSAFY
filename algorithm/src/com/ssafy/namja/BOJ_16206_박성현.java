package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_16206_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] cakes = new int[N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			cakes[i] = sc.nextInt();
			if (cakes[i] == 10)
				cnt++;
		}
		sort(cakes);

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (cakes[j] > 10) {
					cakes[j] -= 10;
					if (cakes[j] == 10)
						cnt++;
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

	static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int idx = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] % 10 < arr[idx] % 10)
					idx = j;
				else if (arr[j] % 10 == arr[idx] % 10) {
					if (arr[j] < arr[idx])
						idx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
	}
}
