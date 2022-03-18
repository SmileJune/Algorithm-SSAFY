package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_10818 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.printf("%d %d", arr[0], arr[arr.length - 1]);
	}

}
