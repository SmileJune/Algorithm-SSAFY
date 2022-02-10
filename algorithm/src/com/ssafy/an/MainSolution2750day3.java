package com.ssafy.an;

import java.util.Scanner;

public class MainSolution2750day3 { // 2750번 수 정렬하기 기초
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}

		sc.close();
	}
}