package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_2309 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr;
	static int first, second = 0;

	public static void main(String[] args) {
		arr = new int[9];
		int sum = 0;
		int remainder = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		remainder = sum - 100;

		outer: for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == remainder) {
					arr[i] = Integer.MAX_VALUE;
					arr[j] = Integer.MAX_VALUE;
					break outer;
				}
			}
		}

		Arrays.sort(arr);
		for (int i = 0; i < 7; i++) {
			System.out.println(arr[i]);
		}
	}

}
