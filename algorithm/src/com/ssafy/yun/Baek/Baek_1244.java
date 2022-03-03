package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1244 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr;

	public static void main(String[] args) {
		int N = sc.nextInt();
		arr = new int[N + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int order = sc.nextInt();
		for (int i = 0; i < order; i++) {
			doSomething();
		}

		for (int i = 1; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}

	static void doSomething() {
		int gender = sc.nextInt();
		int button = sc.nextInt();

		// 남자
		if (gender == 1) {
			for (int i = 1; i * button <= arr.length - 1; i++) {
				arr[i * button] = (arr[i * button] + 1) % 2;
			}
			return;
		}

		// 여자
		arr[button] = (arr[button] + 1) % 2;
		int left = button;
		int right = button;
		while (true) {
			left--;
			right++;

			if (left == 0) {
				break;
			}

			if (right == arr.length) {
				break;
			}

			if (arr[left] != arr[right]) {
				break;
			}

			arr[left] = (arr[left] + 1) % 2;
			arr[right] = (arr[right] + 1) % 2;
		}
	}
}
