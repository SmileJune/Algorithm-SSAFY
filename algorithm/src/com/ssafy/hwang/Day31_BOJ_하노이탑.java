package com.ssafy.hwang;

import java.math.BigInteger;
import java.util.Scanner;

public class Day31_BOJ_하노이탑 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		BigInteger bi = new BigInteger("2");
		BigInteger c = bi.pow(n).subtract(BigInteger.ONE);
		System.out.println(c);

		if (n <= 20)
			hanoi(n, 1, 2, 3);
	}

	public static void hanoi(int n, int start, int temp, int end) {
		if (n == 0)
			return;
		hanoi(n - 1, start, end, temp);
		System.out.println(start + " " + end);
		hanoi(n - 1, temp, start, end);
	}
}
