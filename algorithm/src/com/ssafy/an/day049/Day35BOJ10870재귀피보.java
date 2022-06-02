package com.ssafy.an.day049;

import java.util.Scanner;

public class Day35BOJ10870재귀피보 { // 10870 재귀피보
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(recur(N));
		sc.close();
	}

	private static int recur(int n) {
		return (n > 1) ? recur(n - 1) + recur(n - 2) : n;
	}
}
