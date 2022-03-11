package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2960 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N + 1];

		for (int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}

		int cnt = 0;
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == 0) {
				continue;
			}

			for (int j = 1; j <= 500; j++) {
				if (i * j > arr.length - 1) {
					break;
				}

				if (arr[i * j] == 0) {
					continue;
				}

				cnt++;
				if (cnt == K) {
					System.out.println(arr[i * j]);
					return;
				}
				arr[i * j] = 0;

			}
		}

	}

}
