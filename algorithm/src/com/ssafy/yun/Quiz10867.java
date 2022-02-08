package com.ssafy.yun;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz10867 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int pivot = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != pivot) {
				System.out.print(arr[i] + " ");
				pivot = arr[i];
			}
		}

	}

}
