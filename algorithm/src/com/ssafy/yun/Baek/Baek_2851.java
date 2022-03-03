package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > 100) {
				int disAfter = sum - 100;
				sum -= arr[i];
				int disBefore = 100 - sum;
				if (disAfter <= disBefore) {
					sum += arr[i];
				}
				break;
			}
		}
		System.out.println(sum);

	}

}
