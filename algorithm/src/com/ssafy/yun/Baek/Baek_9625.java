package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_9625 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int K = sc.nextInt();

		int A = 1;
		int B = 0;

		for (int i = 0; i < K; i++) {
			int tempA = A;
			int tempB = B;

			A += tempB - tempA;
			B += tempA;
		}

		System.out.printf("%d %d", A, B);
	}

}
