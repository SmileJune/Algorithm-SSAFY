package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2609_2 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int A = sc.nextInt();
		int B = sc.nextInt();

		int GCD = recur(A, B);
		int LCM = A * B / GCD;

		System.out.println(GCD);
		System.out.println(LCM);
	}

	static int recur(int A, int B) {
		if (B == 0) {
			return A;
		}

		return recur(B, A % B);
	}

}
