package com.ssafy.hwang;

import java.util.Scanner;

public class Day31_BOJ_택시기하학 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double n = sc.nextDouble();
		double res1 = (double) (n * n * Math.PI);
		System.out.printf("%.6f\n", res1);
		double res2 = (double) (2 * n * n);
		System.out.printf("%.6f\n", res2);
	}
}
