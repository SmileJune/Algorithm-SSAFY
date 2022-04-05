package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1182 {

	static Scanner sc = new Scanner(System.in);
	static int n, target, sum, num;
	static int[] arr;

	public static void main(String[] args) {
		n = sc.nextInt();
		target = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		powerSet();
		System.out.println(num);
	}

	static void powerSet() {
		for (int i = 1; i < (1 << n); i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					sum += arr[j];
				}
			}
			if (sum == target) {
				num++;
			}
		}
	}

}
