package com.ssafy.an.day049;

import java.util.Scanner;

public class Day35BOJ10872재귀팩토리얼 { // 10872재귀팩토리얼
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(recur(sc.nextInt()));
		sc.close();
	}

	private static int recur(int n) {
		return n > 1 ? recur(n - 1) * n : 1;
	}
}
