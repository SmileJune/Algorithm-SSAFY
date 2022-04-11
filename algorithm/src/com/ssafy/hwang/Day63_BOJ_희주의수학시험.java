package com.ssafy.hwang;

import java.util.Scanner;

public class Day63_BOJ_희주의수학시험 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int[] arr = new int[1001];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (((1) + (int) Math.sqrt(1 + (8 * (i - 1)))) / 2);
		}
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}