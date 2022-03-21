package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_10817 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[3];

		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		System.out.println(arr[1]);
	}

}
