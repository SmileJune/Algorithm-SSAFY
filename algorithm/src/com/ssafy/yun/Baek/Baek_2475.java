package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2475 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr;

	public static void main(String[] args) {
		arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(getNumber());
	}

	static int getNumber() {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (int) Math.pow(arr[i], 2);
		}
		return sum % 10;
	}

}
