package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1292 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr = new int[1001];

	public static void main(String[] args) {
		int start = sc.nextInt();
		int end = sc.nextInt();

		outer: for (int i = 1; i < 100; i++) {
			int indexStart = i * (i - 1) / 2 + 1;
			for (int j = indexStart; j < indexStart + i; j++) {
				if (j > 1000) {
					break outer;
				}
				arr[j] = i;
			}
		}

		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
