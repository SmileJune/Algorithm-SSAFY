package com.ssafy.ehoi;

import java.util.Scanner;

public class Day06_BOJ_2750_SelectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}

			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;

		}
		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
		}

		sc.close();
	}
}
