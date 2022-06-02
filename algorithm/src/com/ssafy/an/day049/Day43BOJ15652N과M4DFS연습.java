package com.ssafy.an.day049;

import java.util.Scanner;

public class Day43BOJ15652N과M4DFS연습 { // 15652 N과 M(4) DFS
	static int[] arr;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		dfs(1, 0);

		System.out.println(sb);
		sc.close();
	}

	static void dfs(int at, int depth) {
		if (depth == M) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
		}
	}
}
