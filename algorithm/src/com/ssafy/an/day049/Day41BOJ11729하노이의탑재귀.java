package com.ssafy.an.day049;

import java.util.Scanner;

public class Day41BOJ11729하노이의탑재귀 { // 11729 하노이의 탑 재귀
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt();
		sb.append((1 << N) - 1).append("\n");
		recur(N, 1, 3);
		System.out.println(sb);
		sc.close();
	}

	private static void recur(int n, int st, int ed) {
		if (n == 0)	return;
		recur(n - 1, st, 6 - st - ed);
		sb.append(st).append(" ").append(ed).append("\n");
		recur(n - 1, 6 - st - ed, ed);
	}
}
