package com.ssafy.an.day049;

import java.util.Scanner;

public class Day27BOJ1463일로만들기 { // 1463 1로 만들기
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(recur(N, 0));
		sc.close();
	}

	static int recur(int N, int count) {
		if (N < 2)
			return count;
		return Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)));
	}
}
