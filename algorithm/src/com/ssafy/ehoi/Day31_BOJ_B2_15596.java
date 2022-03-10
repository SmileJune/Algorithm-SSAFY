package com.ssafy.ehoi;

import java.util.Scanner;

public class Day31_BOJ_B2_15596 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정수 갯수
		int[] a = new int[n]; // 합을 구해야 하는 정수 n개가 저장된 배열
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}

		System.out.println(sum(a));
		sc.close();
	}

	public static long sum(int[] a) {
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		return sum;
	}
}
