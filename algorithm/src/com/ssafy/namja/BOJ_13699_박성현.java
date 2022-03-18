package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_13699_박성현 {
	static long[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		arr = new long[n + 1];
		fillArr(n);
		System.out.println(arr[n]);
	}
	
	static void fillArr(int num) {
		for (int i = 0; i <= num; i++) {
			if (arr[i] == 0) {
				if (i == 0 || i == 1) {
					arr[i] = 1;
					continue;
				}
				for (int j = 0; j < i; j++) 
					arr[i] += arr[j] * arr[i - j - 1];
			}
		}
	}
}