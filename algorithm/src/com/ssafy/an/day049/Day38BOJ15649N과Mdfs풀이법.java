package com.ssafy.an.day049;

import java.util.Arrays;
import java.util.Scanner;

public class Day38BOJ15649N과Mdfs풀이법 { // 15649 N과 M dfs 1단계
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[M];
		visit = new boolean[N];

		dfs(N, M, 0);
		sc.close();
	}

	private static void dfs(int N, int M, int depth) {
		if (depth == M) {
			System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visit[i] = false;
			} // 재귀로 푸는 법 구선생님 도움..
		}
	}
}
