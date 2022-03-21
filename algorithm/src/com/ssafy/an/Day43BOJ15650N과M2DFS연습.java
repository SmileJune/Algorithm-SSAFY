package com.ssafy.an;

import java.util.Scanner;

public class Day43BOJ15650N과M2DFS연습 { // 15650 N과 M DFS
	static int[] arr;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		// 1 포함
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
		} // 1 ~ N포함 까지
		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
	} // 구선생님.. 왜 제껀 틀리나요..
}
