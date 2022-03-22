package com.ssafy.an;

import java.util.Scanner;

public class Day43BOJ15651N과M3DFS연습 { // 15651 N과 M(3) DFS
	static int[] arr;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		dfs(0);

		System.out.println(sb);
		sc.close();
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		} // 1 ~ N포함 까지
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
}
