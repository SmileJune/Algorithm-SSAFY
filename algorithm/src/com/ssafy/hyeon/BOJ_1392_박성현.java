package com.ssafy.hyeon;

import java.util.Scanner;

public class BOJ_1392_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, q;
		int total = 0;
		n = sc.nextInt();
		q = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[q];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
			total += arr1[i];
		}
		int[] arr3 = new int[total];
		int iter, size = 0;
		for (int i = 0; i < n; i++) {
			iter = 0;
			while (true) {
				if (iter++ == arr1[i])
					break;
				arr3[size++] = i+1;
			}
		}
		for (int i = 0; i < q; i++) {
			arr2[i] = arr3[sc.nextInt()];
		}
		for (int i : arr2)
			System.out.println(i);
	}
}
